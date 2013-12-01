package com.nicolasdupouy.birthdayreminder.dao;

import java.util.List;

import com.nicolasdupouy.birthdayreminder.model.EntryItem;

public interface EntryItemDataSourceActivity {

	public List<EntryItem> findAll();
	public boolean add(EntryItem entryItem);
	public boolean remove(EntryItem entryItem);
	public String getEntriesStorageFileName();
	
	public void readInternalFile();
	public void writeInternalFile();
}
