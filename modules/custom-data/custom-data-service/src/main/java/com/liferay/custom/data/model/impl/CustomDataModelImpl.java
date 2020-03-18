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
import com.liferay.custom.data.model.CustomDataModel;
import com.liferay.custom.data.model.CustomDataSoap;
import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the CustomData service. Represents a row in the &quot;CustomData_CustomData&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>CustomDataModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CustomDataImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CustomDataImpl
 * @generated
 */
@JSON(strict = true)
public class CustomDataModelImpl
	extends BaseModelImpl<CustomData> implements CustomDataModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a custom data model instance should use the <code>CustomData</code> interface instead.
	 */
	public static final String TABLE_NAME = "CustomData_CustomData";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"customDataId", Types.BIGINT},
		{"groupId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"customBoolean", Types.BOOLEAN}, {"customData", Types.TIMESTAMP},
		{"customInt", Types.INTEGER}, {"customLong", Types.BIGINT},
		{"customString", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("customDataId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("customBoolean", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("customData", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("customInt", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("customLong", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("customString", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table CustomData_CustomData (uuid_ VARCHAR(75) null,customDataId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,customBoolean BOOLEAN,customData DATE null,customInt INTEGER,customLong LONG,customString VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP =
		"drop table CustomData_CustomData";

	public static final String ORDER_BY_JPQL =
		" ORDER BY customData.customLong ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY CustomData_CustomData.customLong ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	public static final long CUSTOMSTRING_COLUMN_BITMASK = 2L;

	public static final long GROUPID_COLUMN_BITMASK = 4L;

	public static final long UUID_COLUMN_BITMASK = 8L;

	public static final long CUSTOMLONG_COLUMN_BITMASK = 16L;

	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
		_entityCacheEnabled = entityCacheEnabled;
	}

	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
		_finderCacheEnabled = finderCacheEnabled;
	}

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static CustomData toModel(CustomDataSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		CustomData model = new CustomDataImpl();

		model.setUuid(soapModel.getUuid());
		model.setCustomDataId(soapModel.getCustomDataId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setCustomBoolean(soapModel.isCustomBoolean());
		model.setCustomData(soapModel.getCustomData());
		model.setCustomInt(soapModel.getCustomInt());
		model.setCustomLong(soapModel.getCustomLong());
		model.setCustomString(soapModel.getCustomString());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<CustomData> toModels(CustomDataSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<CustomData> models = new ArrayList<CustomData>(soapModels.length);

		for (CustomDataSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public CustomDataModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _customDataId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCustomDataId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _customDataId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return CustomData.class;
	}

	@Override
	public String getModelClassName() {
		return CustomData.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<CustomData, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<CustomData, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CustomData, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((CustomData)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<CustomData, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<CustomData, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(CustomData)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<CustomData, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<CustomData, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, CustomData>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			CustomData.class.getClassLoader(), CustomData.class,
			ModelWrapper.class);

		try {
			Constructor<CustomData> constructor =
				(Constructor<CustomData>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException
							reflectiveOperationException) {

					throw new InternalError(reflectiveOperationException);
				}
			};
		}
		catch (NoSuchMethodException noSuchMethodException) {
			throw new InternalError(noSuchMethodException);
		}
	}

	private static final Map<String, Function<CustomData, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<CustomData, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<CustomData, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<CustomData, Object>>();
		Map<String, BiConsumer<CustomData, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<CustomData, ?>>();

		attributeGetterFunctions.put("uuid", CustomData::getUuid);
		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<CustomData, String>)CustomData::setUuid);
		attributeGetterFunctions.put(
			"customDataId", CustomData::getCustomDataId);
		attributeSetterBiConsumers.put(
			"customDataId",
			(BiConsumer<CustomData, Long>)CustomData::setCustomDataId);
		attributeGetterFunctions.put("groupId", CustomData::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId", (BiConsumer<CustomData, Long>)CustomData::setGroupId);
		attributeGetterFunctions.put("companyId", CustomData::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<CustomData, Long>)CustomData::setCompanyId);
		attributeGetterFunctions.put("userId", CustomData::getUserId);
		attributeSetterBiConsumers.put(
			"userId", (BiConsumer<CustomData, Long>)CustomData::setUserId);
		attributeGetterFunctions.put("userName", CustomData::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<CustomData, String>)CustomData::setUserName);
		attributeGetterFunctions.put("createDate", CustomData::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<CustomData, Date>)CustomData::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", CustomData::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<CustomData, Date>)CustomData::setModifiedDate);
		attributeGetterFunctions.put(
			"customBoolean", CustomData::getCustomBoolean);
		attributeSetterBiConsumers.put(
			"customBoolean",
			(BiConsumer<CustomData, Boolean>)CustomData::setCustomBoolean);
		attributeGetterFunctions.put("customData", CustomData::getCustomData);
		attributeSetterBiConsumers.put(
			"customData",
			(BiConsumer<CustomData, Date>)CustomData::setCustomData);
		attributeGetterFunctions.put("customInt", CustomData::getCustomInt);
		attributeSetterBiConsumers.put(
			"customInt",
			(BiConsumer<CustomData, Integer>)CustomData::setCustomInt);
		attributeGetterFunctions.put("customLong", CustomData::getCustomLong);
		attributeSetterBiConsumers.put(
			"customLong",
			(BiConsumer<CustomData, Long>)CustomData::setCustomLong);
		attributeGetterFunctions.put(
			"customString", CustomData::getCustomString);
		attributeSetterBiConsumers.put(
			"customString",
			(BiConsumer<CustomData, String>)CustomData::setCustomString);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		_columnBitmask |= UUID_COLUMN_BITMASK;

		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@JSON
	@Override
	public long getCustomDataId() {
		return _customDataId;
	}

	@Override
	public void setCustomDataId(long customDataId) {
		_customDataId = customDataId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public boolean getCustomBoolean() {
		return _customBoolean;
	}

	@JSON
	@Override
	public boolean isCustomBoolean() {
		return _customBoolean;
	}

	@Override
	public void setCustomBoolean(boolean customBoolean) {
		_customBoolean = customBoolean;
	}

	@JSON
	@Override
	public Date getCustomData() {
		return _customData;
	}

	@Override
	public void setCustomData(Date customData) {
		_customData = customData;
	}

	@JSON
	@Override
	public int getCustomInt() {
		return _customInt;
	}

	@Override
	public void setCustomInt(int customInt) {
		_customInt = customInt;
	}

	@JSON
	@Override
	public long getCustomLong() {
		return _customLong;
	}

	@Override
	public void setCustomLong(long customLong) {
		_columnBitmask = -1L;

		_customLong = customLong;
	}

	@JSON
	@Override
	public String getCustomString() {
		if (_customString == null) {
			return "";
		}
		else {
			return _customString;
		}
	}

	@Override
	public void setCustomString(String customString) {
		_columnBitmask |= CUSTOMSTRING_COLUMN_BITMASK;

		if (_originalCustomString == null) {
			_originalCustomString = _customString;
		}

		_customString = customString;
	}

	public String getOriginalCustomString() {
		return GetterUtil.getString(_originalCustomString);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(CustomData.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), CustomData.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public CustomData toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, CustomData>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		CustomDataImpl customDataImpl = new CustomDataImpl();

		customDataImpl.setUuid(getUuid());
		customDataImpl.setCustomDataId(getCustomDataId());
		customDataImpl.setGroupId(getGroupId());
		customDataImpl.setCompanyId(getCompanyId());
		customDataImpl.setUserId(getUserId());
		customDataImpl.setUserName(getUserName());
		customDataImpl.setCreateDate(getCreateDate());
		customDataImpl.setModifiedDate(getModifiedDate());
		customDataImpl.setCustomBoolean(isCustomBoolean());
		customDataImpl.setCustomData(getCustomData());
		customDataImpl.setCustomInt(getCustomInt());
		customDataImpl.setCustomLong(getCustomLong());
		customDataImpl.setCustomString(getCustomString());

		customDataImpl.resetOriginalValues();

		return customDataImpl;
	}

	@Override
	public int compareTo(CustomData customData) {
		int value = 0;

		if (getCustomLong() < customData.getCustomLong()) {
			value = -1;
		}
		else if (getCustomLong() > customData.getCustomLong()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CustomData)) {
			return false;
		}

		CustomData customData = (CustomData)obj;

		long primaryKey = customData.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _entityCacheEnabled;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _finderCacheEnabled;
	}

	@Override
	public void resetOriginalValues() {
		CustomDataModelImpl customDataModelImpl = this;

		customDataModelImpl._originalUuid = customDataModelImpl._uuid;

		customDataModelImpl._originalGroupId = customDataModelImpl._groupId;

		customDataModelImpl._setOriginalGroupId = false;

		customDataModelImpl._originalCompanyId = customDataModelImpl._companyId;

		customDataModelImpl._setOriginalCompanyId = false;

		customDataModelImpl._setModifiedDate = false;

		customDataModelImpl._originalCustomString =
			customDataModelImpl._customString;

		customDataModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<CustomData> toCacheModel() {
		CustomDataCacheModel customDataCacheModel = new CustomDataCacheModel();

		customDataCacheModel.uuid = getUuid();

		String uuid = customDataCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			customDataCacheModel.uuid = null;
		}

		customDataCacheModel.customDataId = getCustomDataId();

		customDataCacheModel.groupId = getGroupId();

		customDataCacheModel.companyId = getCompanyId();

		customDataCacheModel.userId = getUserId();

		customDataCacheModel.userName = getUserName();

		String userName = customDataCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			customDataCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			customDataCacheModel.createDate = createDate.getTime();
		}
		else {
			customDataCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			customDataCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			customDataCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		customDataCacheModel.customBoolean = isCustomBoolean();

		Date customData = getCustomData();

		if (customData != null) {
			customDataCacheModel.customData = customData.getTime();
		}
		else {
			customDataCacheModel.customData = Long.MIN_VALUE;
		}

		customDataCacheModel.customInt = getCustomInt();

		customDataCacheModel.customLong = getCustomLong();

		customDataCacheModel.customString = getCustomString();

		String customString = customDataCacheModel.customString;

		if ((customString != null) && (customString.length() == 0)) {
			customDataCacheModel.customString = null;
		}

		return customDataCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<CustomData, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<CustomData, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CustomData, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((CustomData)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<CustomData, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<CustomData, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CustomData, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((CustomData)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, CustomData>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private String _uuid;
	private String _originalUuid;
	private long _customDataId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private boolean _customBoolean;
	private Date _customData;
	private int _customInt;
	private long _customLong;
	private String _customString;
	private String _originalCustomString;
	private long _columnBitmask;
	private CustomData _escapedModel;

}