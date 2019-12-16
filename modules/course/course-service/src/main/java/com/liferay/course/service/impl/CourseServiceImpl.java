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

package com.liferay.course.service.impl;

import com.liferay.course.model.Course;
import com.liferay.course.service.base.CourseServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * The implementation of the course remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.course.service.CourseService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CourseServiceBaseImpl
 * @see com.liferay.course.service.CourseServiceUtil
 */
public class CourseServiceImpl extends CourseServiceBaseImpl {

	public Course addCourse(
			long groupId, Map<Locale, String> nameMap,
			String description, Map<Locale, String> lecturerMap,
			int duration, int status, ServiceContext serviceContext)
		throws PortalException {

		return courseLocalService.addCourse(
			groupId, nameMap, description, lecturerMap, duration, status,
			serviceContext);
	}

	@Indexable(type = IndexableType.DELETE)
	public void deleteCourse(long courseId)
		throws PortalException {

		courseLocalService.deleteCourse(courseId);
	}

	public Course getCourse(long courseId)
		throws PortalException {

		return courseLocalService.getCourse(courseId);
	}

	public List<Course> getCoursesByKeywords(
		long groupId, String keywords, int start, int end,
		OrderByComparator<Course> orderByComparator) {

		return courseLocalService.getCoursesByKeywords(
			groupId, keywords, start, end, orderByComparator);
	}

	public long getCoursesCount() {

		return Long.valueOf(
			String.valueOf(courseLocalService.getCoursesCount()));
	}

	public long getCoursesCountByGroupIdAndUserId(long groupId, long userId) {

		return courseLocalService.getCoursesCountByGroupIdAndUserId(
			groupId, userId);
	}

	public long getCoursesCountByKeywords(long groupId, String keywords) {

		return courseLocalService.getCoursesCountByKeywords(groupId, keywords);
	}

	public Course updateCourse(
			long courseId, Map<Locale, String> nameMap,
			String description, Map<Locale, String> lecturerMap,
			int duration, int status, ServiceContext serviceContext)
		throws PortalException {

		return courseLocalService.updateCourse(
			courseId, nameMap, description, lecturerMap, duration, status,
			serviceContext);
	}
}