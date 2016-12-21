package com.wenka.matcher.pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <a href="https://www.taobao.com/markets/xie/nvxie/index" data-cid="1"
 * data-dataid="222886">Ьѥ</a> /
 * 
 * @author wenka
 *
 */
public class TestMatcher {

	public static final String PATTERN_A = ">(.+?)</a>";// ƥ��A��ǩ
	public static final String PATTERN_HREF = "href=\"(.+?)\"";// ƥ�䳬����
	public static final String PATTERN_A_ONLY_TEXT = ">([\u4e00-\u9fa5]{0,})</a>";// ƥ��A��ǩֻ���ı�������

	public static void main(String[] args) {

		String s = "<a href=\"https://www.taobao.com/markets/xie/nvxie/index\" data-cid=\"1\" data-dataid=\"222886\">Ьѥ</a>";
		// https://www.taobao.com/markets/xie/nvxie/index
		regexString(s, PATTERN_HREF);

		regexString(s, PATTERN_A);
	}

	public static int regexString(String targetStr, String patternStr) {

		int count = 0;// ƥ�����

		Pattern pattern = Pattern.compile(patternStr);

		Matcher matcher = pattern.matcher(targetStr);

		// ���ƥ�䣬��Ѱ����һ��
		while (matcher.find()) {
			count++;
			System.out.print(matcher.group(1) + "\t");
			if (count % 5 == 0) {
				System.out.println();
			}
		}

		System.out.println("End...");
		return count;
	}

}
