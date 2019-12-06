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
 * Provides a wrapper for {@link CourseValidatorService}.
 *
 * @author Brian Wing Shun Chan
 * @see CourseValidatorService
 * @generated
 */
@ProviderType
public class CourseValidatorServiceWrapper implements CourseValidatorService,
	ServiceWrapper<CourseValidatorService> {
	public CourseValidatorServiceWrapper(
		CourseValidatorService courseValidatorService) {
		_courseValidatorService = courseValidatorService;
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _courseValidatorService.getOSGiServiceIdentifier();
	}

	@Override
	public CourseValidatorService getWrappedService() {
		return _courseValidatorService;
	}

	@Override
	public void setWrappedService(CourseValidatorService courseValidatorService) {
		_courseValidatorService = courseValidatorService;
	}

	private CourseValidatorService _courseValidatorService;
}