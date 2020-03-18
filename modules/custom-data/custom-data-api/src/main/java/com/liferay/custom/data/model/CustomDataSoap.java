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

package com.liferay.custom.data.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.custom.data.service.http.CustomDataServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class CustomDataSoap implements Serializable {

	public static CustomDataSoap toSoapModel(CustomData model) {
		CustomDataSoap soapModel = new CustomDataSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setCustomDataId(model.getCustomDataId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCustomBoolean(model.isCustomBoolean());
		soapModel.setCustomData(model.getCustomData());
		soapModel.setCustomInt(model.getCustomInt());
		soapModel.setCustomLong(model.getCustomLong());
		soapModel.setCustomString(model.getCustomString());

		return soapModel;
	}

	public static CustomDataSoap[] toSoapModels(CustomData[] models) {
		CustomDataSoap[] soapModels = new CustomDataSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CustomDataSoap[][] toSoapModels(CustomData[][] models) {
		CustomDataSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CustomDataSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CustomDataSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CustomDataSoap[] toSoapModels(List<CustomData> models) {
		List<CustomDataSoap> soapModels = new ArrayList<CustomDataSoap>(
			models.size());

		for (CustomData model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CustomDataSoap[soapModels.size()]);
	}

	public CustomDataSoap() {
	}

	public long getPrimaryKey() {
		return _customDataId;
	}

	public void setPrimaryKey(long pk) {
		setCustomDataId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getCustomDataId() {
		return _customDataId;
	}

	public void setCustomDataId(long customDataId) {
		_customDataId = customDataId;
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

	public boolean getCustomBoolean() {
		return _customBoolean;
	}

	public boolean isCustomBoolean() {
		return _customBoolean;
	}

	public void setCustomBoolean(boolean customBoolean) {
		_customBoolean = customBoolean;
	}

	public Date getCustomData() {
		return _customData;
	}

	public void setCustomData(Date customData) {
		_customData = customData;
	}

	public int getCustomInt() {
		return _customInt;
	}

	public void setCustomInt(int customInt) {
		_customInt = customInt;
	}

	public long getCustomLong() {
		return _customLong;
	}

	public void setCustomLong(long customLong) {
		_customLong = customLong;
	}

	public String getCustomString() {
		return _customString;
	}

	public void setCustomString(String customString) {
		_customString = customString;
	}

	private String _uuid;
	private long _customDataId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _customBoolean;
	private Date _customData;
	private int _customInt;
	private long _customLong;
	private String _customString;

}