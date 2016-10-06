package com.digi.util;

import org.joda.time.format.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Created by tymoshenkol on 06-Oct-16.
 */
public class DateUtil {
	private static final SimpleDateFormat timeFt = new SimpleDateFormat("(hh:mm:ss)");
	private static final SimpleDateFormat dateFt = new SimpleDateFormat("dd/MM/yyyy");


	public static String ddMMyyyy(Date date){
		return dateFt.format(date);
	}

	public static String getTimeStr(Date date){
		return timeFt.format(date);
	}

	public static String getCurrentTimeStr(){
		return getTimeStr(new Date());
	}

}
