package com.nicolasdupouy.birthdayreminder.screen;

import java.util.List;

import com.nicolasdupouy.birthdayreminder.R;
import com.nicolasdupouy.birthdayreminder.adapter.EntryPresentationAdapter;
import com.nicolasdupouy.birthdayreminder.dao.EntryItemDataSourceActivity;
import com.nicolasdupouy.birthdayreminder.dao.impl.EntryItemDataSourceActivityImpl;
import com.nicolasdupouy.birthdayreminder.model.EntryItem;
import com.nicolasdupouy.birthdayreminder.tools.BirthdayReminderConstants;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;
import android.app.ListActivity;
import android.content.Intent;

public class BirthdayReminderMainActivity extends ListActivity {

	private ListView listView = null;
	private EntryPresentationAdapter entryPresentationAdapter = null;
	
	private List<EntryItem> entryItemsList = null;
	private EntryItemDataSourceActivity entryItemDataSource = new EntryItemDataSourceActivityImpl();
	
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
    
    @Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {

		if (requestCode == BirthdayReminderConstants.CREATE_ENTRY_INTENT_REQUEST
				&& resultCode == RESULT_OK) {
			EntryItem entryItem = data.getParcelableExtra(BirthdayReminderConstants.CREATE_ENTRY_INTENT_EXCHANGE);
			/*Toast.makeText(this, 
							"Entrée ajoutée: " + entryItem, 
							Toast.LENGTH_SHORT)
							.show();*/
			
			entryItemDataSource.add(entryItem);
		}
	}
    
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
			//Intent/Activity/Ecran pour ajouter une entrée !
			Intent secondActivity = new Intent(BirthdayReminderMainActivity.this, AddEntryActivity.class);
			startActivityForResult(secondActivity, BirthdayReminderConstants.CREATE_ENTRY_INTENT_REQUEST);
			
			/*Bundle data = getIntent().getExtras();
			EntryItem entryItem = (EntryItem) data.getParcelable(BirthdayReminderConstants.CREATE_ENTRY_INTENT_EXCHANGE);
			
			//EntryItem entryItem = secondActivity.getParcelableExtra(BirthdayReminderConstants.CREATE_ENTRY_INTENT_EXCHANGE);
			entryItemDataSource.add(entryItem);*/
			return true;

		case R.id.reset:
			//initAdapter();
			return true;
		}
		
		return super.onOptionsItemSelected(item);
	}
}
