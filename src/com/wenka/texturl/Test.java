package com.wenka.texturl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import com.wenka.matcher.pattern.TestMatcher;

public class Test {

	public static String getContent(String url) {
		String result = "";// 存放读取的内容
		URL u = null;
		URLConnection urlConnection = null;

		InputStreamReader inputStreamReader = null;
		BufferedReader bufferedReader = null;

		try {
			u = new URL(url);// 创建 URL

			// 返回一个 URLConnection 对象，它表示到 URL 所引用的远程对象的连接
			urlConnection = u.openConnection();

			// 打开到此 URL 引用的资源的通信链接（如果尚未建立这样的连接）。
			urlConnection.connect();

			// 获取网页输入流
			inputStreamReader = new InputStreamReader(urlConnection.getInputStream());
			bufferedReader = new BufferedReader(inputStreamReader);

			// 读取
			String line;// 每一行的内容。按行读取
			int i = 0;// 记录行数
			while ((line = bufferedReader.readLine()) != null) {
				i++;
				result += line + "\n";
			}
			System.out.println(i);

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 关闭流
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
		String content = getContent("https://www.taobao.com/");
		try {
			// new String(content.getBytes(), "utf-8")转码
			TestMatcher.regexString(new String(content.getBytes(), "utf-8"), TestMatcher.PATTERN_A_ONLY_TEXT);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

}
