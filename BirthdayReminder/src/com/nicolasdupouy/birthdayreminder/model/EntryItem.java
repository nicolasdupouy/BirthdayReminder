package com.nicolasdupouy.birthdayreminder.model;

import java.util.Date;

public class EntryItem {

	private String firstName;
	private String lastName;
	private Date birthdayDate;
	private String phoneNumber;
	private String email;
	
	//private boolean activated;

	public EntryItem(String firstName, String lastName, Date birthdayDate,
			String phoneNumber, String email, boolean activated) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthdayDate = birthdayDate;
		this.phoneNumber = phoneNumber;
		this.email = email;
		//this.activated = activated;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Date getBirthdayDate() {
		return birthdayDate;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		/*return "EntryItem [firstName=" + firstName + ", lastName=" + lastName
				+ ", birthdayDate=" + birthdayDate + ", phoneNumber="
				+ phoneNumber + ", email=" + email + ", activated=" + activated
				+ "]";*/
		return firstName + " " + lastName;
	}
	
	
	//private EntryItem() {}
	
	
	
	
	/*private static EntryItem getNew() {
		EntryItem entryItem = new EntryItem();
		
		return entryItem;
	}*/

}
