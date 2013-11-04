package com.nicolasdupouy.birthdayreminder.data;

import java.util.Date;

public class EntryItem {

	private String name;
	private String description;
	private Date date;
	private boolean activated;
	
	//private EntryItem() {}
	
	public EntryItem(String name, String description, Date date,
			boolean activated) {
		super();
		this.name = name;
		this.description = description;
		this.date = date;
		this.activated = activated;
	}
	
	/*private static EntryItem getNew() {
		EntryItem entryItem = new EntryItem();
		
		return entryItem;
	}*/

}
