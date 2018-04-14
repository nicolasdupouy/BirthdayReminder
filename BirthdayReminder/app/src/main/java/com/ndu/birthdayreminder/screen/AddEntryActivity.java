package com.ndu.birthdayreminder.screen;

import java.util.Calendar;

import com.nicolasdupouy.birthdayreminder.R;
import com.nicolasdupouy.birthdayreminder.model.EntryItem;
import com.nicolasdupouy.birthdayreminder.tools.BirthdayReminderConstants;
import com.nicolasdupouy.birthdayreminder.tools.Util;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

public class AddEntryActivity extends Activity {

	private EditText firstNameEditText = null;
	private EditText lastNameEditText = null;
	private Button birthdayDateButton = null;
	private EditText phoneNumberEditText = null;
	private EditText emailEditText = null;
	private Button save = null;
	private Button clean = null;
	
	private boolean dateNotSet = true;

	Calendar dateAndTime = Calendar.getInstance();
	private DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {

		public void onDateSet(DatePicker view, 
							  int year, 
							  int monthOfYear,
							  int dayOfMonth) {
			dateAndTime.set(Calendar.YEAR, year);
			dateAndTime.set(Calendar.MONTH, monthOfYear);
			dateAndTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);
			dateNotSet = false;
			
			birthdayDateButton.setText( Util.dateToString(dateAndTime.getTime()) );
		}
    	
    };
    
    public void chooseBirthdayDate(View v) {
    	new DatePickerDialog(AddEntryActivity.this, 
    			dateSetListener, 
    			dateAndTime.get(Calendar.YEAR),
    			dateAndTime.get(Calendar.MONTH),
    			dateAndTime.get(Calendar.DAY_OF_MONTH))
    	.show();
    }
    
	// listener for save Button
	private OnClickListener saveOnClickListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			boolean firstNameAndlastNameEmpty = false;
			
			String firstNameStr = firstNameEditText.getText().toString();
			String lastNameStr = lastNameEditText.getText().toString();
			String phoneNumberStr = phoneNumberEditText.getText().toString();
			String emailStr = emailEditText.getText().toString();
			
			if ((firstNameStr == null || BirthdayReminderConstants.EMPTY_STRING.equals(firstNameStr))
					&& (lastNameStr == null || BirthdayReminderConstants.EMPTY_STRING.equals(lastNameStr))) {
				firstNameAndlastNameEmpty = true;
			}

			if (firstNameAndlastNameEmpty || dateNotSet) {
				SpannableStringBuilder message = new SpannableStringBuilder();
				if (firstNameAndlastNameEmpty) {
					Util.appendMsgWithLineBreak(message, getResources().getString(R.string.ADD_ENTRY_ACTIVITY_MSG_NAME_EMPTY));
				}
				if (dateNotSet) {
					Util.appendMsgWithLineBreak(message, getResources().getString(R.string.ADD_ENTRY_ACTIVITY_MSG_DATE_NOT_SET));
				}
				
				Toast.makeText(AddEntryActivity.this, message, Toast.LENGTH_LONG)
				.show();
			}
			else {
				EntryItem entryItem = new EntryItem.Builder(firstNameStr, lastNameStr, dateAndTime.getTime())
													.phoneNumber(phoneNumberStr)
													.email(emailStr)
													.build();
				Intent i = new Intent();
				i.putExtra(BirthdayReminderConstants.CREATE_ENTRY_INTENT_EXCHANGE, entryItem);
				setResult(RESULT_OK, i);
				finish();
			}
			
		}
	};

	// listener for clean Button
	private OnClickListener cleanOnClickListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			firstNameEditText.getText().clear();
			lastNameEditText.getText().clear();
			birthdayDateButton.setText(R.string.enterDate);
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
		birthdayDateButton = (Button)findViewById(R.id.birthdayDateButton);
		phoneNumberEditText = (EditText)findViewById(R.id.phoneNumber);
		emailEditText = (EditText)findViewById(R.id.email);
		save = (Button)findViewById(R.id.save);
		save.setOnClickListener(saveOnClickListener);

		clean = (Button)findViewById(R.id.clean);
		clean.setOnClickListener(cleanOnClickListener);

	}
}
