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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.course.service.http.CourseServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.course.service.http.CourseServiceSoap
 * @generated
 */
@ProviderType
public class CourseSoap implements Serializable {
	public static CourseSoap toSoapModel(Course model) {
		CourseSoap soapModel = new CourseSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setCourseId(model.getCourseId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setName(model.getName());
		soapModel.setDescription(model.getDescription());
		soapModel.setLecturer(model.getLecturer());
		soapModel.setDuration(model.getDuration());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static CourseSoap[] toSoapModels(Course[] models) {
		CourseSoap[] soapModels = new CourseSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CourseSoap[][] toSoapModels(Course[][] models) {
		CourseSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CourseSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CourseSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CourseSoap[] toSoapModels(List<Course> models) {
		List<CourseSoap> soapModels = new ArrayList<CourseSoap>(models.size());

		for (Course model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CourseSoap[soapModels.size()]);
	}

	public CourseSoap() {
	}

	public long getPrimaryKey() {
		return _courseId;
	}

	public void setPrimaryKey(long pk) {
		setCourseId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getCourseId() {
		return _courseId;
	}

	public void setCourseId(long courseId) {
		_courseId = courseId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getLecturer() {
		return _lecturer;
	}

	public void setLecturer(String lecturer) {
		_lecturer = lecturer;
	}

	public int getDuration() {
		return _duration;
	}

	public void setDuration(int duration) {
		_duration = duration;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	private String _uuid;
	private long _courseId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private String _description;
	private String _lecturer;
	private int _duration;
	private int _status;
}