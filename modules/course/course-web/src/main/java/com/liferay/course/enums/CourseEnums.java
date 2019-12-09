package com.liferay.course.enums;

import com.liferay.portal.kernel.exception.PortalException;

public enum CourseEnums {
	Available("available", 1),
	Unavailable("unavailable", 0);

	CourseEnums(String key, int value) {

		this.key = key;
		this.value = value;
	}

	public String getKey() {

		return key;
	}

	public int getValue() {

		return value;
	}

	public static CourseEnums getCourseEnumFromValue(int value)
		throws PortalException {

		for (CourseEnums courseEnum : CourseEnums.values()) {
			if (courseEnum.getValue() == value) {
				return courseEnum;
			}
		}
		throw new PortalException(
			"Can not find CourseEnum with value " + value);
	}

	private String key;
	private int value;
}
