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

package com.liferay.course.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Course}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Course
 * @generated
 */
@ProviderType
public class CourseWrapper implements Course, ModelWrapper<Course> {
	public CourseWrapper(Course course) {
		_course = course;
	}

	@Override
	public Class<?> getModelClass() {
		return Course.class;
	}

	@Override
	public String getModelClassName() {
		return Course.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("courseId", getCourseId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("description", getDescription());
		attributes.put("lecturer", getLecturer());
		attributes.put("duration", getDuration());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long courseId = (Long)attributes.get("courseId");

		if (courseId != null) {
			setCourseId(courseId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String lecturer = (String)attributes.get("lecturer");

		if (lecturer != null) {
			setLecturer(lecturer);
		}

		Integer duration = (Integer)attributes.get("duration");

		if (duration != null) {
			setDuration(duration);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	@Override
	public Object clone() {
		return new CourseWrapper((Course)_course.clone());
	}

	@Override
	public int compareTo(Course course) {
		return _course.compareTo(course);
	}

	@Override
	public String[] getAvailableLanguageIds() {
		return _course.getAvailableLanguageIds();
	}

	/**
	* Returns the company ID of this course.
	*
	* @return the company ID of this course
	*/
	@Override
	public long getCompanyId() {
		return _course.getCompanyId();
	}

	/**
	* Returns the course ID of this course.
	*
	* @return the course ID of this course
	*/
	@Override
	public long getCourseId() {
		return _course.getCourseId();
	}

	/**
	* Returns the create date of this course.
	*
	* @return the create date of this course
	*/
	@Override
	public Date getCreateDate() {
		return _course.getCreateDate();
	}

	@Override
	public String getDefaultLanguageId() {
		return _course.getDefaultLanguageId();
	}

	/**
	* Returns the description of this course.
	*
	* @return the description of this course
	*/
	@Override
	public String getDescription() {
		return _course.getDescription();
	}

	/**
	* Returns the duration of this course.
	*
	* @return the duration of this course
	*/
	@Override
	public int getDuration() {
		return _course.getDuration();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _course.getExpandoBridge();
	}

	/**
	* Returns the group ID of this course.
	*
	* @return the group ID of this course
	*/
	@Override
	public long getGroupId() {
		return _course.getGroupId();
	}

	/**
	* Returns the lecturer of this course.
	*
	* @return the lecturer of this course
	*/
	@Override
	public String getLecturer() {
		return _course.getLecturer();
	}

	/**
	* Returns the localized lecturer of this course in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized lecturer of this course
	*/
	@Override
	public String getLecturer(java.util.Locale locale) {
		return _course.getLecturer(locale);
	}

	/**
	* Returns the localized lecturer of this course in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized lecturer of this course. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public String getLecturer(java.util.Locale locale, boolean useDefault) {
		return _course.getLecturer(locale, useDefault);
	}

	/**
	* Returns the localized lecturer of this course in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized lecturer of this course
	*/
	@Override
	public String getLecturer(String languageId) {
		return _course.getLecturer(languageId);
	}

	/**
	* Returns the localized lecturer of this course in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized lecturer of this course
	*/
	@Override
	public String getLecturer(String languageId, boolean useDefault) {
		return _course.getLecturer(languageId, useDefault);
	}

	@Override
	public String getLecturerCurrentLanguageId() {
		return _course.getLecturerCurrentLanguageId();
	}

	@Override
	public String getLecturerCurrentValue() {
		return _course.getLecturerCurrentValue();
	}

	/**
	* Returns a map of the locales and localized lecturers of this course.
	*
	* @return the locales and localized lecturers of this course
	*/
	@Override
	public Map<java.util.Locale, String> getLecturerMap() {
		return _course.getLecturerMap();
	}

	/**
	* Returns the modified date of this course.
	*
	* @return the modified date of this course
	*/
	@Override
	public Date getModifiedDate() {
		return _course.getModifiedDate();
	}

	/**
	* Returns the name of this course.
	*
	* @return the name of this course
	*/
	@Override
	public String getName() {
		return _course.getName();
	}

	/**
	* Returns the localized name of this course in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized name of this course
	*/
	@Override
	public String getName(java.util.Locale locale) {
		return _course.getName(locale);
	}

	/**
	* Returns the localized name of this course in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized name of this course. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public String getName(java.util.Locale locale, boolean useDefault) {
		return _course.getName(locale, useDefault);
	}

	/**
	* Returns the localized name of this course in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized name of this course
	*/
	@Override
	public String getName(String languageId) {
		return _course.getName(languageId);
	}

	/**
	* Returns the localized name of this course in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized name of this course
	*/
	@Override
	public String getName(String languageId, boolean useDefault) {
		return _course.getName(languageId, useDefault);
	}

	@Override
	public String getNameCurrentLanguageId() {
		return _course.getNameCurrentLanguageId();
	}

	@Override
	public String getNameCurrentValue() {
		return _course.getNameCurrentValue();
	}

	/**
	* Returns a map of the locales and localized names of this course.
	*
	* @return the locales and localized names of this course
	*/
	@Override
	public Map<java.util.Locale, String> getNameMap() {
		return _course.getNameMap();
	}

	/**
	* Returns the primary key of this course.
	*
	* @return the primary key of this course
	*/
	@Override
	public long getPrimaryKey() {
		return _course.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _course.getPrimaryKeyObj();
	}

	/**
	* Returns the status of this course.
	*
	* @return the status of this course
	*/
	@Override
	public int getStatus() {
		return _course.getStatus();
	}

	/**
	* Returns the user ID of this course.
	*
	* @return the user ID of this course
	*/
	@Override
	public long getUserId() {
		return _course.getUserId();
	}

	/**
	* Returns the user name of this course.
	*
	* @return the user name of this course
	*/
	@Override
	public String getUserName() {
		return _course.getUserName();
	}

	/**
	* Returns the user uuid of this course.
	*
	* @return the user uuid of this course
	*/
	@Override
	public String getUserUuid() {
		return _course.getUserUuid();
	}

	/**
	* Returns the uuid of this course.
	*
	* @return the uuid of this course
	*/
	@Override
	public String getUuid() {
		return _course.getUuid();
	}

	@Override
	public int hashCode() {
		return _course.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _course.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _course.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _course.isNew();
	}

	@Override
	public void persist() {
		_course.persist();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.kernel.exception.LocaleException {
		_course.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
		java.util.Locale defaultImportLocale)
		throws com.liferay.portal.kernel.exception.LocaleException {
		_course.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_course.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this course.
	*
	* @param companyId the company ID of this course
	*/
	@Override
	public void setCompanyId(long companyId) {
		_course.setCompanyId(companyId);
	}

	/**
	* Sets the course ID of this course.
	*
	* @param courseId the course ID of this course
	*/
	@Override
	public void setCourseId(long courseId) {
		_course.setCourseId(courseId);
	}

	/**
	* Sets the create date of this course.
	*
	* @param createDate the create date of this course
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_course.setCreateDate(createDate);
	}

	/**
	* Sets the description of this course.
	*
	* @param description the description of this course
	*/
	@Override
	public void setDescription(String description) {
		_course.setDescription(description);
	}

	/**
	* Sets the duration of this course.
	*
	* @param duration the duration of this course
	*/
	@Override
	public void setDuration(int duration) {
		_course.setDuration(duration);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_course.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_course.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_course.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this course.
	*
	* @param groupId the group ID of this course
	*/
	@Override
	public void setGroupId(long groupId) {
		_course.setGroupId(groupId);
	}

	/**
	* Sets the lecturer of this course.
	*
	* @param lecturer the lecturer of this course
	*/
	@Override
	public void setLecturer(String lecturer) {
		_course.setLecturer(lecturer);
	}

	/**
	* Sets the localized lecturer of this course in the language.
	*
	* @param lecturer the localized lecturer of this course
	* @param locale the locale of the language
	*/
	@Override
	public void setLecturer(String lecturer, java.util.Locale locale) {
		_course.setLecturer(lecturer, locale);
	}

	/**
	* Sets the localized lecturer of this course in the language, and sets the default locale.
	*
	* @param lecturer the localized lecturer of this course
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setLecturer(String lecturer, java.util.Locale locale,
		java.util.Locale defaultLocale) {
		_course.setLecturer(lecturer, locale, defaultLocale);
	}

	@Override
	public void setLecturerCurrentLanguageId(String languageId) {
		_course.setLecturerCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized lecturers of this course from the map of locales and localized lecturers.
	*
	* @param lecturerMap the locales and localized lecturers of this course
	*/
	@Override
	public void setLecturerMap(Map<java.util.Locale, String> lecturerMap) {
		_course.setLecturerMap(lecturerMap);
	}

	/**
	* Sets the localized lecturers of this course from the map of locales and localized lecturers, and sets the default locale.
	*
	* @param lecturerMap the locales and localized lecturers of this course
	* @param defaultLocale the default locale
	*/
	@Override
	public void setLecturerMap(Map<java.util.Locale, String> lecturerMap,
		java.util.Locale defaultLocale) {
		_course.setLecturerMap(lecturerMap, defaultLocale);
	}

	/**
	* Sets the modified date of this course.
	*
	* @param modifiedDate the modified date of this course
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_course.setModifiedDate(modifiedDate);
	}

	/**
	* Sets the name of this course.
	*
	* @param name the name of this course
	*/
	@Override
	public void setName(String name) {
		_course.setName(name);
	}

	/**
	* Sets the localized name of this course in the language.
	*
	* @param name the localized name of this course
	* @param locale the locale of the language
	*/
	@Override
	public void setName(String name, java.util.Locale locale) {
		_course.setName(name, locale);
	}

	/**
	* Sets the localized name of this course in the language, and sets the default locale.
	*
	* @param name the localized name of this course
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setName(String name, java.util.Locale locale,
		java.util.Locale defaultLocale) {
		_course.setName(name, locale, defaultLocale);
	}

	@Override
	public void setNameCurrentLanguageId(String languageId) {
		_course.setNameCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized names of this course from the map of locales and localized names.
	*
	* @param nameMap the locales and localized names of this course
	*/
	@Override
	public void setNameMap(Map<java.util.Locale, String> nameMap) {
		_course.setNameMap(nameMap);
	}

	/**
	* Sets the localized names of this course from the map of locales and localized names, and sets the default locale.
	*
	* @param nameMap the locales and localized names of this course
	* @param defaultLocale the default locale
	*/
	@Override
	public void setNameMap(Map<java.util.Locale, String> nameMap,
		java.util.Locale defaultLocale) {
		_course.setNameMap(nameMap, defaultLocale);
	}

	@Override
	public void setNew(boolean n) {
		_course.setNew(n);
	}

	/**
	* Sets the primary key of this course.
	*
	* @param primaryKey the primary key of this course
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_course.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_course.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the status of this course.
	*
	* @param status the status of this course
	*/
	@Override
	public void setStatus(int status) {
		_course.setStatus(status);
	}

	/**
	* Sets the user ID of this course.
	*
	* @param userId the user ID of this course
	*/
	@Override
	public void setUserId(long userId) {
		_course.setUserId(userId);
	}

	/**
	* Sets the user name of this course.
	*
	* @param userName the user name of this course
	*/
	@Override
	public void setUserName(String userName) {
		_course.setUserName(userName);
	}

	/**
	* Sets the user uuid of this course.
	*
	* @param userUuid the user uuid of this course
	*/
	@Override
	public void setUserUuid(String userUuid) {
		_course.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this course.
	*
	* @param uuid the uuid of this course
	*/
	@Override
	public void setUuid(String uuid) {
		_course.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Course> toCacheModel() {
		return _course.toCacheModel();
	}

	@Override
	public Course toEscapedModel() {
		return new CourseWrapper(_course.toEscapedModel());
	}

	@Override
	public String toString() {
		return _course.toString();
	}

	@Override
	public Course toUnescapedModel() {
		return new CourseWrapper(_course.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _course.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CourseWrapper)) {
			return false;
		}

		CourseWrapper courseWrapper = (CourseWrapper)obj;

		if (Objects.equals(_course, courseWrapper._course)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _course.getStagedModelType();
	}

	@Override
	public Course getWrappedModel() {
		return _course;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _course.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _course.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_course.resetOriginalValues();
	}

	private final Course _course;
}