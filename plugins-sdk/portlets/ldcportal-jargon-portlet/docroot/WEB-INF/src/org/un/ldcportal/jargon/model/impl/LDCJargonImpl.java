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

package org.un.ldcportal.jargon.model.impl;

import java.util.Locale;
import java.util.Map;

import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.Validator;

/**
 * The extended model implementation for the LDCJargon service. Represents a row
 * in the &quot;LDCJargon_LDCJargon&quot; database table, with each column
 * mapped to a property of this class. <p> Helper methods and all application
 * logic should be put in this class. Whenever methods are added, rerun
 * ServiceBuilder to copy their definitions into the
 * {@link org.un.ldcportal.jargon.model.LDCJargon} interface. </p>
 * 
 * @author Thibault Boyeux
 */
public class LDCJargonImpl extends LDCJargonBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS: Never reference this class directly. All methods
	 * that expect a l d c jargon model instance should use the {@link
	 * org.un.ldcportal.jargon.model.LDCJargon} interface instead.
	 */
	public LDCJargonImpl() {

	}

	public void setName(String name, Locale locale) {

		setName(name, locale, LocaleUtil.getDefault());
	}

	public void setName(String name, Locale locale, Locale defaultLocale) {

		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(name)) {
			setName(LocalizationUtil.updateLocalization(getName(), "Name", name, languageId, defaultLanguageId));
		}
		else {
			setName(LocalizationUtil.removeLocalization(getName(), "Name", languageId));
		}
	}

	public void setNameMap(Map<Locale, String> nameMap) {

		setNameMap(nameMap, LocaleUtil.getDefault());
	}

	public void setNameMap(Map<Locale, String> nameMap, Locale defaultLocale) {

		if (nameMap == null) {
			return;
		}

		Locale[] locales = LanguageUtil.getAvailableLocales();

		for (Locale locale : locales) {
			String title = nameMap.get(locale);

			setName(title, locale, defaultLocale);
		}

	}

	public void setDefinition(String definition, Locale locale) {

		setDefinition(definition, locale, LocaleUtil.getDefault());
	}

	public void setDefinition(String definition, Locale locale, Locale defaultLocale) {

		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(definition)) {
			setDefinition(LocalizationUtil.updateLocalization(getDefinition(), "Definition", definition, languageId, defaultLanguageId));
		}
		else {
			setDefinition(LocalizationUtil.removeLocalization(getDefinition(), "Definition", languageId));
		}
	}

	public void setDefinitionMap(Map<Locale, String> definitionMap) {

		setDefinitionMap(definitionMap, LocaleUtil.getDefault());
	}

	public void setDefinitionMap(Map<Locale, String> definitionMap, Locale defaultLocale) {

		if (definitionMap == null) {
			return;
		}

		Locale[] locales = LanguageUtil.getAvailableLocales();

		for (Locale locale : locales) {
			String definition = definitionMap.get(locale);

			setDefinition(definition, locale, defaultLocale);
		}
	}
	
	public String getName(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		
		return getName(languageId);
	}
	
	public String getName(String languageId) {
		return LocalizationUtil.getLocalization(getName(),languageId);
	}

	public Map<Locale, String> getNameMap() {

		return LocalizationUtil.getLocalizationMap(getName());
	}
	
	public String getDefinition(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		
		return getDefinition(languageId);
	}
	
	public String getDefinition(String languageId) {
		return LocalizationUtil.getLocalization(getDefinition(),languageId);
	}


	public Map<Locale, String> getDefinitionMap() {

		return LocalizationUtil.getLocalizationMap(getDefinition());
	}

}
