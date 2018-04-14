package com.ndu.birthdayreminder.adapter;

import java.text.DateFormat;
import java.util.List;

import com.ndu.birthdayreminder.business.RowActionTypeEnum;
import com.ndu.birthdayreminder.business.RowAction;
import com.ndu.birthdayreminder.business.impl.RowActionImpl;
import com.nicolasdupouy.birthdayreminder.model.EntryItem;
import com.nicolasdupouy.birthdayreminder.tools.Util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;

public class EntryPresentationAdapter extends ArrayAdapter<EntryItem> {

	private RowAction entryItemRowActions = null;
	private LayoutInflater layoutInflater = null;
	private int textViewResourceId = 0;

	public EntryPresentationAdapter(Context context, int textViewResourceId,
			List<EntryItem> objects) {
		super(context, textViewResourceId, objects);
		this.entryItemRowActions = new RowActionImpl(context);
		layoutInflater = LayoutInflater.from(context);
		this.textViewResourceId = textViewResourceId;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		EntryPresentationViewHolder entryPresentationViewHolder = null;
		if (convertView != null) {
			entryPresentationViewHolder = (EntryPresentationViewHolder)convertView.getTag();
		}
		else {
			convertView = (RelativeLayout)layoutInflater.inflate(this.textViewResourceId, null);
			entryPresentationViewHolder = new EntryPresentationViewHolder(convertView);

			convertView.setTag(entryPresentationViewHolder);

			// Photo ImageButton
			entryPresentationViewHolder.getImageButtonPhoto().setOnClickListener( createActionOnClickListener(RowActionTypeEnum.CHANGE_PHOTO) );
			// Photo ImageButton
			entryPresentationViewHolder.getImageButtonPhone().setOnClickListener( createActionOnClickListener(RowActionTypeEnum.CALL_PHONE) );
			// Message ImageButton
			entryPresentationViewHolder.getImageButtonMessage().setOnClickListener( createActionOnClickListener(RowActionTypeEnum.SEND_MESSAGE) );
		}
		
		EntryItem entryItem = (EntryItem)getItem(position);
		if (entryItem != null) {
			entryPresentationViewHolder.setTag(position);
			entryPresentationViewHolder.setFullName(getFullName(entryItem));
			entryPresentationViewHolder.setBirthdayDate(getBirthdayDate(entryItem));
		}

		return convertView;
	}

	private String getFullName(EntryItem entryItem) {
		return entryItem.getLastName() + " " + entryItem.getFirstName();
	}

	private String getBirthdayDate(EntryItem entryItem) {
		/*DateFormat dateFormat = DateFormat.getDateInstance();
		return dateFormat.format(entryItem.getBirthdayDate());*/
		return Util.dateToString(entryItem.getBirthdayDate());

	}

	private OnClickListener createActionOnClickListener(final RowActionTypeEnum actionTypeEnum) {
		return new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Integer myPosition = (Integer)v.getTag();
				EntryItem entryItem = getItem(myPosition);
				if (entryItem != null) {
					entryItemRowActions.actionOnRowClick(actionTypeEnum, entryItem);
				}
			}
		};
	}

	/*public void sort() {
		super.sort(new FileComparator());
	}*/
}
