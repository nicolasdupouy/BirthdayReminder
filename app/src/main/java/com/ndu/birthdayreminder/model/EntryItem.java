package com.ndu.birthdayreminder.model;

import java.util.Date;

import android.os.Parcel;
import android.os.Parcelable;

public class EntryItem implements Parcelable {

	private final String firstName;
	private final String lastName;
	private final Date birthdayDate;
	private final String phoneNumber;
	private final String email;

	//private boolean activated;

	public static class Builder {
		private final String firstName;
		private final String lastName;
		private final Date birthdayDate;
		private String phoneNumber = null;
		private String email = null;
		
		public Builder(String firstName, String lastName, Date birthdayDate) {
			this.firstName = firstName;
			this.lastName = lastName;
			this.birthdayDate = birthdayDate;
		}
		public Builder phoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
			return this;
		}
		public Builder email(String email) {
			this.email = email;
			return this;
		}
		public EntryItem build() {
			return new EntryItem(this);
		}
	}
	
	private EntryItem(Builder builder) {
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.birthdayDate = builder.birthdayDate;
		this.phoneNumber = builder.phoneNumber;
		this.email = builder.email;
	}
	
	/*public EntryItem(String firstName, String lastName, Date birthdayDate,
			String phoneNumber, String email, boolean activated) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthdayDate = birthdayDate;
		this.phoneNumber = phoneNumber;
		this.email = email;
		//this.activated = activated;
	}*/

	@Override
	public String toString() {
		return "EntryItem [firstName=" + firstName + ", lastName=" + lastName
				+ ", birthdayDate=" + birthdayDate + ", phoneNumber="
				+ phoneNumber + ", email=" + email /*+ ", activated=" + activated*/
				+ "]";
		/*return firstName + " " 
				+ lastName + " " 
				+ birthdayDate + " "
				+  phoneNumber + " "
				+  email;*/
	}

	/* 
	 * ################
	 * ## Parcelable ##
	 * ################
	 */
	@Override
	public int describeContents() {
		// On renvoie 0 car notre classe ne contient pas de FileDescriptor
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(firstName);
		dest.writeString(lastName);
		//if (birthdayDate != null) {
			dest.writeLong(birthdayDate.getTime());
		//}
		dest.writeString(phoneNumber);
		dest.writeString(email);
	}

	public static final Parcelable.Creator<EntryItem> CREATOR = new Parcelable.Creator<EntryItem>() {
		public EntryItem createFromParcel(Parcel in) {
			return new EntryItem(in);
		}

		public EntryItem[] newArray(int size) {
			return new EntryItem[size];
		}
	};

	private EntryItem(Parcel in) {
		this.firstName = in.readString();
		this.lastName = in.readString();
		this.birthdayDate = new Date(in.readLong());
		this.phoneNumber = in.readString();
		this.email = in.readString();
		
	}


	/*private static EntryItem getNew() {
		EntryItem entryItem = new EntryItem();

		return entryItem;
	}*/


	/* 
	 * #############
	 * ## Getters ##
	 * #############
	 */
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
}
