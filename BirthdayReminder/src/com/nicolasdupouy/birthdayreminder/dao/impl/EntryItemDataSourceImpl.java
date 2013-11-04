package com.nicolasdupouy.birthdayreminder.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.nicolasdupouy.birthdayreminder.dao.EntryItemDataSource;
import com.nicolasdupouy.birthdayreminder.data.EntryItem;

public class EntryItemDataSourceImpl implements EntryItemDataSource {

	/* ################
	 * ## TEMPORAIRE ##
	 * ################
	 */
	private static final List<EntryItem> defaultEntryList = new ArrayList<EntryItem>();
	static {
		defaultEntryList.add(new EntryItem("Bob", "Bob le premier", new Date(), true));
		defaultEntryList.add(new EntryItem("Martin", "Martin le second", new Date(), true));
	}
	/* ################ */
	
	
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

