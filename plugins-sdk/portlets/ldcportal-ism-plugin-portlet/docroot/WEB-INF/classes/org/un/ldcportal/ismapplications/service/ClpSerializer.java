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

package org.un.ldcportal.ismapplications.service;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import org.un.ldcportal.ismapplications.model.ISMApplicationClp;
import org.un.ldcportal.ismapplications.model.ISMClp;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class ClpSerializer {
	public static String getServletContextName() {
		if (Validator.isNotNull(_servletContextName)) {
			return _servletContextName;
		}

		synchronized (ClpSerializer.class) {
			if (Validator.isNotNull(_servletContextName)) {
				return _servletContextName;
			}

			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Class<?> portletPropsClass = classLoader.loadClass(
						"com.liferay.util.portlet.PortletProps");

				Method getMethod = portletPropsClass.getMethod("get",
						new Class<?>[] { String.class });

				String portletPropsServletContextName = (String)getMethod.invoke(null,
						"ldcportal-ism-plugin-portlet-deployment-context");

				if (Validator.isNotNull(portletPropsServletContextName)) {
					_servletContextName = portletPropsServletContextName;
				}
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info(
						"Unable to locate deployment context from portlet properties");
				}
			}

			if (Validator.isNull(_servletContextName)) {
				try {
					String propsUtilServletContextName = PropsUtil.get(
							"ldcportal-ism-plugin-portlet-deployment-context");

					if (Validator.isNotNull(propsUtilServletContextName)) {
						_servletContextName = propsUtilServletContextName;
					}
				}
				catch (Throwable t) {
					if (_log.isInfoEnabled()) {
						_log.info(
							"Unable to locate deployment context from portal properties");
					}
				}
			}

			if (Validator.isNull(_servletContextName)) {
				_servletContextName = "ldcportal-ism-plugin-portlet";
			}

			return _servletContextName;
		}
	}

	public static void setClassLoader(ClassLoader classLoader) {
		_classLoader = classLoader;
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(ISMClp.class.getName())) {
			return translateInputISM(oldModel);
		}

		if (oldModelClassName.equals(ISMApplicationClp.class.getName())) {
			return translateInputISMApplication(oldModel);
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInputISM(BaseModel<?> oldModel) {
		ISMClp oldCplModel = (ISMClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.un.ldcportal.ismapplications.model.impl.ISMImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setIsmId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getIsmId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setWebContentId",
						new Class[] { Long.TYPE });

				Long value1 = new Long(oldCplModel.getWebContentId());

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setModeratorId",
						new Class[] { Long.TYPE });

				Long value2 = new Long(oldCplModel.getModeratorId());

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setCompanyId",
						new Class[] { Long.TYPE });

				Long value3 = new Long(oldCplModel.getCompanyId());

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setGroupId",
						new Class[] { Long.TYPE });

				Long value4 = new Long(oldCplModel.getGroupId());

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setMbCategoryId",
						new Class[] { Long.TYPE });

				Long value5 = new Long(oldCplModel.getMbCategoryId());

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setAssetCategoryId",
						new Class[] { Long.TYPE });

				Long value6 = new Long(oldCplModel.getAssetCategoryId());

				method6.invoke(newModel, value6);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateInputISMApplication(BaseModel<?> oldModel) {
		ISMApplicationClp oldCplModel = (ISMApplicationClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("org.un.ldcportal.ismapplications.model.impl.ISMApplicationImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setUuid",
						new Class[] { String.class });

				String value0 = oldCplModel.getUuid();

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setIsmApplicationId",
						new Class[] { Long.TYPE });

				Long value1 = new Long(oldCplModel.getIsmApplicationId());

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setCountry",
						new Class[] { String.class });

				String value2 = oldCplModel.getCountry();

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setIsmId",
						new Class[] { Long.TYPE });

				Long value3 = new Long(oldCplModel.getIsmId());

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setStatus",
						new Class[] { Integer.TYPE });

				Integer value4 = new Integer(oldCplModel.getStatus());

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setStatusByUserId",
						new Class[] { Long.TYPE });

				Long value5 = new Long(oldCplModel.getStatusByUserId());

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setStatusByUserName",
						new Class[] { String.class });

				String value6 = oldCplModel.getStatusByUserName();

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setStatusDate",
						new Class[] { Date.class });

				Date value7 = oldCplModel.getStatusDate();

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setCompanyId",
						new Class[] { Long.TYPE });

				Long value8 = new Long(oldCplModel.getCompanyId());

				method8.invoke(newModel, value8);

				Method method9 = newModelClass.getMethod("setGroupId",
						new Class[] { Long.TYPE });

				Long value9 = new Long(oldCplModel.getGroupId());

				method9.invoke(newModel, value9);

				Method method10 = newModelClass.getMethod("setUserId",
						new Class[] { Long.TYPE });

				Long value10 = new Long(oldCplModel.getUserId());

				method10.invoke(newModel, value10);

				Method method11 = newModelClass.getMethod("setApplicationReason",
						new Class[] { String.class });

				String value11 = oldCplModel.getApplicationReason();

				method11.invoke(newModel, value11);

				Method method12 = newModelClass.getMethod("setApplicationAdditional",
						new Class[] { String.class });

				String value12 = oldCplModel.getApplicationAdditional();

				method12.invoke(newModel, value12);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(
					"org.un.ldcportal.ismapplications.model.impl.ISMImpl")) {
			return translateOutputISM(oldModel);
		}

		if (oldModelClassName.equals(
					"org.un.ldcportal.ismapplications.model.impl.ISMApplicationImpl")) {
			return translateOutputISMApplication(oldModel);
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutputISM(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				ISMClp newModel = new ISMClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getIsmId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setIsmId(value0);

				Method method1 = oldModelClass.getMethod("getWebContentId");

				Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

				newModel.setWebContentId(value1);

				Method method2 = oldModelClass.getMethod("getModeratorId");

				Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

				newModel.setModeratorId(value2);

				Method method3 = oldModelClass.getMethod("getCompanyId");

				Long value3 = (Long)method3.invoke(oldModel, (Object[])null);

				newModel.setCompanyId(value3);

				Method method4 = oldModelClass.getMethod("getGroupId");

				Long value4 = (Long)method4.invoke(oldModel, (Object[])null);

				newModel.setGroupId(value4);

				Method method5 = oldModelClass.getMethod("getMbCategoryId");

				Long value5 = (Long)method5.invoke(oldModel, (Object[])null);

				newModel.setMbCategoryId(value5);

				Method method6 = oldModelClass.getMethod("getAssetCategoryId");

				Long value6 = (Long)method6.invoke(oldModel, (Object[])null);

				newModel.setAssetCategoryId(value6);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateOutputISMApplication(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				ISMApplicationClp newModel = new ISMApplicationClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getUuid");

				String value0 = (String)method0.invoke(oldModel, (Object[])null);

				newModel.setUuid(value0);

				Method method1 = oldModelClass.getMethod("getIsmApplicationId");

				Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

				newModel.setIsmApplicationId(value1);

				Method method2 = oldModelClass.getMethod("getCountry");

				String value2 = (String)method2.invoke(oldModel, (Object[])null);

				newModel.setCountry(value2);

				Method method3 = oldModelClass.getMethod("getIsmId");

				Long value3 = (Long)method3.invoke(oldModel, (Object[])null);

				newModel.setIsmId(value3);

				Method method4 = oldModelClass.getMethod("getStatus");

				Integer value4 = (Integer)method4.invoke(oldModel,
						(Object[])null);

				newModel.setStatus(value4);

				Method method5 = oldModelClass.getMethod("getStatusByUserId");

				Long value5 = (Long)method5.invoke(oldModel, (Object[])null);

				newModel.setStatusByUserId(value5);

				Method method6 = oldModelClass.getMethod("getStatusByUserName");

				String value6 = (String)method6.invoke(oldModel, (Object[])null);

				newModel.setStatusByUserName(value6);

				Method method7 = oldModelClass.getMethod("getStatusDate");

				Date value7 = (Date)method7.invoke(oldModel, (Object[])null);

				newModel.setStatusDate(value7);

				Method method8 = oldModelClass.getMethod("getCompanyId");

				Long value8 = (Long)method8.invoke(oldModel, (Object[])null);

				newModel.setCompanyId(value8);

				Method method9 = oldModelClass.getMethod("getGroupId");

				Long value9 = (Long)method9.invoke(oldModel, (Object[])null);

				newModel.setGroupId(value9);

				Method method10 = oldModelClass.getMethod("getUserId");

				Long value10 = (Long)method10.invoke(oldModel, (Object[])null);

				newModel.setUserId(value10);

				Method method11 = oldModelClass.getMethod(
						"getApplicationReason");

				String value11 = (String)method11.invoke(oldModel,
						(Object[])null);

				newModel.setApplicationReason(value11);

				Method method12 = oldModelClass.getMethod(
						"getApplicationAdditional");

				String value12 = (String)method12.invoke(oldModel,
						(Object[])null);

				newModel.setApplicationAdditional(value12);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static ClassLoader _classLoader;
	private static String _servletContextName;
}