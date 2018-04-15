package com.ndu.birthdayreminder.business.impl;

import android.content.Context;
import android.widget.Toast;

import com.ndu.birthdayreminder.business.RowActionTypeEnum;
import com.ndu.birthdayreminder.business.RowAction;
import com.ndu.birthdayreminder.model.EntryItem;

public class RowActionImpl implements RowAction {

	private Context context = null;

	public RowActionImpl(Context context) {
		this.context = context;
	}

	@Override
	public void actionOnRowClick(RowActionTypeEnum actionTypeEnum,
			EntryItem entryItem) {
		switch(actionTypeEnum) {
		case CHANGE_PHOTO:
			changePhoto(entryItem);
			break;
		case CALL_PHONE:
			callPhone(entryItem);
			break;
		case SEND_MESSAGE:
			sendMessage(entryItem);
			break;
		default:
			break;
		}
	}

	private void changePhoto(EntryItem entryItem) {
		Toast.makeText(context, "Change photo of " + entryItem, Toast.LENGTH_SHORT)
		.show();
	}

	private void callPhone(EntryItem entryItem) {
		Toast.makeText(context, "Call to : " + entryItem, Toast.LENGTH_SHORT)
		.show();
	}

	private void sendMessage(EntryItem entryItem) {
		Toast.makeText(context, "Message to : " + entryItem, Toast.LENGTH_SHORT)
		.show();
	}
}
