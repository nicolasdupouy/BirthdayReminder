package com.nicolasdupouy.birthdayreminder.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.nicolasdupouy.birthdayreminder.dao.EntryItemDataSource;
import com.nicolasdupouy.birthdayreminder.model.EntryItem;

public class EntryItemDataSourceImpl implements EntryItemDataSource {

	private static final List<EntryItem> defaultEntryList = new ArrayList<EntryItem>();
	static {
		defaultEntryList.add(new EntryItem("Hanounti", "Dupouy", new Date(), "0622002583", "hanane.moualil@gmail.com", true));
		defaultEntryList.add(new EntryItem("Nicolas", "Dupouy", new Date(), "0682717585", "nicolasdupouy@gmail.com", true));
		defaultEntryList.add(new EntryItem("Jacques-Abdel", "Dupouy", new Date(), null, null, true));
		defaultEntryList.add(new EntryItem("Jean-Mohamed", "Dupouy", new Date(), null, null, true));
		defaultEntryList.add(new EntryItem("Marie-Fatima", "Dupouy", new Date(), null, null, true));
	}
	
	
	@Override
	public List<EntryItem> findAll() {
		return defaultEntryList;
	}
	@Override
	public boolean add(EntryItem entryItem) {
		/*Toast.makeText(BirthdayReminderMainActivity.this, "Vous voulez ajouter une entrée !", Toast.LENGTH_SHORT)
		 .show();*/
		return false;
	}
	@Override
	public boolean remove(EntryItem entryItem) {
		return false;
	}
}

