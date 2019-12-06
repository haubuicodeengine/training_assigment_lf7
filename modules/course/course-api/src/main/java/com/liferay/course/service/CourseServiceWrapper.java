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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CourseService}.
 *
 * @author Brian Wing Shun Chan
 * @see CourseService
 * @generated
 */
@ProviderType
public class CourseServiceWrapper implements CourseService,
	ServiceWrapper<CourseService> {
	public CourseServiceWrapper(CourseService courseService) {
		_courseService = courseService;
	}

	@Override
	public com.liferay.course.model.Course addCourse(long groupId,
		java.util.Map<java.util.Locale, String> nameMap, String description,
		java.util.Map<java.util.Locale, String> lecturerMap, int duration,
		int status,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _courseService.addCourse(groupId, nameMap, description,
			lecturerMap, duration, status, serviceContext);
	}

	@Override
	public void deleteCourse(long courseId)
		throws com.liferay.portal.kernel.exception.PortalException {
		_courseService.deleteCourse(courseId);
	}

	@Override
	public com.liferay.course.model.Course getCourse(long courseId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _courseService.getCourse(courseId);
	}

	@Override
	public java.util.List<com.liferay.course.model.Course> getCoursesByKeywords(
		long groupId, String keywords, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.course.model.Course> orderByComparator) {
		return _courseService.getCoursesByKeywords(groupId, keywords, start,
			end, orderByComparator);
	}

	@Override
	public long getCoursesCountByKeywords(long groupId, String keywords) {
		return _courseService.getCoursesCountByKeywords(groupId, keywords);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _courseService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.course.model.Course updateCourse(long courseId,
		java.util.Map<java.util.Locale, String> nameMap, String description,
		java.util.Map<java.util.Locale, String> lecturerMap, int duration,
		int status,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _courseService.updateCourse(courseId, nameMap, description,
			lecturerMap, duration, status, serviceContext);
	}

	@Override
	public CourseService getWrappedService() {
		return _courseService;
	}

	@Override
	public void setWrappedService(CourseService courseService) {
		_courseService = courseService;
	}

	private CourseService _courseService;
}