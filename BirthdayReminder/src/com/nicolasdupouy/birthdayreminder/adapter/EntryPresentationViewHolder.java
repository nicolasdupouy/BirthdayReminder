package com.nicolasdupouy.birthdayreminder.adapter;


import com.example.birthdayreminder.R;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * The ViewHolder pattern
 *
 */
public class EntryPresentationViewHolder {
	
	//private int positionInList = 0;
	private ImageButton photo; 
	private TextView fullName;
	private TextView birthdayDate;
	private ImageButton phoneButton = null;
	private ImageButton messageButton = null;
	
	public EntryPresentationViewHolder(View convertView) {
		this.photo = (ImageButton)convertView.findViewById(R.id.photo);
		this.fullName = (TextView)convertView.findViewById(R.id.fullname);
		this.birthdayDate = (TextView)convertView.findViewById(R.id.birthdayDate);
		this.phoneButton = (ImageButton)convertView.findViewById(R.id.phoneButton);
		this.messageButton = (ImageButton)convertView.findViewById(R.id.messageButton);
	}
	
	//public void setPhoto()
	
	/*public void setPositionInList(int positionInList) {
		this.positionInList = positionInList;
	}
	
	public int getPositionInList() {
		return positionInList;
	}*/
	
	/**
	 * Tag = position of the entry in the list.
	 * @param positionInList
	 */
	public void setTag(int positionInList) {
		this.photo.setTag(positionInList);
		this.phoneButton.setTag(positionInList);
		this.messageButton.setTag(positionInList);
	}
	/*public void setPhotoTag(int positionInList) {
		this.photo.setTag(positionInList);
	}
	public void setPhoneTag(int positionInList) {
		this.phoneButton.setTag(positionInList);
	}
	public void setMessageTag(int positionInList) {
		this.messageButton.setTag(positionInList);
	}*/
	
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
		return phoneButton;
	}
	
	public ImageButton getImageButtonMessage() {
		return messageButton;
	}
	
	/*public void setPhone(String phone) {
		this.fullName.setText(fullName);
	}*/
}
