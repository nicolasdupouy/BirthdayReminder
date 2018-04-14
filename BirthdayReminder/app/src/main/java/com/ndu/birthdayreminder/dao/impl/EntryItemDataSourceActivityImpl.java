package com.ndu.birthdayreminder.dao.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.app.Activity;
import android.provider.SyncStateContract.Constants;
import android.widget.Toast;

import com.ndu.birthdayreminder.dao.EntryItemDataSourceActivity;
import com.ndu.birthdayreminder.model.EntryItem;
import com.ndu.birthdayreminder.tools.BirthdayReminderConstants;

public class EntryItemDataSourceActivityImpl extends Activity implements EntryItemDataSourceActivity {

	private ArrayList<EntryItem> entriesItemList = new ArrayList<EntryItem>();
	
	@Override
	public List<EntryItem> findAll() {
		return new ArrayList<EntryItem>();
	}
	@Override
	public boolean add(EntryItem entryItem) {
		/*Toast.makeText(EntryItemDataSourceActivityImpl.this, "Vous voulez ajouter une entr�e ! : " + entryItem, Toast.LENGTH_SHORT)
		 .show();*/
		entriesItemList.add(entryItem);
		return false;
	}
	@Override
	public boolean remove(EntryItem entryItem) {
		return false;
	}
	
	@Override
	public String getEntriesStorageFileName() {
		return BirthdayReminderConstants.ENTRIES_STORAGE_FILENAME;
	}
	
	@Override
	public void readInternalFile() {
		try {
			FileInputStream internalInputFile =  openFileInput(getEntriesStorageFileName());
			int value;
			StringBuffer stringBuffer = new StringBuffer();

			while( (value = internalInputFile.read()) != -1 ) {
				stringBuffer.append((char)value);
			}

			Toast.makeText(EntryItemDataSourceActivityImpl.this, "Interne: " + stringBuffer.toString(), Toast.LENGTH_SHORT)
			.show();

			if (internalInputFile != null) {
				internalInputFile.close();
			}

		} catch (FileNotFoundException e) {
			Toast.makeText(EntryItemDataSourceActivityImpl.this, "Le fichier interne " + getEntriesStorageFileName() + " n'existe pas !", Toast.LENGTH_SHORT)
			.show();
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 */
	@Override
	public void writeInternalFile() {
		try {
			FileOutputStream internalOutputFile =  openFileOutput(getEntriesStorageFileName(), MODE_PRIVATE);
			//internalOutputFile.write(monPseudo.getBytes());
			
			if (internalOutputFile != null) {
				internalOutputFile.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

