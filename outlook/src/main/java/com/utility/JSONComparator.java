package com.utility;

import java.util.Comparator;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class JSONComparator implements Comparator<String> {

	public int compare(String arg0, String arg1) {
		// TODO Auto-generated method stub
		 JsonParser parser = new JsonParser();
		 JsonElement o1 = parser.parse("{\"state\":1,\"cmd\":1}");
		 JsonElement o2 = parser.parse("{\"cmd\":1,\"state\":1}");
		if(o1.equals(o2))
			return 1;
		return 0;
	}
}
