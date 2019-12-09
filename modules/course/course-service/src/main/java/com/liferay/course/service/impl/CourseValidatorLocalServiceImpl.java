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

import com.liferay.course.exception.CourseValidationException;
import com.liferay.course.service.base.CourseValidatorLocalServiceBaseImpl;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.MapUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * The implementation of the course validator local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.course.service.CourseValidatorLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CourseValidatorLocalServiceBaseImpl
 * @see com.liferay.course.service.CourseValidatorLocalServiceUtil
 */
public class CourseValidatorLocalServiceImpl
	extends CourseValidatorLocalServiceBaseImpl {

	public void validate(
			Map<Locale, String> nameMap, String description,
			Map<Locale, String> lecturerMap, int duration, int status)
		throws CourseValidationException {

		List<String> errors = new ArrayList<>();

		if (!isCourseValid(
			nameMap, description, lecturerMap, duration, status, errors)) {

			throw new CourseValidationException(errors);
		}
	}

	private boolean isCourseValid(
		Map<Locale, String> nameMap, String description,
		Map<Locale, String> lecturerMap, int duration, int status,
		List<String> errors) {

		isNameValid(nameMap, errors);
		isDescriptionValid(description, errors);
		isLecturerValid(lecturerMap, errors);
		isDurationValid(duration, errors);

		if (errors.size() > 0) {
			return false;
		}

		return true;
	}

	private void isDurationValid(int duration, List<String> errors) {

		if (duration < MIN_VALUE_DURATION || duration > MAX_VALUE_DURATION) {
			errors.add(
				StringUtil.merge(
					new String[] {
						"duration",
						"-value-must-be-between-",
						String.valueOf(MIN_VALUE_DURATION),
						"-and-",
						String.valueOf(MAX_VALUE_DURATION)
					}, ""));
		}
	}

	private void isLecturerValid(
		Map<Locale, String> lecturerMap, List<String> errors) {

		checkEmptyMap(lecturerMap, errors, "courseLecturerEmpty");

		checkMaxLength(lecturerMap, errors, MAX_LENGTH_LECTURER, "lecturer");
	}

	private void isDescriptionValid(String description, List<String> errors) {

		String fieldName = "description";

		Locale defaultLocale = LocaleUtil.getSiteDefault();

		Map<Locale, String> mapValue = new HashMap<>();

		mapValue.put(defaultLocale, description);

		checkMaxLength(mapValue, errors, MAX_LENGTH_DESCRIPTION, fieldName);
	}

	private void isNameValid(Map<Locale, String> nameMap, List<String> errors) {

		checkEmptyMap(nameMap, errors, "courseNameEmpty");

		checkMaxLength(nameMap, errors, MAX_LENGTH_NAME, "name");
	}

	private void checkEmptyMap(
		Map<Locale, String> mapValue, List<String> errors, String errorEmpty) {

		if (MapUtil.isEmpty(mapValue)) {
			errors.add(errorEmpty);
		}
	}

	private void checkMaxLength(
		Map<Locale, String> mapValue, List<String> errors, int maxLength,
		String fieldName) {

		if (MapUtil.isNotEmpty(mapValue)) {

			Locale defaultLocale = LocaleUtil.getSiteDefault();

			String value = mapValue.get(defaultLocale);

			if (!Validator.isBlank(value) && value.length() > maxLength) {

				errors.add(
					StringUtil.replace(
						MESSAGE_ERROR_MAX_LENGTH, "{x}",
						String.valueOf(maxLength)).replace(
							"{field}", "fieldName"));
			}
		}
	}

	private static final int MAX_LENGTH_DESCRIPTION = 2000;

	private static final int MAX_LENGTH_LECTURER = 75;

	private static final int MAX_LENGTH_NAME = 20;

	private static final int MAX_VALUE_DURATION = 40;

	private static final int MIN_VALUE_DURATION = 1;

	private static final String MESSAGE_ERROR_MAX_LENGTH =
		"please-enter-no-more-than-{x}-characters-in-{field}-field";

}