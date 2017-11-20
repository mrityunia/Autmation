package com.utility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;



public class JSONMain {
	public static String getMethods(String urlInput) throws Exception {
		URL url = new URL(urlInput);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");
		conn.addRequestProperty("User-Agent", "Mozilla/4.0");

		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
		}
		else{
			
			System.out.println(conn.getResponseCode());
		}
		BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
		String output;
		while ((output = br.readLine()) != null) {
			return output;
		}
		conn.disconnect();
		return null;
	}
	
	
	public static void postmethod(String urlInput) throws IOException{
		URL url;
		try {
			url = new URL(urlInput);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			
			
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Accept", "application/json");
			conn.addRequestProperty("User-Agent", "Mozilla/4.0");

			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
	}
}
