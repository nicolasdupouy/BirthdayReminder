package com.nicolasdupouy.birthdayreminder.activity;

import java.text.ParseException;
import java.util.Date;

import com.nicolasdupouy.birthdayreminder.R;
import com.nicolasdupouy.birthdayreminder.model.EntryItem;
import com.nicolasdupouy.birthdayreminder.tools.BirthdayReminderConstants;
import com.nicolasdupouy.birthdayreminder.tools.Util;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class AddEntryActivity extends Activity {

	private EditText firstNameEditText = null;
	private EditText lastNameEditText = null;
	private EditText birthdayDateEditText = null;
	private EditText phoneNumberEditText = null;
	private EditText emailEditText = null;
	private Button save = null;
	private Button clean = null;
	
	// listener for save Button
		private OnClickListener saveOnClickListener = new OnClickListener() {
			@Override
			public void onClick(View v) {
				/*String res = firstNameEditText.getText().toString() + " " 
				+ lastNameEditText.getText().toString();*/
				Date birthdayDate = null;
				try {
					birthdayDate = Util.stringToDate(birthdayDateEditText.getText().toString());
				} catch (ParseException e) {
					Log.d(BirthdayReminderConstants.LOG_TAG_PARSE_DATE, e.getMessage());
					//e.printStackTrace();
				}
				EntryItem entryItem = new EntryItem.Builder(firstNameEditText.getText().toString(),
															lastNameEditText.getText().toString())
														.birthdayDate(birthdayDate)
														.phoneNumber(phoneNumberEditText.getText().toString())
														.email(emailEditText.getText().toString())
														.build();
				//entryItem.setBirthdayDate(birthdayDateEditText.getText().toString());
				Intent i = new Intent();
				i.putExtra(BirthdayReminderConstants.CREATE_ENTRY_INTENT_EXCHANGE, entryItem);
				setResult(RESULT_OK, i);
				finish();
			}
		};
		
	// listener for clean Button
	private OnClickListener cleanOnClickListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			firstNameEditText.getText().clear();
			lastNameEditText.getText().clear();
			birthdayDateEditText.getText().clear();
			phoneNumberEditText.getText().clear();
			emailEditText.getText().clear();
		}
	};

		
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.add_entry_layout);
	        
	        firstNameEditText = (EditText)findViewById(R.id.firstName);
	        lastNameEditText = (EditText)findViewById(R.id.lastName);
	        birthdayDateEditText = (EditText)findViewById(R.id.birthdayDate);
	        phoneNumberEditText = (EditText)findViewById(R.id.phoneNumber);
	        emailEditText = (EditText)findViewById(R.id.email);
	        save = (Button)findViewById(R.id.save);
	        save.setOnClickListener(saveOnClickListener);
	        
	        clean = (Button)findViewById(R.id.clean);
	        clean.setOnClickListener(cleanOnClickListener);
	        
	 }
}
