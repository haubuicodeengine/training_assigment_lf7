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
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * Provides the HTTP utility for the
 * {@link CourseServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * {@link HttpPrincipal} parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CourseServiceSoap
 * @see HttpPrincipal
 * @see CourseServiceUtil
 * @generated
 */
@ProviderType
public class CourseServiceHttp {
	public static com.liferay.course.model.Course addCourse(
		HttpPrincipal httpPrincipal, long groupId,
		java.util.Map<java.util.Locale, String> nameMap, String description,
		java.util.Map<java.util.Locale, String> lecturerMap, int duration,
		int status,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(CourseServiceUtil.class,
					"addCourse", _addCourseParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(methodKey, groupId,
					nameMap, description, lecturerMap, duration, status,
					serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (com.liferay.course.model.Course)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static void deleteCourse(HttpPrincipal httpPrincipal, long courseId)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(CourseServiceUtil.class,
					"deleteCourse", _deleteCourseParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(methodKey, courseId);

			try {
				TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.liferay.course.model.Course getCourse(
		HttpPrincipal httpPrincipal, long courseId)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(CourseServiceUtil.class,
					"getCourse", _getCourseParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(methodKey, courseId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (com.liferay.course.model.Course)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<com.liferay.course.model.Course> getCoursesByKeywords(
		HttpPrincipal httpPrincipal, long groupId, String keywords, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.course.model.Course> orderByComparator) {
		try {
			MethodKey methodKey = new MethodKey(CourseServiceUtil.class,
					"getCoursesByKeywords", _getCoursesByKeywordsParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(methodKey, groupId,
					keywords, start, end, orderByComparator);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<com.liferay.course.model.Course>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static long getCoursesCountByKeywords(HttpPrincipal httpPrincipal,
		long groupId, String keywords) {
		try {
			MethodKey methodKey = new MethodKey(CourseServiceUtil.class,
					"getCoursesCountByKeywords",
					_getCoursesCountByKeywordsParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(methodKey, groupId,
					keywords);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return ((Long)returnObj).longValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.liferay.course.model.Course updateCourse(
		HttpPrincipal httpPrincipal, long courseId,
		java.util.Map<java.util.Locale, String> nameMap, String description,
		java.util.Map<java.util.Locale, String> lecturerMap, int duration,
		int status,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(CourseServiceUtil.class,
					"updateCourse", _updateCourseParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					courseId, nameMap, description, lecturerMap, duration,
					status, serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (com.liferay.course.model.Course)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(CourseServiceHttp.class);
	private static final Class<?>[] _addCourseParameterTypes0 = new Class[] {
			long.class, java.util.Map.class, String.class, java.util.Map.class,
			int.class, int.class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _deleteCourseParameterTypes1 = new Class[] {
			long.class
		};
	private static final Class<?>[] _getCourseParameterTypes2 = new Class[] {
			long.class
		};
	private static final Class<?>[] _getCoursesByKeywordsParameterTypes3 = new Class[] {
			long.class, String.class, int.class, int.class,
			com.liferay.portal.kernel.util.OrderByComparator.class
		};
	private static final Class<?>[] _getCoursesCountByKeywordsParameterTypes4 = new Class[] {
			long.class, String.class
		};
	private static final Class<?>[] _updateCourseParameterTypes5 = new Class[] {
			long.class, java.util.Map.class, String.class, java.util.Map.class,
			int.class, int.class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};
}