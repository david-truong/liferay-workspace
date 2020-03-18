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

import com.liferay.custom.data.exception.NoSuchCustomDataException;
import com.liferay.custom.data.model.CustomData;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the custom data service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CustomDataUtil
 * @generated
 */
@ProviderType
public interface CustomDataPersistence extends BasePersistence<CustomData> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CustomDataUtil} to access the custom data persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the custom datas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching custom datas
	 */
	public java.util.List<CustomData> findByUuid(String uuid);

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
	public java.util.List<CustomData> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<CustomData> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CustomData>
			orderByComparator);

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
	public java.util.List<CustomData> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CustomData>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first custom data in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching custom data
	 * @throws NoSuchCustomDataException if a matching custom data could not be found
	 */
	public CustomData findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CustomData>
				orderByComparator)
		throws NoSuchCustomDataException;

	/**
	 * Returns the first custom data in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching custom data, or <code>null</code> if a matching custom data could not be found
	 */
	public CustomData fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CustomData>
			orderByComparator);

	/**
	 * Returns the last custom data in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching custom data
	 * @throws NoSuchCustomDataException if a matching custom data could not be found
	 */
	public CustomData findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CustomData>
				orderByComparator)
		throws NoSuchCustomDataException;

	/**
	 * Returns the last custom data in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching custom data, or <code>null</code> if a matching custom data could not be found
	 */
	public CustomData fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CustomData>
			orderByComparator);

	/**
	 * Returns the custom datas before and after the current custom data in the ordered set where uuid = &#63;.
	 *
	 * @param customDataId the primary key of the current custom data
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next custom data
	 * @throws NoSuchCustomDataException if a custom data with the primary key could not be found
	 */
	public CustomData[] findByUuid_PrevAndNext(
			long customDataId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CustomData>
				orderByComparator)
		throws NoSuchCustomDataException;

	/**
	 * Removes all the custom datas where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of custom datas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching custom datas
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the custom data where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCustomDataException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching custom data
	 * @throws NoSuchCustomDataException if a matching custom data could not be found
	 */
	public CustomData findByUUID_G(String uuid, long groupId)
		throws NoSuchCustomDataException;

	/**
	 * Returns the custom data where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching custom data, or <code>null</code> if a matching custom data could not be found
	 */
	public CustomData fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the custom data where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching custom data, or <code>null</code> if a matching custom data could not be found
	 */
	public CustomData fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the custom data where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the custom data that was removed
	 */
	public CustomData removeByUUID_G(String uuid, long groupId)
		throws NoSuchCustomDataException;

	/**
	 * Returns the number of custom datas where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching custom datas
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the custom datas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching custom datas
	 */
	public java.util.List<CustomData> findByUuid_C(String uuid, long companyId);

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
	public java.util.List<CustomData> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<CustomData> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CustomData>
			orderByComparator);

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
	public java.util.List<CustomData> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CustomData>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first custom data in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching custom data
	 * @throws NoSuchCustomDataException if a matching custom data could not be found
	 */
	public CustomData findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<CustomData>
				orderByComparator)
		throws NoSuchCustomDataException;

	/**
	 * Returns the first custom data in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching custom data, or <code>null</code> if a matching custom data could not be found
	 */
	public CustomData fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<CustomData>
			orderByComparator);

	/**
	 * Returns the last custom data in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching custom data
	 * @throws NoSuchCustomDataException if a matching custom data could not be found
	 */
	public CustomData findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<CustomData>
				orderByComparator)
		throws NoSuchCustomDataException;

	/**
	 * Returns the last custom data in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching custom data, or <code>null</code> if a matching custom data could not be found
	 */
	public CustomData fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<CustomData>
			orderByComparator);

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
	public CustomData[] findByUuid_C_PrevAndNext(
			long customDataId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<CustomData>
				orderByComparator)
		throws NoSuchCustomDataException;

	/**
	 * Removes all the custom datas where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of custom datas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching custom datas
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the custom datas where customString = &#63;.
	 *
	 * @param customString the custom string
	 * @return the matching custom datas
	 */
	public java.util.List<CustomData> findByCustomString(String customString);

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
	public java.util.List<CustomData> findByCustomString(
		String customString, int start, int end);

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
	public java.util.List<CustomData> findByCustomString(
		String customString, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CustomData>
			orderByComparator);

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
	public java.util.List<CustomData> findByCustomString(
		String customString, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CustomData>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first custom data in the ordered set where customString = &#63;.
	 *
	 * @param customString the custom string
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching custom data
	 * @throws NoSuchCustomDataException if a matching custom data could not be found
	 */
	public CustomData findByCustomString_First(
			String customString,
			com.liferay.portal.kernel.util.OrderByComparator<CustomData>
				orderByComparator)
		throws NoSuchCustomDataException;

	/**
	 * Returns the first custom data in the ordered set where customString = &#63;.
	 *
	 * @param customString the custom string
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching custom data, or <code>null</code> if a matching custom data could not be found
	 */
	public CustomData fetchByCustomString_First(
		String customString,
		com.liferay.portal.kernel.util.OrderByComparator<CustomData>
			orderByComparator);

	/**
	 * Returns the last custom data in the ordered set where customString = &#63;.
	 *
	 * @param customString the custom string
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching custom data
	 * @throws NoSuchCustomDataException if a matching custom data could not be found
	 */
	public CustomData findByCustomString_Last(
			String customString,
			com.liferay.portal.kernel.util.OrderByComparator<CustomData>
				orderByComparator)
		throws NoSuchCustomDataException;

	/**
	 * Returns the last custom data in the ordered set where customString = &#63;.
	 *
	 * @param customString the custom string
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching custom data, or <code>null</code> if a matching custom data could not be found
	 */
	public CustomData fetchByCustomString_Last(
		String customString,
		com.liferay.portal.kernel.util.OrderByComparator<CustomData>
			orderByComparator);

	/**
	 * Returns the custom datas before and after the current custom data in the ordered set where customString = &#63;.
	 *
	 * @param customDataId the primary key of the current custom data
	 * @param customString the custom string
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next custom data
	 * @throws NoSuchCustomDataException if a custom data with the primary key could not be found
	 */
	public CustomData[] findByCustomString_PrevAndNext(
			long customDataId, String customString,
			com.liferay.portal.kernel.util.OrderByComparator<CustomData>
				orderByComparator)
		throws NoSuchCustomDataException;

	/**
	 * Removes all the custom datas where customString = &#63; from the database.
	 *
	 * @param customString the custom string
	 */
	public void removeByCustomString(String customString);

	/**
	 * Returns the number of custom datas where customString = &#63;.
	 *
	 * @param customString the custom string
	 * @return the number of matching custom datas
	 */
	public int countByCustomString(String customString);

	/**
	 * Caches the custom data in the entity cache if it is enabled.
	 *
	 * @param customData the custom data
	 */
	public void cacheResult(CustomData customData);

	/**
	 * Caches the custom datas in the entity cache if it is enabled.
	 *
	 * @param customDatas the custom datas
	 */
	public void cacheResult(java.util.List<CustomData> customDatas);

	/**
	 * Creates a new custom data with the primary key. Does not add the custom data to the database.
	 *
	 * @param customDataId the primary key for the new custom data
	 * @return the new custom data
	 */
	public CustomData create(long customDataId);

	/**
	 * Removes the custom data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param customDataId the primary key of the custom data
	 * @return the custom data that was removed
	 * @throws NoSuchCustomDataException if a custom data with the primary key could not be found
	 */
	public CustomData remove(long customDataId)
		throws NoSuchCustomDataException;

	public CustomData updateImpl(CustomData customData);

	/**
	 * Returns the custom data with the primary key or throws a <code>NoSuchCustomDataException</code> if it could not be found.
	 *
	 * @param customDataId the primary key of the custom data
	 * @return the custom data
	 * @throws NoSuchCustomDataException if a custom data with the primary key could not be found
	 */
	public CustomData findByPrimaryKey(long customDataId)
		throws NoSuchCustomDataException;

	/**
	 * Returns the custom data with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param customDataId the primary key of the custom data
	 * @return the custom data, or <code>null</code> if a custom data with the primary key could not be found
	 */
	public CustomData fetchByPrimaryKey(long customDataId);

	/**
	 * Returns all the custom datas.
	 *
	 * @return the custom datas
	 */
	public java.util.List<CustomData> findAll();

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
	public java.util.List<CustomData> findAll(int start, int end);

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
	public java.util.List<CustomData> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CustomData>
			orderByComparator);

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
	public java.util.List<CustomData> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CustomData>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the custom datas from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of custom datas.
	 *
	 * @return the number of custom datas
	 */
	public int countAll();

}