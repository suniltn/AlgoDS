package com.chandra.structures.arraysANDstrings;

public class URLify {
	
	public static String urlify(String s, int len) {
		char[] url = s.toCharArray();
		int i = s.length()-1;
		url[len] = '\0';
		for (int j = len-1;j>=0;j--) {
			if (url[j] != ' ') {
				url[i] = url[j];
				i--;
			} else {
				url[i] = '0';
				url[i-1] = '2';
				url[i-2] = '%';
				i = i-3;
			}
		}
		return String.valueOf(url);
	}
	
	public static void main(String[] args) {
		String url = "Mr John Smith    ";
		System.out.println(urlify(url, 13));
	}

}
