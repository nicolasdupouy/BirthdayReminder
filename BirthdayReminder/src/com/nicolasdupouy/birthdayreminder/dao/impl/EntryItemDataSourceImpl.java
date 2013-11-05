package com.nicolasdupouy.birthdayreminder.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.nicolasdupouy.birthdayreminder.dao.EntryItemDataSource;
import com.nicolasdupouy.birthdayreminder.data.EntryItem;

public class EntryItemDataSourceImpl implements EntryItemDataSource {

	private static final List<EntryItem> defaultEntryList = new ArrayList<EntryItem>();
	static {
		defaultEntryList.add(new EntryItem("Hanounti", "Dupouy", new Date(), "0622002583", "hanane.moualil@gmail.com", true));
		defaultEntryList.add(new EntryItem("Nicolas", "Dupouy", new Date(), "0682717585", "nicolasdupouy@gmail.com", true));
		defaultEntryList.add(new EntryItem("Pierre-Amédée", "Dupouy", new Date(), "0682717585", "nicolasdupouy@gmail.com", true));
		defaultEntryList.add(new EntryItem("Jean-Mohamed", "Dupouy", new Date(), "0682717585", "nicolasdupouy@gmail.com", true));
	}
	
	
	@Override
	public List<EntryItem> findAll() {
		return defaultEntryList;
	}
	@Override
	public boolean update(EntryItem entryItem) {
		return false;
	}
	@Override
	public boolean remove(EntryItem entryItem) {
		return false;
	}
}

