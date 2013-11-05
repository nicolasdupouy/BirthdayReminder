package com.nicolasdupouy.birthdayreminder.adapter;

import java.text.SimpleDateFormat;
import java.util.List;

import com.nicolasdupouy.birthdayreminder.data.EntryItem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class EntryPresentationAdapter extends ArrayAdapter<EntryItem> {

	//private static final String dateFormatPattern = "yyyy-MM-dd HH:mm:ss Z";
	private static final String dateFormatPattern = "dd/MM/yyyy";
	
	private LayoutInflater layoutInflater = null;
	private int textViewResourceId = 0;
	
	public EntryPresentationAdapter(Context context, int textViewResourceId,
			List<EntryItem> objects) {
		super(context, textViewResourceId, objects);
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
			convertView = (LinearLayout)layoutInflater.inflate(this.textViewResourceId, null);
			entryPresentationViewHolder = new EntryPresentationViewHolder(convertView);
			
			convertView.setTag(entryPresentationViewHolder);
		}

		EntryItem entryItem = (EntryItem)getItem(position);
		if (entryItem != null) {
			entryPresentationViewHolder.setFullName(getFullName(entryItem));
			entryPresentationViewHolder.setBirthdayDate(getBirthdayDate(entryItem));
		}
		
		return convertView;
	}

	private String getFullName(EntryItem entryItem) {
		return entryItem.getLastName() + " " + entryItem.getFirstName();
	}
	
	private String getBirthdayDate(EntryItem entryItem) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormatPattern);
		return simpleDateFormat.format(entryItem.getBirthdayDate());
		
	}
	
	
	/*public void sort() {
		super.sort(new FileComparator());
	}*/
}
