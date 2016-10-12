package com.digi.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by tymoshenkol on 06-Oct-16.
 */
public class DateUtil {
	private static final SimpleDateFormat timeFt = new SimpleDateFormat("(hh:mm:ss)");
	private static final SimpleDateFormat dateFt = new SimpleDateFormat("dd/MM/yyyy");


	public static String ddMMyyyy (Date date) {
		return dateFt.format(date);
	}

	public static String getTimeStr (Date date) {
		return timeFt.format(date);
	}

	public static String getCurrentTimeStr () {
		return getTimeStr(Calendar.getInstance().getTime());
	}

}
