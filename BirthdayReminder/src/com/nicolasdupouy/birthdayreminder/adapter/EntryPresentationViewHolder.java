package com.nicolasdupouy.birthdayreminder.adapter;


import com.example.birthdayreminder.R;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * The ViewHolder pattern
 *
 */
public class EntryPresentationViewHolder {
	
	public ImageView photo; 
	public TextView fullName;
	public TextView birthdayDate;
	
	public EntryPresentationViewHolder(View convertView) {
		this.photo = (ImageView)convertView.findViewById(R.id.photo);
		this.fullName = (TextView)convertView.findViewById(R.id.fullname);
		this.birthdayDate = (TextView)convertView.findViewById(R.id.birthdayDate);
	}
	
	//public void setPhoto()
	
	public void setFullName(String fullName) {
		this.fullName.setText(fullName);
	}
	
	public void setBirthdayDate(String birthdayDate) {
		
		this.birthdayDate.setText(birthdayDate);
	}
}
