package com.nicolasdupouy.birthdayreminder.dao.impl;

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

import com.nicolasdupouy.birthdayreminder.dao.EntryItemDataSource;
import com.nicolasdupouy.birthdayreminder.model.EntryItem;
import com.nicolasdupouy.birthdayreminder.tools.BirthdayReminderConstants;

public class EntryItemDataSourceImpl extends Activity implements EntryItemDataSource {

	
	
	private static final List<EntryItem> defaultEntryList = new ArrayList<EntryItem>();
	static {
		defaultEntryList.add(new EntryItem("Hanounti", "Dupouy", new Date(), "0622002583", "hanane.moualil@gmail.com", true));
		defaultEntryList.add(new EntryItem("Nicolas", "Dupouy", new Date(), "0682717585", "nicolasdupouy@gmail.com", true));
		defaultEntryList.add(new EntryItem("Jacques-Abdel", "Dupouy", new Date(), null, null, true));
		defaultEntryList.add(new EntryItem("Jean-Mohamed", "Dupouy", new Date(), null, null, true));
		defaultEntryList.add(new EntryItem("Marie-Fatima", "Dupouy", new Date(), null, null, true));
		
		defaultEntryList.add(new EntryItem("Nom-1", "Prenom-1", new Date(), "0622002583", "hanane.moualil@gmail.com", true));
		/*defaultEntryList.add(new EntryItem("Nom-2", "Prenom-2", new Date(), "0622002583", "hanane.moualil@gmail.com", true));
		defaultEntryList.add(new EntryItem("Nom-3", "Prenom-3", new Date(), "0622002583", "hanane.moualil@gmail.com", true));
		defaultEntryList.add(new EntryItem("Nom-4", "Prenom-4", new Date(), "0622002583", "hanane.moualil@gmail.com", true));
		defaultEntryList.add(new EntryItem("Nom-5", "Prenom-5", new Date(), "0622002583", "hanane.moualil@gmail.com", true));
		defaultEntryList.add(new EntryItem("Nom-6", "Prenom-6", new Date(), "0622002583", "hanane.moualil@gmail.com", true));
		defaultEntryList.add(new EntryItem("Nom-7", "Prenom-7", new Date(), "0622002583", "hanane.moualil@gmail.com", true));
		defaultEntryList.add(new EntryItem("Nom-8", "Prenom-8", new Date(), "0622002583", "hanane.moualil@gmail.com", true));
		defaultEntryList.add(new EntryItem("Nom-9", "Prenom-9", new Date(), "0622002583", "hanane.moualil@gmail.com", true));
		defaultEntryList.add(new EntryItem("Nom-10", "Prenom-10", new Date(), "0622002583", "hanane.moualil@gmail.com", true));
		defaultEntryList.add(new EntryItem("Nom-11", "Prenom-11", new Date(), "0622002583", "hanane.moualil@gmail.com", true));
		defaultEntryList.add(new EntryItem("Nom-12", "Prenom-12", new Date(), "0622002583", "hanane.moualil@gmail.com", true));
		defaultEntryList.add(new EntryItem("Nom-13", "Prenom-13", new Date(), "0622002583", "hanane.moualil@gmail.com", true));
		defaultEntryList.add(new EntryItem("Nom-14", "Prenom-14", new Date(), "0622002583", "hanane.moualil@gmail.com", true));*/
	}
	
	
	@Override
	public List<EntryItem> findAll() {
		return defaultEntryList;
		//return null;
	}
	@Override
	public boolean add(EntryItem entryItem) {
		Toast.makeText(EntryItemDataSourceImpl.this, "Vous voulez ajouter une entrée ! : " + entryItem, Toast.LENGTH_SHORT)
		 .show();
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
	
	private void readInternalFile() {
		try {
			FileInputStream internalInputFile =  openFileInput(getEntriesStorageFileName());
			int value;
			StringBuffer stringBuffer = new StringBuffer();

			while( (value = internalInputFile.read()) != -1 ) {
				stringBuffer.append((char)value);
			}

			Toast.makeText(EntryItemDataSourceImpl.this, "Interne: " + stringBuffer.toString(), Toast.LENGTH_SHORT)
			.show();

			if (internalInputFile != null) {
				internalInputFile.close();
			}

		} catch (FileNotFoundException e) {
			Toast.makeText(EntryItemDataSourceImpl.this, "Le fichier interne " + getEntriesStorageFileName() + " n'existe pas !", Toast.LENGTH_SHORT)
			.show();
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 */
	private void writeInternalFile() {
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

