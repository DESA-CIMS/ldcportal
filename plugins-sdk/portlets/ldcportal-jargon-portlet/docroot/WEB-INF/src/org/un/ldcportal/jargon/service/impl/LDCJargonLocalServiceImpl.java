/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package org.un.ldcportal.jargon.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.un.ldcportal.jargon.model.LDCJargon;
import org.un.ldcportal.jargon.service.base.LDCJargonLocalServiceBaseImpl;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

/**
 * The implementation of the l d c jargon local service. <p> All custom service
 * methods should be put in this class. Whenever methods are added, rerun
 * ServiceBuilder to copy their definitions into the
 * {@link org.un.ldcportal.jargon.service.LDCJargonLocalService} interface. <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM. </p>
 * 
 * @author Thibault Boyeux
 * @see org.un.ldcportal.jargon.service.base.LDCJargonLocalServiceBaseImpl
 * @see org.un.ldcportal.jargon.service.LDCJargonLocalServiceUtil
 */
public class LDCJargonLocalServiceImpl extends LDCJargonLocalServiceBaseImpl {

	// For regex testing purposes only

//	public static void main(String[] args) {
//
//		LDCJargonLocalServiceImpl jargonServ = new LDCJargonLocalServiceImpl();
//
//		// TODO Auto-generated method stub
//		String text =
//			"<p> \n Rep. of Korea notifies <span class=\"caps\">WTO</span> "
//				+ "that it provides <span class= \"caps\">DFQF</span> for LDCs <a href=\"oo\">wto</a> up to 95 per cent of wto total tariff lines</p> "
//				+ "\n <p> \n	Source: <a href=\"http://www.wto.org/english/news_e/news12_e/acc_16apr12_e.htm\" "
//				+ "onclick=\"window.open(this.href, '', "
//				+ "'resizable=yes,status=yes,location=yes,toolbar=yes,menubar=yes,fullscreen=no,scrollbars=yes,"
//				+ "dependent=no,width=800,left=800,height=800,top=800'); return false;\"> a WTO b</a></p>";
//
//		Map<String, String> jargonMap = new HashMap<String, String>();
//		jargonMap.put("wto", "World Trade Organization");
//		jargonMap.put("cent", "some shit");
//		jargonMap.put("95", "ninety-five");
//
//		System.out.println("Start: " + text);
//		System.out.println("\n\n");
//		// System.out.println("End: " + newTooltip("WTO", text));
//		System.out.println("End: " + jargonServ.tooltipJargon(text, jargonMap, "<a class=\"tooltip\">", "<span>", "</span></a>"));
//	}
//
//	public static String newTooltip(String jargon, String text) {
//
//		String result = StringPool.BLANK;
//		int flags = Pattern.CANON_EQ | Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE;
//
//		String patternString2 = "(?<!<a.+)" + Pattern.quote(jargon);
//		String patternString = "(?!<.*?)\\b(" + Pattern.quote(jargon) + ")\\b(?![^<>]*?(</a>|>))";
//		System.out.println("PatternString: " + patternString + "\n");
//
//		Pattern pattern = Pattern.compile(patternString, flags);
//
//		Matcher matcher = pattern.matcher(text);
//
//		result = matcher.replaceAll("lol");
//
//		return result;
//	}

	/*
	 * NOTE FOR DEVELOPERS: Never reference this interface directly. Always use
	 * {@link org.un.ldcportal.jargon.service.LDCJargonLocalServiceUtil} to
	 * access the l d c jargon local service.
	 */

	public LDCJargon addLDCJargon(LDCJargon newLDCJargon)
		throws SystemException {

		LDCJargon ldcJargon = ldcJargonPersistence.create(counterLocalService.increment(LDCJargon.class.getName()));

		ldcJargon.setName(newLDCJargon.getName());
		ldcJargon.setDefinition(newLDCJargon.getDefinition());
		ldcJargon.setCompanyId(newLDCJargon.getCompanyId());
		ldcJargon.setGroupId(newLDCJargon.getGroupId());

		return ldcJargonPersistence.update(ldcJargon, false);
	}

	public List<LDCJargon> getAllLDCJargons(long groupId)
		throws SystemException {

		List<LDCJargon> ldcJargons = ldcJargonPersistence.findByGroupId(groupId);

		return ldcJargons;
	}

	/**
	 * Returns LDC Jargon in a specified locale as HashMap where the key is the
	 * name of the jargon and the value is the definition
	 * 
	 * @param groupdId
	 * @param locale
	 * @return HashMap<name, value>
	 * @throws SystemException
	 */
	public HashMap<String, String> getAllLDCJargonMapByLocale(long groupdId, Locale locale)
		throws SystemException {

		List<LDCJargon> ldcJargons = getAllLDCJargons(groupdId);

		HashMap<String, String> resultMap = new HashMap<String, String>();

		for (LDCJargon ldcJargon : ldcJargons) {
			resultMap.put(ldcJargon.getName(locale).toLowerCase(), ldcJargon.getDefinition(locale));
		}

		return resultMap;
	}

	public String tooltipJargon(String s, Map<String, String> jargonMap, String start1, String start2, String end) {

		if (Validator.isNull(s) || Validator.isNull(jargonMap)) {
			return s;
		}

		if (jargonMap.isEmpty()) {
			return StringPool.BLANK;
		}

		StringBundler sb = new StringBundler(2 * jargonMap.size() - 1);

		int i = 0;

		for (Map.Entry<String, String> jargon : jargonMap.entrySet()) {
			// Pattern checking that the word is not part of an link tag
			String patternString = "(?!<.*?)\\b("+ Pattern.quote(jargon.getKey()) + ")\\b(?![^<>]*?(</a>|>))";
			sb.append(patternString);

			if ((i + 1) < jargonMap.size()) {
				sb.append(StringPool.PIPE);
			}

			i++;
		}

		int flags = Pattern.CANON_EQ | Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE;

		Pattern pattern = Pattern.compile(sb.toString(), flags);
		
		Matcher matcher = pattern.matcher(s);
		
		StringBuffer result = new StringBuffer(s);
		
		int addedLength = 0;
		
		while (matcher.find()) {
			String replaceString = start1 + matcher.group() + start2 + jargonMap.get(matcher.group().toLowerCase()) + end;
			
//			System.out.print("Start index: " + matcher.start());
//			System.out.print(" End index: " + matcher.end() + " ");
//			System.out.println(matcher.group());
			
			result.replace(addedLength + matcher.start(), addedLength + matcher.end(), replaceString);
			
			addedLength += replaceString.length() - matcher.end() + matcher.start();
			
			s = result.toString();
		}

		return result.toString();
	}

//	public String _tooltipJargon(
//		String s, Map<String, String> jargonMap, Pattern pattern, String start1, String start2, String end) {
//
//		StringTokenizer st = new StringTokenizer(s);
//
//		if (st.countTokens() == 0) {
//			return StringPool.BLANK;
//		}
//
//		StringBundler sb = new StringBundler(2 * st.countTokens() - 1);
//
//		while (st.hasMoreTokens()) {
//			String token = st.nextToken();
//
//			Matcher matcher = pattern.matcher(token);
//
//			if (matcher.find()) {
//				StringBuffer tooltipped = new StringBuffer();
//
//				do {
//					System.out.println("matcher " + matcher.group());
//					matcher.appendReplacement(
//						tooltipped, start1 + matcher.group() + start2 + jargonMap.get(matcher.group().toLowerCase()) + end);
//				}
//				while (matcher.find());
//
//				matcher.appendTail(tooltipped);
//
//				sb.append(tooltipped);
//			}
//			else {
//				sb.append(token);
//			}
//
//			if (st.hasMoreTokens()) {
//				sb.append(StringPool.SPACE);
//			}
//		}
//
//		return sb.toString();
//	}
}
