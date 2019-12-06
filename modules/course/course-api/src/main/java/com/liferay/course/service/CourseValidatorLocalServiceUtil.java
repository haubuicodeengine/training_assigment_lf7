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
 * Provides the local service utility for CourseValidator. This utility wraps
 * {@link com.liferay.course.service.impl.CourseValidatorLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see CourseValidatorLocalService
 * @see com.liferay.course.service.base.CourseValidatorLocalServiceBaseImpl
 * @see com.liferay.course.service.impl.CourseValidatorLocalServiceImpl
 * @generated
 */
@ProviderType
public class CourseValidatorLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.course.service.impl.CourseValidatorLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static void validate(
		java.util.Map<java.util.Locale, String> nameMap, String description,
		java.util.Map<java.util.Locale, String> lecturerMap, int duration,
		int status)
		throws com.liferay.course.exception.CourseValidationException {
		getService()
			.validate(nameMap, description, lecturerMap, duration, status);
	}

	public static CourseValidatorLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CourseValidatorLocalService, CourseValidatorLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(CourseValidatorLocalService.class);

		ServiceTracker<CourseValidatorLocalService, CourseValidatorLocalService> serviceTracker =
			new ServiceTracker<CourseValidatorLocalService, CourseValidatorLocalService>(bundle.getBundleContext(),
				CourseValidatorLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}