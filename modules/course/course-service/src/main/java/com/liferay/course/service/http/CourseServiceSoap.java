/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
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

package com.liferay.course.service.http;

import aQute.bnd.annotation.ProviderType;

import com.liferay.course.service.CourseServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;

import java.rmi.RemoteException;

import java.util.Locale;
import java.util.Map;

/**
 * Provides the SOAP utility for the
 * {@link CourseServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.liferay.course.model.CourseSoap}.
 * If the method in the service utility returns a
 * {@link com.liferay.course.model.Course}, that is translated to a
 * {@link com.liferay.course.model.CourseSoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CourseServiceHttp
 * @see com.liferay.course.model.CourseSoap
 * @see CourseServiceUtil
 * @generated
 */
@ProviderType
public class CourseServiceSoap {
	public static com.liferay.course.model.CourseSoap addCourse(long groupId,
		String[] nameMapLanguageIds, String[] nameMapValues,
		String description, String[] lecturerMapLanguageIds,
		String[] lecturerMapValues, int duration, int status,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			Map<Locale, String> nameMap = LocalizationUtil.getLocalizationMap(nameMapLanguageIds,
					nameMapValues);
			Map<Locale, String> lecturerMap = LocalizationUtil.getLocalizationMap(lecturerMapLanguageIds,
					lecturerMapValues);

			com.liferay.course.model.Course returnValue = CourseServiceUtil.addCourse(groupId,
					nameMap, description, lecturerMap, duration, status,
					serviceContext);

			return com.liferay.course.model.CourseSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void deleteCourse(long courseId) throws RemoteException {
		try {
			CourseServiceUtil.deleteCourse(courseId);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.course.model.CourseSoap getCourse(long courseId)
		throws RemoteException {
		try {
			com.liferay.course.model.Course returnValue = CourseServiceUtil.getCourse(courseId);

			return com.liferay.course.model.CourseSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.course.model.CourseSoap[] getCoursesByKeywords(
		long groupId, String keywords, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.course.model.Course> orderByComparator)
		throws RemoteException {
		try {
			java.util.List<com.liferay.course.model.Course> returnValue = CourseServiceUtil.getCoursesByKeywords(groupId,
					keywords, start, end, orderByComparator);

			return com.liferay.course.model.CourseSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static long getCoursesCountByKeywords(long groupId, String keywords)
		throws RemoteException {
		try {
			long returnValue = CourseServiceUtil.getCoursesCountByKeywords(groupId,
					keywords);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.course.model.CourseSoap updateCourse(
		long courseId, String[] nameMapLanguageIds, String[] nameMapValues,
		String description, String[] lecturerMapLanguageIds,
		String[] lecturerMapValues, int duration, int status,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			Map<Locale, String> nameMap = LocalizationUtil.getLocalizationMap(nameMapLanguageIds,
					nameMapValues);
			Map<Locale, String> lecturerMap = LocalizationUtil.getLocalizationMap(lecturerMapLanguageIds,
					lecturerMapValues);

			com.liferay.course.model.Course returnValue = CourseServiceUtil.updateCourse(courseId,
					nameMap, description, lecturerMap, duration, status,
					serviceContext);

			return com.liferay.course.model.CourseSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(CourseServiceSoap.class);
}