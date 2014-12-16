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

package org.un.ldcportal.jargon.model;

import com.liferay.portal.model.PersistedModel;

/**
 * The extended model interface for the LDCJargon service. Represents a row in the &quot;LDCJargon_LDCJargon&quot; database table, with each column mapped to a property of this class.
 *
 * @author Thibault Boyeux
 * @see LDCJargonModel
 * @see org.un.ldcportal.jargon.model.impl.LDCJargonImpl
 * @see org.un.ldcportal.jargon.model.impl.LDCJargonModelImpl
 * @generated
 */
public interface LDCJargon extends LDCJargonModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link org.un.ldcportal.jargon.model.impl.LDCJargonImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public void setName(java.lang.String name, java.util.Locale locale);

	public void setName(java.lang.String name, java.util.Locale locale,
		java.util.Locale defaultLocale);

	public void setNameMap(
		java.util.Map<java.util.Locale, java.lang.String> nameMap);

	public void setNameMap(
		java.util.Map<java.util.Locale, java.lang.String> nameMap,
		java.util.Locale defaultLocale);

	public void setDefinition(java.lang.String definition,
		java.util.Locale locale);

	public void setDefinition(java.lang.String definition,
		java.util.Locale locale, java.util.Locale defaultLocale);

	public void setDefinitionMap(
		java.util.Map<java.util.Locale, java.lang.String> definitionMap);

	public void setDefinitionMap(
		java.util.Map<java.util.Locale, java.lang.String> definitionMap,
		java.util.Locale defaultLocale);

	public java.lang.String getName(java.util.Locale locale);

	public java.lang.String getName(java.lang.String languageId);

	public java.util.Map<java.util.Locale, java.lang.String> getNameMap();

	public java.lang.String getDefinition(java.util.Locale locale);

	public java.lang.String getDefinition(java.lang.String languageId);

	public java.util.Map<java.util.Locale, java.lang.String> getDefinitionMap();
}