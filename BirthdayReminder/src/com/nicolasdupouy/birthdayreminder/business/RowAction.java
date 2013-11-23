package com.nicolasdupouy.birthdayreminder.business;

import com.nicolasdupouy.birthdayreminder.model.EntryItem;

public interface RowAction {

	public void actionOnRowClick(RowActionTypeEnum actionTypeEnum, EntryItem entryItem);
	/*public void actionOnClickListenerPhoto(EntryItem entryItem);
	public void actionOnClickListenerPhone(EntryItem entryItem);
	public void actionOnClickListenerMessage(EntryItem entryItem);*/
}
