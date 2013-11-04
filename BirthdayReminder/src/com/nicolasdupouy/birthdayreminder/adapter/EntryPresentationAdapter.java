package com.nicolasdupouy.birthdayreminder.adapter;

import java.util.List;

import android.content.Context;
import android.widget.ArrayAdapter;

public class EntryPresentationAdapter extends ArrayAdapter<String /*object représentant mes entrées birthday*/> {

	public EntryPresentationAdapter(Context context, int textViewResourceId,
			List<String> objects, int color) {
		super(context, textViewResourceId, objects);
		/*layoutInflater = LayoutInflater.from(context);
		this.textViewResourceId = textViewResourceId;
		this.color = color;*/
	}
}
