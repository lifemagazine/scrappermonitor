package com.lifemagazine.scrappermonitor.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Utility {

	public static String getCurrentTime(Calendar calendar) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		if (calendar == null) calendar = Calendar.getInstance(java.util.Locale.KOREA);

		return format.format(calendar.getTime());
	}

	public static boolean isNumeric(String str) {
		if (str == null) return false;
		return str.matches("-?\\d+(\\.\\d+)?");
	}
}
