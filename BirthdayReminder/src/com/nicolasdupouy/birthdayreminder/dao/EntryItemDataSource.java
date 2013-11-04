package com.nicolasdupouy.birthdayreminder.dao;

import java.util.List;

import com.nicolasdupouy.birthdayreminder.data.EntryItem;

public interface EntryItemDataSource {

	public List<EntryItem> findAll();
	public boolean update(EntryItem entryItem);
	public boolean remove(EntryItem entryItem);
}
