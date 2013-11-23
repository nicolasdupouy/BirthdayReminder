package com.nicolasdupouy.birthdayreminder.activity;

import java.util.List;

import com.example.birthdayreminder.R;
import com.nicolasdupouy.birthdayreminder.adapter.EntryPresentationAdapter;
import com.nicolasdupouy.birthdayreminder.dao.EntryItemDataSource;
import com.nicolasdupouy.birthdayreminder.dao.impl.EntryItemDataSourceImpl;
import com.nicolasdupouy.birthdayreminder.model.EntryItem;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.app.ListActivity;

public class BirthdayReminderMainActivity extends ListActivity {

	//private TextView selection = null;
	
	private ListView listView = null;
	private EntryPresentationAdapter entryPresentationAdapter = null;
	
	private List<EntryItem> entryItemsList = null;
	private EntryItemDataSource entryItemDataSource = new EntryItemDataSourceImpl();
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.birthday_reminder_main_activity);
        
        //selection = (TextView)findViewById(R.id.selection);
        
        listView = (ListView) getListView();
        entryItemsList = entryItemDataSource.findAll();
        entryPresentationAdapter = new EntryPresentationAdapter(this, R.layout.list_item_layout, entryItemsList);
        listView.setAdapter(entryPresentationAdapter);
        
        //setListAdapter(entryPresentationAdapter);
        //entryPresentationAdapter.sort();
        //refreshDisplay();
    }
    
    
    
    
    
    
    
    
    public EntryItem getModel(int position) {
    	return(((EntryPresentationAdapter)getListAdapter()).getItem(position));
    }
    
    /*@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		//selection.setText(items[position]);
    	selection.setText(getModel(position).getFirstName());
	}*/

   /* private void refreshDisplay() {
		entryItemsList = entryItemDataSource.findAll();
		/*ArrayAdapter<EntryItem> adapter =
				new ArrayAdapter<EntryItem>(this, R.layout.list_item_layout, entryItemsList);
		setListAdapter(adapter);* /
		//listView.setAdapter(adapter);
	}*/
    
    
    /* ##################
     * ## OPTIONS Menu ##
     * ##################
     */
    
    /**
     * 
     */
    @Override
	public boolean onCreateOptionsMenu(Menu menu) {
		
    	new MenuInflater(this).inflate(R.menu.option, menu);
		return super.onCreateOptionsMenu(menu);
	}
    
    /**
     * 
     */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		switch (item.getItemId()) {
		case R.id.add:
			//add();
			entryItemDataSource.add(null);
			return true;

		case R.id.reset:
			//initAdapter();
			return true;
		}
		
		return super.onOptionsItemSelected(item);
	}
}
