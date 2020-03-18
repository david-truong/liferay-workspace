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

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link CustomData}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CustomData
 * @generated
 */
public class CustomDataWrapper
	extends BaseModelWrapper<CustomData>
	implements CustomData, ModelWrapper<CustomData> {

	public CustomDataWrapper(CustomData customData) {
		super(customData);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("customDataId", getCustomDataId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("customBoolean", isCustomBoolean());
		attributes.put("customData", getCustomData());
		attributes.put("customInt", getCustomInt());
		attributes.put("customLong", getCustomLong());
		attributes.put("customString", getCustomString());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long customDataId = (Long)attributes.get("customDataId");

		if (customDataId != null) {
			setCustomDataId(customDataId);
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

		Boolean customBoolean = (Boolean)attributes.get("customBoolean");

		if (customBoolean != null) {
			setCustomBoolean(customBoolean);
		}

		Date customData = (Date)attributes.get("customData");

		if (customData != null) {
			setCustomData(customData);
		}

		Integer customInt = (Integer)attributes.get("customInt");

		if (customInt != null) {
			setCustomInt(customInt);
		}

		Long customLong = (Long)attributes.get("customLong");

		if (customLong != null) {
			setCustomLong(customLong);
		}

		String customString = (String)attributes.get("customString");

		if (customString != null) {
			setCustomString(customString);
		}
	}

	/**
	 * Returns the company ID of this custom data.
	 *
	 * @return the company ID of this custom data
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this custom data.
	 *
	 * @return the create date of this custom data
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the custom boolean of this custom data.
	 *
	 * @return the custom boolean of this custom data
	 */
	@Override
	public boolean getCustomBoolean() {
		return model.getCustomBoolean();
	}

	/**
	 * Returns the custom data of this custom data.
	 *
	 * @return the custom data of this custom data
	 */
	@Override
	public Date getCustomData() {
		return model.getCustomData();
	}

	/**
	 * Returns the custom data ID of this custom data.
	 *
	 * @return the custom data ID of this custom data
	 */
	@Override
	public long getCustomDataId() {
		return model.getCustomDataId();
	}

	/**
	 * Returns the custom int of this custom data.
	 *
	 * @return the custom int of this custom data
	 */
	@Override
	public int getCustomInt() {
		return model.getCustomInt();
	}

	/**
	 * Returns the custom long of this custom data.
	 *
	 * @return the custom long of this custom data
	 */
	@Override
	public long getCustomLong() {
		return model.getCustomLong();
	}

	/**
	 * Returns the custom string of this custom data.
	 *
	 * @return the custom string of this custom data
	 */
	@Override
	public String getCustomString() {
		return model.getCustomString();
	}

	/**
	 * Returns the group ID of this custom data.
	 *
	 * @return the group ID of this custom data
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this custom data.
	 *
	 * @return the modified date of this custom data
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this custom data.
	 *
	 * @return the primary key of this custom data
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this custom data.
	 *
	 * @return the user ID of this custom data
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this custom data.
	 *
	 * @return the user name of this custom data
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this custom data.
	 *
	 * @return the user uuid of this custom data
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this custom data.
	 *
	 * @return the uuid of this custom data
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this custom data is custom boolean.
	 *
	 * @return <code>true</code> if this custom data is custom boolean; <code>false</code> otherwise
	 */
	@Override
	public boolean isCustomBoolean() {
		return model.isCustomBoolean();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this custom data.
	 *
	 * @param companyId the company ID of this custom data
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this custom data.
	 *
	 * @param createDate the create date of this custom data
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets whether this custom data is custom boolean.
	 *
	 * @param customBoolean the custom boolean of this custom data
	 */
	@Override
	public void setCustomBoolean(boolean customBoolean) {
		model.setCustomBoolean(customBoolean);
	}

	/**
	 * Sets the custom data of this custom data.
	 *
	 * @param customData the custom data of this custom data
	 */
	@Override
	public void setCustomData(Date customData) {
		model.setCustomData(customData);
	}

	/**
	 * Sets the custom data ID of this custom data.
	 *
	 * @param customDataId the custom data ID of this custom data
	 */
	@Override
	public void setCustomDataId(long customDataId) {
		model.setCustomDataId(customDataId);
	}

	/**
	 * Sets the custom int of this custom data.
	 *
	 * @param customInt the custom int of this custom data
	 */
	@Override
	public void setCustomInt(int customInt) {
		model.setCustomInt(customInt);
	}

	/**
	 * Sets the custom long of this custom data.
	 *
	 * @param customLong the custom long of this custom data
	 */
	@Override
	public void setCustomLong(long customLong) {
		model.setCustomLong(customLong);
	}

	/**
	 * Sets the custom string of this custom data.
	 *
	 * @param customString the custom string of this custom data
	 */
	@Override
	public void setCustomString(String customString) {
		model.setCustomString(customString);
	}

	/**
	 * Sets the group ID of this custom data.
	 *
	 * @param groupId the group ID of this custom data
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this custom data.
	 *
	 * @param modifiedDate the modified date of this custom data
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this custom data.
	 *
	 * @param primaryKey the primary key of this custom data
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this custom data.
	 *
	 * @param userId the user ID of this custom data
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this custom data.
	 *
	 * @param userName the user name of this custom data
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this custom data.
	 *
	 * @param userUuid the user uuid of this custom data
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this custom data.
	 *
	 * @param uuid the uuid of this custom data
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected CustomDataWrapper wrap(CustomData customData) {
		return new CustomDataWrapper(customData);
	}

}