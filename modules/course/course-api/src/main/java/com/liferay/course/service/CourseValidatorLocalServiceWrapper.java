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
 * Provides a wrapper for {@link CourseValidatorLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CourseValidatorLocalService
 * @generated
 */
@ProviderType
public class CourseValidatorLocalServiceWrapper
	implements CourseValidatorLocalService,
		ServiceWrapper<CourseValidatorLocalService> {
	public CourseValidatorLocalServiceWrapper(
		CourseValidatorLocalService courseValidatorLocalService) {
		_courseValidatorLocalService = courseValidatorLocalService;
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _courseValidatorLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public void validate(java.util.Map<java.util.Locale, String> nameMap,
		String description,
		java.util.Map<java.util.Locale, String> lecturerMap, int duration,
		int status)
		throws com.liferay.course.exception.CourseValidationException {
		_courseValidatorLocalService.validate(nameMap, description,
			lecturerMap, duration, status);
	}

	@Override
	public CourseValidatorLocalService getWrappedService() {
		return _courseValidatorLocalService;
	}

	@Override
	public void setWrappedService(
		CourseValidatorLocalService courseValidatorLocalService) {
		_courseValidatorLocalService = courseValidatorLocalService;
	}

	private CourseValidatorLocalService _courseValidatorLocalService;
}