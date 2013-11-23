package com.nicolasdupouy.birthdayreminder.dao;

import java.util.List;

import com.nicolasdupouy.birthdayreminder.model.EntryItem;

public interface EntryItemDataSource {

	public List<EntryItem> findAll();
	public boolean add(EntryItem entryItem);
	public boolean remove(EntryItem entryItem);
}
