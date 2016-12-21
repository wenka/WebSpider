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
		String result = "";// ��Ŷ�ȡ������
		URL u = null;
		URLConnection urlConnection = null;

		InputStreamReader inputStreamReader = null;
		BufferedReader bufferedReader = null;

		try {
			u = new URL(url);// ���� URL

			// ����һ�� URLConnection ��������ʾ�� URL �����õ�Զ�̶��������
			urlConnection = u.openConnection();

			// �򿪵��� URL ���õ���Դ��ͨ�����ӣ������δ�������������ӣ���
			urlConnection.connect();

			// ��ȡ��ҳ������
			inputStreamReader = new InputStreamReader(urlConnection.getInputStream());
			bufferedReader = new BufferedReader(inputStreamReader);

			// ��ȡ
			String line;// ÿһ�е����ݡ����ж�ȡ
			int i = 0;// ��¼����
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
			// �ر���
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
			// new String(content.getBytes(), "utf-8")ת��
			TestMatcher.regexString(new String(content.getBytes(), "utf-8"), TestMatcher.PATTERN_A_ONLY_TEXT);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

}
