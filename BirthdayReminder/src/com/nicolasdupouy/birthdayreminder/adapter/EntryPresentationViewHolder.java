package com.nicolasdupouy.birthdayreminder.adapter;


import com.example.birthdayreminder.R;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * The ViewHolder pattern
 *
 */
public class EntryPresentationViewHolder {
	
	private ImageButton photo; 
	private TextView fullName;
	private TextView birthdayDate;
	private ImageButton phone = null;
	private ImageButton message = null;
	
	public EntryPresentationViewHolder(View convertView) {
		this.photo = (ImageButton)convertView.findViewById(R.id.photo);
		this.fullName = (TextView)convertView.findViewById(R.id.fullname);
		this.birthdayDate = (TextView)convertView.findViewById(R.id.birthdayDate);
		this.phone = (ImageButton)convertView.findViewById(R.id.phoneButton);
		this.message = (ImageButton)convertView.findViewById(R.id.messageButton);
	}
	
	/**
	 * Tag = position of the entry in the list.
	 * @param positionInList
	 */
	public void setTag(int positionInList) {
		this.photo.setTag(positionInList);
		this.phone.setTag(positionInList);
		this.message.setTag(positionInList);
		/* Not necessary for the moment to tag the full name and teh birthday date.
		 * They are not clickables */
		/*this.fullName.setTag(positionInList);
		this.message.setTag(positionInList);*/
	}
	
	public void setFullName(String fullName) {
		this.fullName.setText(fullName);
	}
	
	public void setBirthdayDate(String birthdayDate) {
		this.birthdayDate.setText(birthdayDate);
	}
	
	public ImageButton getImageButtonPhoto() {
		return photo;
	}
	
	public ImageButton getImageButtonPhone() {
		return phone;
	}
	
	public ImageButton getImageButtonMessage() {
		return message;
	}
}
