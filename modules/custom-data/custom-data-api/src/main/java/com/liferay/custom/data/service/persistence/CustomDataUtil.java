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

package com.liferay.custom.data.service.persistence;

import com.liferay.custom.data.model.CustomData;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the custom data service. This utility wraps <code>com.liferay.custom.data.service.persistence.impl.CustomDataPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CustomDataPersistence
 * @generated
 */
public class CustomDataUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(CustomData customData) {
		getPersistence().clearCache(customData);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, CustomData> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CustomData> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CustomData> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CustomData> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CustomData> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CustomData update(CustomData customData) {
		return getPersistence().update(customData);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CustomData update(
		CustomData customData, ServiceContext serviceContext) {

		return getPersistence().update(customData, serviceContext);
	}

	/**
	 * Returns all the custom datas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching custom datas
	 */
	public static List<CustomData> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the custom datas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomDataModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of custom datas
	 * @param end the upper bound of the range of custom datas (not inclusive)
	 * @return the range of matching custom datas
	 */
	public static List<CustomData> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the custom datas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomDataModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of custom datas
	 * @param end the upper bound of the range of custom datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching custom datas
	 */
	public static List<CustomData> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CustomData> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the custom datas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomDataModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of custom datas
	 * @param end the upper bound of the range of custom datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching custom datas
	 */
	public static List<CustomData> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CustomData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first custom data in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching custom data
	 * @throws NoSuchCustomDataException if a matching custom data could not be found
	 */
	public static CustomData findByUuid_First(
			String uuid, OrderByComparator<CustomData> orderByComparator)
		throws com.liferay.custom.data.exception.NoSuchCustomDataException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first custom data in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching custom data, or <code>null</code> if a matching custom data could not be found
	 */
	public static CustomData fetchByUuid_First(
		String uuid, OrderByComparator<CustomData> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last custom data in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching custom data
	 * @throws NoSuchCustomDataException if a matching custom data could not be found
	 */
	public static CustomData findByUuid_Last(
			String uuid, OrderByComparator<CustomData> orderByComparator)
		throws com.liferay.custom.data.exception.NoSuchCustomDataException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last custom data in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching custom data, or <code>null</code> if a matching custom data could not be found
	 */
	public static CustomData fetchByUuid_Last(
		String uuid, OrderByComparator<CustomData> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the custom datas before and after the current custom data in the ordered set where uuid = &#63;.
	 *
	 * @param customDataId the primary key of the current custom data
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next custom data
	 * @throws NoSuchCustomDataException if a custom data with the primary key could not be found
	 */
	public static CustomData[] findByUuid_PrevAndNext(
			long customDataId, String uuid,
			OrderByComparator<CustomData> orderByComparator)
		throws com.liferay.custom.data.exception.NoSuchCustomDataException {

		return getPersistence().findByUuid_PrevAndNext(
			customDataId, uuid, orderByComparator);
	}

	/**
	 * Removes all the custom datas where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of custom datas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching custom datas
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the custom data where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCustomDataException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching custom data
	 * @throws NoSuchCustomDataException if a matching custom data could not be found
	 */
	public static CustomData findByUUID_G(String uuid, long groupId)
		throws com.liferay.custom.data.exception.NoSuchCustomDataException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the custom data where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching custom data, or <code>null</code> if a matching custom data could not be found
	 */
	public static CustomData fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the custom data where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching custom data, or <code>null</code> if a matching custom data could not be found
	 */
	public static CustomData fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the custom data where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the custom data that was removed
	 */
	public static CustomData removeByUUID_G(String uuid, long groupId)
		throws com.liferay.custom.data.exception.NoSuchCustomDataException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of custom datas where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching custom datas
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the custom datas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching custom datas
	 */
	public static List<CustomData> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the custom datas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomDataModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of custom datas
	 * @param end the upper bound of the range of custom datas (not inclusive)
	 * @return the range of matching custom datas
	 */
	public static List<CustomData> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the custom datas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomDataModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of custom datas
	 * @param end the upper bound of the range of custom datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching custom datas
	 */
	public static List<CustomData> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CustomData> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the custom datas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomDataModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of custom datas
	 * @param end the upper bound of the range of custom datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching custom datas
	 */
	public static List<CustomData> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CustomData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first custom data in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching custom data
	 * @throws NoSuchCustomDataException if a matching custom data could not be found
	 */
	public static CustomData findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<CustomData> orderByComparator)
		throws com.liferay.custom.data.exception.NoSuchCustomDataException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first custom data in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching custom data, or <code>null</code> if a matching custom data could not be found
	 */
	public static CustomData fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<CustomData> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last custom data in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching custom data
	 * @throws NoSuchCustomDataException if a matching custom data could not be found
	 */
	public static CustomData findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<CustomData> orderByComparator)
		throws com.liferay.custom.data.exception.NoSuchCustomDataException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last custom data in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching custom data, or <code>null</code> if a matching custom data could not be found
	 */
	public static CustomData fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<CustomData> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the custom datas before and after the current custom data in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param customDataId the primary key of the current custom data
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next custom data
	 * @throws NoSuchCustomDataException if a custom data with the primary key could not be found
	 */
	public static CustomData[] findByUuid_C_PrevAndNext(
			long customDataId, String uuid, long companyId,
			OrderByComparator<CustomData> orderByComparator)
		throws com.liferay.custom.data.exception.NoSuchCustomDataException {

		return getPersistence().findByUuid_C_PrevAndNext(
			customDataId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the custom datas where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of custom datas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching custom datas
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the custom datas where customString = &#63;.
	 *
	 * @param customString the custom string
	 * @return the matching custom datas
	 */
	public static List<CustomData> findByCustomString(String customString) {
		return getPersistence().findByCustomString(customString);
	}

	/**
	 * Returns a range of all the custom datas where customString = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomDataModelImpl</code>.
	 * </p>
	 *
	 * @param customString the custom string
	 * @param start the lower bound of the range of custom datas
	 * @param end the upper bound of the range of custom datas (not inclusive)
	 * @return the range of matching custom datas
	 */
	public static List<CustomData> findByCustomString(
		String customString, int start, int end) {

		return getPersistence().findByCustomString(customString, start, end);
	}

	/**
	 * Returns an ordered range of all the custom datas where customString = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomDataModelImpl</code>.
	 * </p>
	 *
	 * @param customString the custom string
	 * @param start the lower bound of the range of custom datas
	 * @param end the upper bound of the range of custom datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching custom datas
	 */
	public static List<CustomData> findByCustomString(
		String customString, int start, int end,
		OrderByComparator<CustomData> orderByComparator) {

		return getPersistence().findByCustomString(
			customString, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the custom datas where customString = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomDataModelImpl</code>.
	 * </p>
	 *
	 * @param customString the custom string
	 * @param start the lower bound of the range of custom datas
	 * @param end the upper bound of the range of custom datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching custom datas
	 */
	public static List<CustomData> findByCustomString(
		String customString, int start, int end,
		OrderByComparator<CustomData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCustomString(
			customString, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first custom data in the ordered set where customString = &#63;.
	 *
	 * @param customString the custom string
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching custom data
	 * @throws NoSuchCustomDataException if a matching custom data could not be found
	 */
	public static CustomData findByCustomString_First(
			String customString,
			OrderByComparator<CustomData> orderByComparator)
		throws com.liferay.custom.data.exception.NoSuchCustomDataException {

		return getPersistence().findByCustomString_First(
			customString, orderByComparator);
	}

	/**
	 * Returns the first custom data in the ordered set where customString = &#63;.
	 *
	 * @param customString the custom string
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching custom data, or <code>null</code> if a matching custom data could not be found
	 */
	public static CustomData fetchByCustomString_First(
		String customString, OrderByComparator<CustomData> orderByComparator) {

		return getPersistence().fetchByCustomString_First(
			customString, orderByComparator);
	}

	/**
	 * Returns the last custom data in the ordered set where customString = &#63;.
	 *
	 * @param customString the custom string
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching custom data
	 * @throws NoSuchCustomDataException if a matching custom data could not be found
	 */
	public static CustomData findByCustomString_Last(
			String customString,
			OrderByComparator<CustomData> orderByComparator)
		throws com.liferay.custom.data.exception.NoSuchCustomDataException {

		return getPersistence().findByCustomString_Last(
			customString, orderByComparator);
	}

	/**
	 * Returns the last custom data in the ordered set where customString = &#63;.
	 *
	 * @param customString the custom string
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching custom data, or <code>null</code> if a matching custom data could not be found
	 */
	public static CustomData fetchByCustomString_Last(
		String customString, OrderByComparator<CustomData> orderByComparator) {

		return getPersistence().fetchByCustomString_Last(
			customString, orderByComparator);
	}

	/**
	 * Returns the custom datas before and after the current custom data in the ordered set where customString = &#63;.
	 *
	 * @param customDataId the primary key of the current custom data
	 * @param customString the custom string
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next custom data
	 * @throws NoSuchCustomDataException if a custom data with the primary key could not be found
	 */
	public static CustomData[] findByCustomString_PrevAndNext(
			long customDataId, String customString,
			OrderByComparator<CustomData> orderByComparator)
		throws com.liferay.custom.data.exception.NoSuchCustomDataException {

		return getPersistence().findByCustomString_PrevAndNext(
			customDataId, customString, orderByComparator);
	}

	/**
	 * Removes all the custom datas where customString = &#63; from the database.
	 *
	 * @param customString the custom string
	 */
	public static void removeByCustomString(String customString) {
		getPersistence().removeByCustomString(customString);
	}

	/**
	 * Returns the number of custom datas where customString = &#63;.
	 *
	 * @param customString the custom string
	 * @return the number of matching custom datas
	 */
	public static int countByCustomString(String customString) {
		return getPersistence().countByCustomString(customString);
	}

	/**
	 * Caches the custom data in the entity cache if it is enabled.
	 *
	 * @param customData the custom data
	 */
	public static void cacheResult(CustomData customData) {
		getPersistence().cacheResult(customData);
	}

	/**
	 * Caches the custom datas in the entity cache if it is enabled.
	 *
	 * @param customDatas the custom datas
	 */
	public static void cacheResult(List<CustomData> customDatas) {
		getPersistence().cacheResult(customDatas);
	}

	/**
	 * Creates a new custom data with the primary key. Does not add the custom data to the database.
	 *
	 * @param customDataId the primary key for the new custom data
	 * @return the new custom data
	 */
	public static CustomData create(long customDataId) {
		return getPersistence().create(customDataId);
	}

	/**
	 * Removes the custom data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param customDataId the primary key of the custom data
	 * @return the custom data that was removed
	 * @throws NoSuchCustomDataException if a custom data with the primary key could not be found
	 */
	public static CustomData remove(long customDataId)
		throws com.liferay.custom.data.exception.NoSuchCustomDataException {

		return getPersistence().remove(customDataId);
	}

	public static CustomData updateImpl(CustomData customData) {
		return getPersistence().updateImpl(customData);
	}

	/**
	 * Returns the custom data with the primary key or throws a <code>NoSuchCustomDataException</code> if it could not be found.
	 *
	 * @param customDataId the primary key of the custom data
	 * @return the custom data
	 * @throws NoSuchCustomDataException if a custom data with the primary key could not be found
	 */
	public static CustomData findByPrimaryKey(long customDataId)
		throws com.liferay.custom.data.exception.NoSuchCustomDataException {

		return getPersistence().findByPrimaryKey(customDataId);
	}

	/**
	 * Returns the custom data with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param customDataId the primary key of the custom data
	 * @return the custom data, or <code>null</code> if a custom data with the primary key could not be found
	 */
	public static CustomData fetchByPrimaryKey(long customDataId) {
		return getPersistence().fetchByPrimaryKey(customDataId);
	}

	/**
	 * Returns all the custom datas.
	 *
	 * @return the custom datas
	 */
	public static List<CustomData> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the custom datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomDataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of custom datas
	 * @param end the upper bound of the range of custom datas (not inclusive)
	 * @return the range of custom datas
	 */
	public static List<CustomData> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the custom datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomDataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of custom datas
	 * @param end the upper bound of the range of custom datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of custom datas
	 */
	public static List<CustomData> findAll(
		int start, int end, OrderByComparator<CustomData> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the custom datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomDataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of custom datas
	 * @param end the upper bound of the range of custom datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of custom datas
	 */
	public static List<CustomData> findAll(
		int start, int end, OrderByComparator<CustomData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the custom datas from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of custom datas.
	 *
	 * @return the number of custom datas
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CustomDataPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CustomDataPersistence, CustomDataPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(CustomDataPersistence.class);

		ServiceTracker<CustomDataPersistence, CustomDataPersistence>
			serviceTracker =
				new ServiceTracker
					<CustomDataPersistence, CustomDataPersistence>(
						bundle.getBundleContext(), CustomDataPersistence.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}