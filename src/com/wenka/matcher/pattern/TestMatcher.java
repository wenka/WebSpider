package com.wenka.matcher.pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <a href="https://www.taobao.com/markets/xie/nvxie/index" data-cid="1"
 * data-dataid="222886">鞋靴</a> /
 * 
 * @author wenka
 *
 */
public class TestMatcher {

	public static final String PATTERN_A = ">(.+?)</a>";// 匹配A标签
	public static final String PATTERN_HREF = "href=\"(.+?)\"";// 匹配超链接
	public static final String PATTERN_A_ONLY_TEXT = ">([\u4e00-\u9fa5]{0,})</a>";// 匹配A标签只有文本的内容

	public static void main(String[] args) {

		String s = "<a href=\"https://www.taobao.com/markets/xie/nvxie/index\" data-cid=\"1\" data-dataid=\"222886\">鞋靴</a>";
		// https://www.taobao.com/markets/xie/nvxie/index
		regexString(s, PATTERN_HREF);

		regexString(s, PATTERN_A);
	}

	public static int regexString(String targetStr, String patternStr) {

		int count = 0;// 匹配个数

		Pattern pattern = Pattern.compile(patternStr);

		Matcher matcher = pattern.matcher(targetStr);

		// 如果匹配，则寻找下一个
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
