package com.vti.Utils;

public class Utils {
	public static String formatSearch(String search) {
		search = search.trim();
		while (search.contains("  ")) {
			search = search.replace("  ", " ");
		}

		return search;
	}
}
