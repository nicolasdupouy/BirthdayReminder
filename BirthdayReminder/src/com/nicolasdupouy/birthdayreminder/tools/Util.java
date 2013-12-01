package com.nicolasdupouy.birthdayreminder.tools;

import java.text.DateFormat;
import java.util.Date;

import android.text.SpannableStringBuilder;

public final class Util {

	private Util() {}
	
	/*public static Date stringToDate(String dateStr) throws ParseException {
		DateFormat dateFormat = DateFormat.getDateInstance();
		return dateFormat.parse(dateStr);
	}*/
	
	/*public static Date createDate(int year, int month, int dayOfMonth) {
		DateFormat dateFormat = DateFormat.getDateInstance();
		Calendar c = dateFormat.getCalendar();
		c.set(year, month, dayOfMonth);
		return c.getTime();
	}*/

	public static String dateToString(Date date) {
		DateFormat dateFormat = DateFormat.getDateInstance();
		return dateFormat.format(date);
	}
	
	public static void appendMsgWithLineBreak(SpannableStringBuilder message, String messageRessource) {
		if (!BirthdayReminderConstants.EMPTY_STRING.equals(message)) {
			message.append(BirthdayReminderConstants.LINE_BREAK);
		}
		message.append(messageRessource);
	}
}
