package com.wenka.texturl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Test {

	public static String getContent(String url) {
		String result = "";
		URL u = null;
		URLConnection urlConnection = null;
		
		InputStreamReader inputStreamReader = null;
		BufferedReader bufferedReader = null;
		
		
		try {
			u = new URL(url);

			urlConnection = u.openConnection();
			urlConnection.connect();
			
			inputStreamReader = new InputStreamReader(urlConnection.getInputStream());
			bufferedReader = new BufferedReader(inputStreamReader);
			
			String line;
			
			while ((line = bufferedReader.readLine()) != null) {
				result += line + "\n";
			}
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				inputStreamReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			try {
				bufferedReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	public static void main(String[] args) {
		String content = getContent("http://www.baidu.com");
		try {
			System.out.println(new String(content.getBytes(), "utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
}
