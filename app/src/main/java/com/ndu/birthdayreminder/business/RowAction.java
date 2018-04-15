package com.ndu.birthdayreminder.business;

import com.ndu.birthdayreminder.model.EntryItem;

public interface RowAction {

	public void actionOnRowClick(RowActionTypeEnum actionTypeEnum, EntryItem entryItem);
	/*public void actionOnClickListenerPhoto(EntryItem entryItem);
	public void actionOnClickListenerPhone(EntryItem entryItem);
	public void actionOnClickListenerMessage(EntryItem entryItem);*/
}
