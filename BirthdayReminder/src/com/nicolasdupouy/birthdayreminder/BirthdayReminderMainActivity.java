package com.nicolasdupouy.birthdayreminder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.birthdayreminder.R;
import com.nicolasdupouy.birthdayreminder.adapter.EntryPresentationAdapter;
import com.nicolasdupouy.birthdayreminder.data.EntryItem;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.app.Activity;
import android.app.ListActivity;

public class BirthdayReminderMainActivity extends ListActivity {

	/* ################
	 * ## TEMPORAIRE ##
	 * ################
	 */
	
	
	//private Button buttonTestIntentWithReturn = null;
	
	/* ################ */
	
	private ListView listView = null;
	private EntryPresentationAdapter entryPresentationAdapter = null;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.birthday_reminder_main_activity);
        
        listView = (ListView) getListView();
    }
}
