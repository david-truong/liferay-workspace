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

package com.liferay.custom.data.model.impl;

import com.liferay.custom.data.model.CustomData;
import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CustomData in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class CustomDataCacheModel
	implements CacheModel<CustomData>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CustomDataCacheModel)) {
			return false;
		}

		CustomDataCacheModel customDataCacheModel = (CustomDataCacheModel)obj;

		if (customDataId == customDataCacheModel.customDataId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, customDataId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", customDataId=");
		sb.append(customDataId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", customBoolean=");
		sb.append(customBoolean);
		sb.append(", customData=");
		sb.append(customData);
		sb.append(", customInt=");
		sb.append(customInt);
		sb.append(", customLong=");
		sb.append(customLong);
		sb.append(", customString=");
		sb.append(customString);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CustomData toEntityModel() {
		CustomDataImpl customDataImpl = new CustomDataImpl();

		if (uuid == null) {
			customDataImpl.setUuid("");
		}
		else {
			customDataImpl.setUuid(uuid);
		}

		customDataImpl.setCustomDataId(customDataId);
		customDataImpl.setGroupId(groupId);
		customDataImpl.setCompanyId(companyId);
		customDataImpl.setUserId(userId);

		if (userName == null) {
			customDataImpl.setUserName("");
		}
		else {
			customDataImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			customDataImpl.setCreateDate(null);
		}
		else {
			customDataImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			customDataImpl.setModifiedDate(null);
		}
		else {
			customDataImpl.setModifiedDate(new Date(modifiedDate));
		}

		customDataImpl.setCustomBoolean(customBoolean);

		if (customData == Long.MIN_VALUE) {
			customDataImpl.setCustomData(null);
		}
		else {
			customDataImpl.setCustomData(new Date(customData));
		}

		customDataImpl.setCustomInt(customInt);
		customDataImpl.setCustomLong(customLong);

		if (customString == null) {
			customDataImpl.setCustomString("");
		}
		else {
			customDataImpl.setCustomString(customString);
		}

		customDataImpl.resetOriginalValues();

		return customDataImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		customDataId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		customBoolean = objectInput.readBoolean();
		customData = objectInput.readLong();

		customInt = objectInput.readInt();

		customLong = objectInput.readLong();
		customString = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(customDataId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeBoolean(customBoolean);
		objectOutput.writeLong(customData);

		objectOutput.writeInt(customInt);

		objectOutput.writeLong(customLong);

		if (customString == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(customString);
		}
	}

	public String uuid;
	public long customDataId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public boolean customBoolean;
	public long customData;
	public int customInt;
	public long customLong;
	public String customString;

}