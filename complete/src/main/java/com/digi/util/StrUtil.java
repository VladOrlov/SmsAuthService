package com.digi.util;

/**
 * Created by tymoshenkol on 17-Oct-16.
 */
public class StrUtil {

	public static String clearNonDigit (String str) {
		return str.replaceAll("[^\\p{IsDigit}]", "");
	}

	public static String clearNonAlphabetic (String str) {
		return str.replaceAll("[^\\p{IsAlphabetic}]", "");
	}

	public static String clearNonAlphabeticNonDigit (String str) {
		return str.replaceAll("[^\\p{IsAlphabetic}^\\p{IsDigit}]", "");
	}
}
