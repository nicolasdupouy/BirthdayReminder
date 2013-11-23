package com.nicolasdupouy.birthdayreminder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.birthdayreminder.R;
import com.nicolasdupouy.birthdayreminder.adapter.EntryPresentationAdapter;
import com.nicolasdupouy.birthdayreminder.dao.EntryItemDataSource;
import com.nicolasdupouy.birthdayreminder.dao.impl.EntryItemDataSourceImpl;
import com.nicolasdupouy.birthdayreminder.data.EntryItem;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.app.Activity;
import android.app.ListActivity;

public class BirthdayReminderMainActivity extends ListActivity {

	private ListView listView = null;
	private EntryPresentationAdapter entryPresentationAdapter = null;
	
	private List<EntryItem> entryItemsList = null;
	private EntryItemDataSource entryItemDataSource = new EntryItemDataSourceImpl();
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.birthday_reminder_main_activity);
        
        listView = (ListView) getListView();
        entryItemsList = entryItemDataSource.findAll();
        entryPresentationAdapter = new EntryPresentationAdapter(this, R.layout.list_item_layout, entryItemsList);
        listView.setAdapter(entryPresentationAdapter);
        //entryPresentationAdapter.sort();
        //refreshDisplay();
    }
    
    private void refreshDisplay() {
		entryItemsList = entryItemDataSource.findAll();
		/*ArrayAdapter<EntryItem> adapter =
				new ArrayAdapter<EntryItem>(this, R.layout.list_item_layout, entryItemsList);
		setListAdapter(adapter);*/
		//listView.setAdapter(adapter);
	}
}
