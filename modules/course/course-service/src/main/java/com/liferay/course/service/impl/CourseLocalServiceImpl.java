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
import com.liferay.course.service.base.CourseLocalServiceBaseImpl;
import com.liferay.portal.kernel.dao.orm.Disjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * The implementation of the course local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.course.service.CourseLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CourseLocalServiceBaseImpl
 * @see com.liferay.course.service.CourseLocalServiceUtil
 */
public class CourseLocalServiceImpl extends CourseLocalServiceBaseImpl {

	@Indexable(type = IndexableType.REINDEX)
	public Course addCourse(
			long groupId, Map<Locale, String> nameMap,
			String description, Map<Locale, String> lecturerMap,
			int duration, int status, ServiceContext serviceContext)
		throws PortalException {

		courseValidatorLocalService.validate(
			nameMap, description, lecturerMap, duration, status);

		// Get group and user.

		Group group = groupLocalService.getGroup(groupId);

		long userId = serviceContext.getUserId();

		User user = userLocalService.getUser(userId);

		// Generate primary key for the assignment.

		long courseId = counterLocalService.increment(Course.class.getName());

		// Create course. This doesn't yet persist the entity.

		Course course = createCourse(courseId);

		// Populate fields.

		course.setCompanyId(group.getCompanyId());
		course.setCreateDate(serviceContext.getCreateDate(new Date()));
		course.setGroupId(groupId);
		course.setModifiedDate(serviceContext.getModifiedDate(new Date()));
		course.setUserId(userId);
		course.setUserName(user.getScreenName());

		course.setNameMap(nameMap);
		course.setDescription(description);
		course.setLecturerMap(lecturerMap);
		course.setDuration(duration);
		course.setStatus(status);

		return super.addCourse(course);
	}

	public List<Course> getCoursesByKeywords(
		long groupId, String keywords, int start, int end,
		OrderByComparator<Course> orderByComparator) {

		return courseLocalService.dynamicQuery(
			getKeywordSearchDynamicQuery(groupId, keywords), start, end,
			orderByComparator);
	}

	public long getCoursesCountByGroupIdAndUserId(long groupId, long userId) {

		return courseLocalService.dynamicQueryCount(
			getGroupUserSearchDynamicQuery(groupId, userId));
	}

	public long getCoursesCountByKeywords(long groupId, String keywords) {

		return courseLocalService.dynamicQueryCount(
			getKeywordSearchDynamicQuery(groupId, keywords));
	}

	@Indexable(type = IndexableType.REINDEX)
	public Course updateCourse(
			long courseId, Map<Locale, String> nameMap,
			String description, Map<Locale, String> lecturerMap,
			int duration, int status, ServiceContext serviceContext)
		throws PortalException {

		courseValidatorLocalService.validate(
			nameMap, description, lecturerMap, duration, status);

		Course course = getCourse(courseId);

		course.setNameMap(nameMap);
		course.setDescription(description);
		course.setLecturerMap(lecturerMap);
		course.setDuration(duration);
		course.setStatus(status);

		return super.updateCourse(course);
	}

	private DynamicQuery getGroupUserSearchDynamicQuery(
		long groupId, long userId) {

		DynamicQuery dynamicQuery = dynamicQuery();

		dynamicQuery.add(RestrictionsFactoryUtil.eq("groupId", groupId));

		dynamicQuery.add(RestrictionsFactoryUtil.eq("userId", userId));

		return dynamicQuery;
	}

	private DynamicQuery getKeywordSearchDynamicQuery(
		long groupId, String keywords) {

		DynamicQuery dynamicQuery =
			dynamicQuery().add(RestrictionsFactoryUtil.eq("groupId", groupId));

		if (Validator.isNotNull(keywords)) {
			Disjunction disjunctionQuery =
				RestrictionsFactoryUtil.disjunction();

			disjunctionQuery.add(
				RestrictionsFactoryUtil.like("name", "%" + keywords + "%"));
			disjunctionQuery.add(
				RestrictionsFactoryUtil.like(
					"description", "%" + keywords + "%"));
			dynamicQuery.add(disjunctionQuery);
		}

		return dynamicQuery;
	}

}