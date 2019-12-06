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

package com.liferay.course.service;

import aQute.bnd.annotation.ProviderType;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for Course. This utility wraps
 * {@link com.liferay.course.service.impl.CourseServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see CourseService
 * @see com.liferay.course.service.base.CourseServiceBaseImpl
 * @see com.liferay.course.service.impl.CourseServiceImpl
 * @generated
 */
@ProviderType
public class CourseServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.course.service.impl.CourseServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.course.model.Course addCourse(long groupId,
		java.util.Map<java.util.Locale, String> nameMap, String description,
		java.util.Map<java.util.Locale, String> lecturerMap, int duration,
		int status,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .addCourse(groupId, nameMap, description, lecturerMap,
			duration, status, serviceContext);
	}

	public static void deleteCourse(long courseId)
		throws com.liferay.portal.kernel.exception.PortalException {
		getService().deleteCourse(courseId);
	}

	public static com.liferay.course.model.Course getCourse(long courseId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getCourse(courseId);
	}

	public static java.util.List<com.liferay.course.model.Course> getCoursesByKeywords(
		long groupId, String keywords, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.course.model.Course> orderByComparator) {
		return getService()
				   .getCoursesByKeywords(groupId, keywords, start, end,
			orderByComparator);
	}

	public static long getCoursesCountByKeywords(long groupId, String keywords) {
		return getService().getCoursesCountByKeywords(groupId, keywords);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.course.model.Course updateCourse(long courseId,
		java.util.Map<java.util.Locale, String> nameMap, String description,
		java.util.Map<java.util.Locale, String> lecturerMap, int duration,
		int status,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .updateCourse(courseId, nameMap, description, lecturerMap,
			duration, status, serviceContext);
	}

	public static CourseService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CourseService, CourseService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(CourseService.class);

		ServiceTracker<CourseService, CourseService> serviceTracker = new ServiceTracker<CourseService, CourseService>(bundle.getBundleContext(),
				CourseService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}