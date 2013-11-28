package com.nicolasdupouy.birthdayreminder.tools;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

public class Util {

	public static Date stringToDate(String dateStr) throws ParseException {
		DateFormat dateFormat = DateFormat.getDateInstance();
		return dateFormat.parse(dateStr);
	}

	public static String dateToString(Date date) {
		DateFormat dateFormat = DateFormat.getDateInstance();
		return dateFormat.format(date);
	}
}
