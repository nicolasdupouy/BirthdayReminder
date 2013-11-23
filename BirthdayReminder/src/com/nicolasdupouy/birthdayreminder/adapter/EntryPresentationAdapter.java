package com.nicolasdupouy.birthdayreminder.adapter;

import java.text.SimpleDateFormat;
import java.util.List;

import com.nicolasdupouy.birthdayreminder.model.EntryItem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class EntryPresentationAdapter extends ArrayAdapter<EntryItem> {

	//private static final String dateFormatPattern = "yyyy-MM-dd HH:mm:ss Z";
	private static final String dateFormatPattern = "dd/MM/yyyy";
	
	private Context birthdayReminderMainActivityContext = null;
	private LayoutInflater layoutInflater = null;
	private int textViewResourceId = 0;
	
	public EntryPresentationAdapter(Context context, int textViewResourceId,
			List<EntryItem> objects) {
		super(context, textViewResourceId, objects);
		this.birthdayReminderMainActivityContext = context;
		layoutInflater = LayoutInflater.from(context);
		this.textViewResourceId = textViewResourceId;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		//EntryItem entryItem = (EntryItem)getItem(position);
		EntryPresentationViewHolder entryPresentationViewHolder = null;
		if (convertView != null) {
			entryPresentationViewHolder = (EntryPresentationViewHolder)convertView.getTag();
		}
		else {
			convertView = (RelativeLayout)layoutInflater.inflate(this.textViewResourceId, null);
			entryPresentationViewHolder = new EntryPresentationViewHolder(convertView);
			
			convertView.setTag(entryPresentationViewHolder);
			
			// Photo ImageButton
			entryPresentationViewHolder.getImageButtonPhoto().setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					//EntryItem entryItem = getModel(...)
					//EntryItem entryItem = (EntryItem)getItem(position);
					Integer myPosition = (Integer)v.getTag();
					EntryItem entryItem = getItem(myPosition);
					if (entryItem != null) {
						actionOnClickListenerPhoto(entryItem);
					}
				}
			});
			
			// Photo ImageButton
			entryPresentationViewHolder.getImageButtonPhone().setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Integer myPosition = (Integer)v.getTag();
					EntryItem entryItem = getItem(myPosition);
					if (entryItem != null) {
						actionOnClickListenerPhone(entryItem);
					}
				}
			});
			
			// Message ImageButton
			entryPresentationViewHolder.getImageButtonMessage().setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Integer myPosition = (Integer)v.getTag();
					EntryItem entryItem = getItem(myPosition);
					if (entryItem != null) {
						actionOnClickListenerMessage(entryItem);
					}
				}
			});
		}

		EntryItem entryItem = (EntryItem)getItem(position);
		if (entryItem != null) {
			entryPresentationViewHolder.setTag(position);
			//entryPresentationViewHolder.setPositionInList(position);
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
	
	//private OnClickListener 
	
	private void actionOnClickListenerPhoto(EntryItem entryItem) {
		Toast.makeText(birthdayReminderMainActivityContext, "Change photo of " + entryItem, Toast.LENGTH_SHORT)
		 .show();
	}
	
	private void actionOnClickListenerPhone(EntryItem entryItem) {
		Toast.makeText(birthdayReminderMainActivityContext, "Call to : " + entryItem, Toast.LENGTH_SHORT)
		 .show();
	}
	
	private void actionOnClickListenerMessage(EntryItem entryItem) {
		Toast.makeText(birthdayReminderMainActivityContext, "Message to : " + entryItem, Toast.LENGTH_SHORT)
		 .show();
	}
	
	/*public void sort() {
		super.sort(new FileComparator());
	}*/
}
