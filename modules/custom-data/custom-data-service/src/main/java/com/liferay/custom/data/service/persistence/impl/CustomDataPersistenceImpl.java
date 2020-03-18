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

package com.liferay.custom.data.service.persistence.impl;

import com.liferay.custom.data.exception.NoSuchCustomDataException;
import com.liferay.custom.data.model.CustomData;
import com.liferay.custom.data.model.impl.CustomDataImpl;
import com.liferay.custom.data.model.impl.CustomDataModelImpl;
import com.liferay.custom.data.service.persistence.CustomDataPersistence;
import com.liferay.custom.data.service.persistence.impl.constants.CustomDataPersistenceConstants;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the custom data service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = CustomDataPersistence.class)
public class CustomDataPersistenceImpl
	extends BasePersistenceImpl<CustomData> implements CustomDataPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CustomDataUtil</code> to access the custom data persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CustomDataImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the custom datas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching custom datas
	 */
	@Override
	public List<CustomData> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<CustomData> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<CustomData> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CustomData> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<CustomData> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CustomData> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<CustomData> list = null;

		if (useFinderCache) {
			list = (List<CustomData>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CustomData customData : list) {
					if (!uuid.equals(customData.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_CUSTOMDATA_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CustomDataModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<CustomData>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first custom data in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching custom data
	 * @throws NoSuchCustomDataException if a matching custom data could not be found
	 */
	@Override
	public CustomData findByUuid_First(
			String uuid, OrderByComparator<CustomData> orderByComparator)
		throws NoSuchCustomDataException {

		CustomData customData = fetchByUuid_First(uuid, orderByComparator);

		if (customData != null) {
			return customData;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchCustomDataException(sb.toString());
	}

	/**
	 * Returns the first custom data in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching custom data, or <code>null</code> if a matching custom data could not be found
	 */
	@Override
	public CustomData fetchByUuid_First(
		String uuid, OrderByComparator<CustomData> orderByComparator) {

		List<CustomData> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last custom data in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching custom data
	 * @throws NoSuchCustomDataException if a matching custom data could not be found
	 */
	@Override
	public CustomData findByUuid_Last(
			String uuid, OrderByComparator<CustomData> orderByComparator)
		throws NoSuchCustomDataException {

		CustomData customData = fetchByUuid_Last(uuid, orderByComparator);

		if (customData != null) {
			return customData;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchCustomDataException(sb.toString());
	}

	/**
	 * Returns the last custom data in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching custom data, or <code>null</code> if a matching custom data could not be found
	 */
	@Override
	public CustomData fetchByUuid_Last(
		String uuid, OrderByComparator<CustomData> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<CustomData> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CustomData[] findByUuid_PrevAndNext(
			long customDataId, String uuid,
			OrderByComparator<CustomData> orderByComparator)
		throws NoSuchCustomDataException {

		uuid = Objects.toString(uuid, "");

		CustomData customData = findByPrimaryKey(customDataId);

		Session session = null;

		try {
			session = openSession();

			CustomData[] array = new CustomDataImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, customData, uuid, orderByComparator, true);

			array[1] = customData;

			array[2] = getByUuid_PrevAndNext(
				session, customData, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CustomData getByUuid_PrevAndNext(
		Session session, CustomData customData, String uuid,
		OrderByComparator<CustomData> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CUSTOMDATA_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(CustomDataModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(customData)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CustomData> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the custom datas where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (CustomData customData :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(customData);
		}
	}

	/**
	 * Returns the number of custom datas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching custom datas
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CUSTOMDATA_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"customData.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(customData.uuid IS NULL OR customData.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the custom data where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCustomDataException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching custom data
	 * @throws NoSuchCustomDataException if a matching custom data could not be found
	 */
	@Override
	public CustomData findByUUID_G(String uuid, long groupId)
		throws NoSuchCustomDataException {

		CustomData customData = fetchByUUID_G(uuid, groupId);

		if (customData == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("uuid=");
			sb.append(uuid);

			sb.append(", groupId=");
			sb.append(groupId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchCustomDataException(sb.toString());
		}

		return customData;
	}

	/**
	 * Returns the custom data where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching custom data, or <code>null</code> if a matching custom data could not be found
	 */
	@Override
	public CustomData fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the custom data where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching custom data, or <code>null</code> if a matching custom data could not be found
	 */
	@Override
	public CustomData fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {uuid, groupId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs, this);
		}

		if (result instanceof CustomData) {
			CustomData customData = (CustomData)result;

			if (!Objects.equals(uuid, customData.getUuid()) ||
				(groupId != customData.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_CUSTOMDATA_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				List<CustomData> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					CustomData customData = list.get(0);

					result = customData;

					cacheResult(customData);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByUUID_G, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (CustomData)result;
		}
	}

	/**
	 * Removes the custom data where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the custom data that was removed
	 */
	@Override
	public CustomData removeByUUID_G(String uuid, long groupId)
		throws NoSuchCustomDataException {

		CustomData customData = findByUUID_G(uuid, groupId);

		return remove(customData);
	}

	/**
	 * Returns the number of custom datas where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching custom datas
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CUSTOMDATA_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"customData.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(customData.uuid IS NULL OR customData.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"customData.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the custom datas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching custom datas
	 */
	@Override
	public List<CustomData> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<CustomData> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<CustomData> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CustomData> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<CustomData> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CustomData> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid_C;
				finderArgs = new Object[] {uuid, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<CustomData> list = null;

		if (useFinderCache) {
			list = (List<CustomData>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CustomData customData : list) {
					if (!uuid.equals(customData.getUuid()) ||
						(companyId != customData.getCompanyId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_CUSTOMDATA_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CustomDataModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				list = (List<CustomData>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public CustomData findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<CustomData> orderByComparator)
		throws NoSuchCustomDataException {

		CustomData customData = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (customData != null) {
			return customData;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchCustomDataException(sb.toString());
	}

	/**
	 * Returns the first custom data in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching custom data, or <code>null</code> if a matching custom data could not be found
	 */
	@Override
	public CustomData fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<CustomData> orderByComparator) {

		List<CustomData> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CustomData findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<CustomData> orderByComparator)
		throws NoSuchCustomDataException {

		CustomData customData = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (customData != null) {
			return customData;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchCustomDataException(sb.toString());
	}

	/**
	 * Returns the last custom data in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching custom data, or <code>null</code> if a matching custom data could not be found
	 */
	@Override
	public CustomData fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<CustomData> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<CustomData> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CustomData[] findByUuid_C_PrevAndNext(
			long customDataId, String uuid, long companyId,
			OrderByComparator<CustomData> orderByComparator)
		throws NoSuchCustomDataException {

		uuid = Objects.toString(uuid, "");

		CustomData customData = findByPrimaryKey(customDataId);

		Session session = null;

		try {
			session = openSession();

			CustomData[] array = new CustomDataImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, customData, uuid, companyId, orderByComparator, true);

			array[1] = customData;

			array[2] = getByUuid_C_PrevAndNext(
				session, customData, uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CustomData getByUuid_C_PrevAndNext(
		Session session, CustomData customData, String uuid, long companyId,
		OrderByComparator<CustomData> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_CUSTOMDATA_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(CustomDataModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(customData)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CustomData> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the custom datas where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (CustomData customData :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(customData);
		}
	}

	/**
	 * Returns the number of custom datas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching custom datas
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CUSTOMDATA_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"customData.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(customData.uuid IS NULL OR customData.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"customData.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByCustomString;
	private FinderPath _finderPathWithoutPaginationFindByCustomString;
	private FinderPath _finderPathCountByCustomString;

	/**
	 * Returns all the custom datas where customString = &#63;.
	 *
	 * @param customString the custom string
	 * @return the matching custom datas
	 */
	@Override
	public List<CustomData> findByCustomString(String customString) {
		return findByCustomString(
			customString, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<CustomData> findByCustomString(
		String customString, int start, int end) {

		return findByCustomString(customString, start, end, null);
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
	@Override
	public List<CustomData> findByCustomString(
		String customString, int start, int end,
		OrderByComparator<CustomData> orderByComparator) {

		return findByCustomString(
			customString, start, end, orderByComparator, true);
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
	@Override
	public List<CustomData> findByCustomString(
		String customString, int start, int end,
		OrderByComparator<CustomData> orderByComparator,
		boolean useFinderCache) {

		customString = Objects.toString(customString, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByCustomString;
				finderArgs = new Object[] {customString};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByCustomString;
			finderArgs = new Object[] {
				customString, start, end, orderByComparator
			};
		}

		List<CustomData> list = null;

		if (useFinderCache) {
			list = (List<CustomData>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CustomData customData : list) {
					if (!customString.equals(customData.getCustomString())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_CUSTOMDATA_WHERE);

			boolean bindCustomString = false;

			if (customString.isEmpty()) {
				sb.append(_FINDER_COLUMN_CUSTOMSTRING_CUSTOMSTRING_3);
			}
			else {
				bindCustomString = true;

				sb.append(_FINDER_COLUMN_CUSTOMSTRING_CUSTOMSTRING_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CustomDataModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCustomString) {
					queryPos.add(customString);
				}

				list = (List<CustomData>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first custom data in the ordered set where customString = &#63;.
	 *
	 * @param customString the custom string
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching custom data
	 * @throws NoSuchCustomDataException if a matching custom data could not be found
	 */
	@Override
	public CustomData findByCustomString_First(
			String customString,
			OrderByComparator<CustomData> orderByComparator)
		throws NoSuchCustomDataException {

		CustomData customData = fetchByCustomString_First(
			customString, orderByComparator);

		if (customData != null) {
			return customData;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("customString=");
		sb.append(customString);

		sb.append("}");

		throw new NoSuchCustomDataException(sb.toString());
	}

	/**
	 * Returns the first custom data in the ordered set where customString = &#63;.
	 *
	 * @param customString the custom string
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching custom data, or <code>null</code> if a matching custom data could not be found
	 */
	@Override
	public CustomData fetchByCustomString_First(
		String customString, OrderByComparator<CustomData> orderByComparator) {

		List<CustomData> list = findByCustomString(
			customString, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last custom data in the ordered set where customString = &#63;.
	 *
	 * @param customString the custom string
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching custom data
	 * @throws NoSuchCustomDataException if a matching custom data could not be found
	 */
	@Override
	public CustomData findByCustomString_Last(
			String customString,
			OrderByComparator<CustomData> orderByComparator)
		throws NoSuchCustomDataException {

		CustomData customData = fetchByCustomString_Last(
			customString, orderByComparator);

		if (customData != null) {
			return customData;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("customString=");
		sb.append(customString);

		sb.append("}");

		throw new NoSuchCustomDataException(sb.toString());
	}

	/**
	 * Returns the last custom data in the ordered set where customString = &#63;.
	 *
	 * @param customString the custom string
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching custom data, or <code>null</code> if a matching custom data could not be found
	 */
	@Override
	public CustomData fetchByCustomString_Last(
		String customString, OrderByComparator<CustomData> orderByComparator) {

		int count = countByCustomString(customString);

		if (count == 0) {
			return null;
		}

		List<CustomData> list = findByCustomString(
			customString, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CustomData[] findByCustomString_PrevAndNext(
			long customDataId, String customString,
			OrderByComparator<CustomData> orderByComparator)
		throws NoSuchCustomDataException {

		customString = Objects.toString(customString, "");

		CustomData customData = findByPrimaryKey(customDataId);

		Session session = null;

		try {
			session = openSession();

			CustomData[] array = new CustomDataImpl[3];

			array[0] = getByCustomString_PrevAndNext(
				session, customData, customString, orderByComparator, true);

			array[1] = customData;

			array[2] = getByCustomString_PrevAndNext(
				session, customData, customString, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CustomData getByCustomString_PrevAndNext(
		Session session, CustomData customData, String customString,
		OrderByComparator<CustomData> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CUSTOMDATA_WHERE);

		boolean bindCustomString = false;

		if (customString.isEmpty()) {
			sb.append(_FINDER_COLUMN_CUSTOMSTRING_CUSTOMSTRING_3);
		}
		else {
			bindCustomString = true;

			sb.append(_FINDER_COLUMN_CUSTOMSTRING_CUSTOMSTRING_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(CustomDataModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindCustomString) {
			queryPos.add(customString);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(customData)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CustomData> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the custom datas where customString = &#63; from the database.
	 *
	 * @param customString the custom string
	 */
	@Override
	public void removeByCustomString(String customString) {
		for (CustomData customData :
				findByCustomString(
					customString, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(customData);
		}
	}

	/**
	 * Returns the number of custom datas where customString = &#63;.
	 *
	 * @param customString the custom string
	 * @return the number of matching custom datas
	 */
	@Override
	public int countByCustomString(String customString) {
		customString = Objects.toString(customString, "");

		FinderPath finderPath = _finderPathCountByCustomString;

		Object[] finderArgs = new Object[] {customString};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CUSTOMDATA_WHERE);

			boolean bindCustomString = false;

			if (customString.isEmpty()) {
				sb.append(_FINDER_COLUMN_CUSTOMSTRING_CUSTOMSTRING_3);
			}
			else {
				bindCustomString = true;

				sb.append(_FINDER_COLUMN_CUSTOMSTRING_CUSTOMSTRING_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCustomString) {
					queryPos.add(customString);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CUSTOMSTRING_CUSTOMSTRING_2 =
		"customData.customString = ?";

	private static final String _FINDER_COLUMN_CUSTOMSTRING_CUSTOMSTRING_3 =
		"(customData.customString IS NULL OR customData.customString = '')";

	public CustomDataPersistenceImpl() {
		setModelClass(CustomData.class);

		setModelImplClass(CustomDataImpl.class);
		setModelPKClass(long.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);
	}

	/**
	 * Caches the custom data in the entity cache if it is enabled.
	 *
	 * @param customData the custom data
	 */
	@Override
	public void cacheResult(CustomData customData) {
		entityCache.putResult(
			entityCacheEnabled, CustomDataImpl.class,
			customData.getPrimaryKey(), customData);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {customData.getUuid(), customData.getGroupId()},
			customData);

		customData.resetOriginalValues();
	}

	/**
	 * Caches the custom datas in the entity cache if it is enabled.
	 *
	 * @param customDatas the custom datas
	 */
	@Override
	public void cacheResult(List<CustomData> customDatas) {
		for (CustomData customData : customDatas) {
			if (entityCache.getResult(
					entityCacheEnabled, CustomDataImpl.class,
					customData.getPrimaryKey()) == null) {

				cacheResult(customData);
			}
			else {
				customData.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all custom datas.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CustomDataImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the custom data.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CustomData customData) {
		entityCache.removeResult(
			entityCacheEnabled, CustomDataImpl.class,
			customData.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((CustomDataModelImpl)customData, true);
	}

	@Override
	public void clearCache(List<CustomData> customDatas) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CustomData customData : customDatas) {
			entityCache.removeResult(
				entityCacheEnabled, CustomDataImpl.class,
				customData.getPrimaryKey());

			clearUniqueFindersCache((CustomDataModelImpl)customData, true);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, CustomDataImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		CustomDataModelImpl customDataModelImpl) {

		Object[] args = new Object[] {
			customDataModelImpl.getUuid(), customDataModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathCountByUUID_G, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, customDataModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		CustomDataModelImpl customDataModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				customDataModelImpl.getUuid(), customDataModelImpl.getGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}

		if ((customDataModelImpl.getColumnBitmask() &
			 _finderPathFetchByUUID_G.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				customDataModelImpl.getOriginalUuid(),
				customDataModelImpl.getOriginalGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}
	}

	/**
	 * Creates a new custom data with the primary key. Does not add the custom data to the database.
	 *
	 * @param customDataId the primary key for the new custom data
	 * @return the new custom data
	 */
	@Override
	public CustomData create(long customDataId) {
		CustomData customData = new CustomDataImpl();

		customData.setNew(true);
		customData.setPrimaryKey(customDataId);

		String uuid = PortalUUIDUtil.generate();

		customData.setUuid(uuid);

		customData.setCompanyId(CompanyThreadLocal.getCompanyId());

		return customData;
	}

	/**
	 * Removes the custom data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param customDataId the primary key of the custom data
	 * @return the custom data that was removed
	 * @throws NoSuchCustomDataException if a custom data with the primary key could not be found
	 */
	@Override
	public CustomData remove(long customDataId)
		throws NoSuchCustomDataException {

		return remove((Serializable)customDataId);
	}

	/**
	 * Removes the custom data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the custom data
	 * @return the custom data that was removed
	 * @throws NoSuchCustomDataException if a custom data with the primary key could not be found
	 */
	@Override
	public CustomData remove(Serializable primaryKey)
		throws NoSuchCustomDataException {

		Session session = null;

		try {
			session = openSession();

			CustomData customData = (CustomData)session.get(
				CustomDataImpl.class, primaryKey);

			if (customData == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCustomDataException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(customData);
		}
		catch (NoSuchCustomDataException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected CustomData removeImpl(CustomData customData) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(customData)) {
				customData = (CustomData)session.get(
					CustomDataImpl.class, customData.getPrimaryKeyObj());
			}

			if (customData != null) {
				session.delete(customData);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (customData != null) {
			clearCache(customData);
		}

		return customData;
	}

	@Override
	public CustomData updateImpl(CustomData customData) {
		boolean isNew = customData.isNew();

		if (!(customData instanceof CustomDataModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(customData.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(customData);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in customData proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom CustomData implementation " +
					customData.getClass());
		}

		CustomDataModelImpl customDataModelImpl =
			(CustomDataModelImpl)customData;

		if (Validator.isNull(customData.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			customData.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (customData.getCreateDate() == null)) {
			if (serviceContext == null) {
				customData.setCreateDate(now);
			}
			else {
				customData.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!customDataModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				customData.setModifiedDate(now);
			}
			else {
				customData.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (customData.isNew()) {
				session.save(customData);

				customData.setNew(false);
			}
			else {
				customData = (CustomData)session.merge(customData);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!_columnBitmaskEnabled) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {customDataModelImpl.getUuid()};

			finderCache.removeResult(_finderPathCountByUuid, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid, args);

			args = new Object[] {
				customDataModelImpl.getUuid(),
				customDataModelImpl.getCompanyId()
			};

			finderCache.removeResult(_finderPathCountByUuid_C, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid_C, args);

			args = new Object[] {customDataModelImpl.getCustomString()};

			finderCache.removeResult(_finderPathCountByCustomString, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByCustomString, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((customDataModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					customDataModelImpl.getOriginalUuid()
				};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);

				args = new Object[] {customDataModelImpl.getUuid()};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);
			}

			if ((customDataModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid_C.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					customDataModelImpl.getOriginalUuid(),
					customDataModelImpl.getOriginalCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);

				args = new Object[] {
					customDataModelImpl.getUuid(),
					customDataModelImpl.getCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);
			}

			if ((customDataModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByCustomString.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					customDataModelImpl.getOriginalCustomString()
				};

				finderCache.removeResult(_finderPathCountByCustomString, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCustomString, args);

				args = new Object[] {customDataModelImpl.getCustomString()};

				finderCache.removeResult(_finderPathCountByCustomString, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCustomString, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, CustomDataImpl.class,
			customData.getPrimaryKey(), customData, false);

		clearUniqueFindersCache(customDataModelImpl, false);
		cacheUniqueFindersCache(customDataModelImpl);

		customData.resetOriginalValues();

		return customData;
	}

	/**
	 * Returns the custom data with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the custom data
	 * @return the custom data
	 * @throws NoSuchCustomDataException if a custom data with the primary key could not be found
	 */
	@Override
	public CustomData findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCustomDataException {

		CustomData customData = fetchByPrimaryKey(primaryKey);

		if (customData == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCustomDataException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return customData;
	}

	/**
	 * Returns the custom data with the primary key or throws a <code>NoSuchCustomDataException</code> if it could not be found.
	 *
	 * @param customDataId the primary key of the custom data
	 * @return the custom data
	 * @throws NoSuchCustomDataException if a custom data with the primary key could not be found
	 */
	@Override
	public CustomData findByPrimaryKey(long customDataId)
		throws NoSuchCustomDataException {

		return findByPrimaryKey((Serializable)customDataId);
	}

	/**
	 * Returns the custom data with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param customDataId the primary key of the custom data
	 * @return the custom data, or <code>null</code> if a custom data with the primary key could not be found
	 */
	@Override
	public CustomData fetchByPrimaryKey(long customDataId) {
		return fetchByPrimaryKey((Serializable)customDataId);
	}

	/**
	 * Returns all the custom datas.
	 *
	 * @return the custom datas
	 */
	@Override
	public List<CustomData> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<CustomData> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<CustomData> findAll(
		int start, int end, OrderByComparator<CustomData> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<CustomData> findAll(
		int start, int end, OrderByComparator<CustomData> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<CustomData> list = null;

		if (useFinderCache) {
			list = (List<CustomData>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CUSTOMDATA);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CUSTOMDATA;

				sql = sql.concat(CustomDataModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<CustomData>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the custom datas from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CustomData customData : findAll()) {
			remove(customData);
		}
	}

	/**
	 * Returns the number of custom datas.
	 *
	 * @return the number of custom datas
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_CUSTOMDATA);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "customDataId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CUSTOMDATA;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CustomDataModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the custom data persistence.
	 */
	@Activate
	public void activate() {
		CustomDataModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		CustomDataModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CustomDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CustomDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CustomDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CustomDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()},
			CustomDataModelImpl.UUID_COLUMN_BITMASK |
			CustomDataModelImpl.CUSTOMLONG_COLUMN_BITMASK);

		_finderPathCountByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()});

		_finderPathFetchByUUID_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CustomDataImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			CustomDataModelImpl.UUID_COLUMN_BITMASK |
			CustomDataModelImpl.GROUPID_COLUMN_BITMASK);

		_finderPathCountByUUID_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CustomDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CustomDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			CustomDataModelImpl.UUID_COLUMN_BITMASK |
			CustomDataModelImpl.COMPANYID_COLUMN_BITMASK |
			CustomDataModelImpl.CUSTOMLONG_COLUMN_BITMASK);

		_finderPathCountByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByCustomString = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CustomDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCustomString",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByCustomString = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CustomDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCustomString",
			new String[] {String.class.getName()},
			CustomDataModelImpl.CUSTOMSTRING_COLUMN_BITMASK |
			CustomDataModelImpl.CUSTOMLONG_COLUMN_BITMASK);

		_finderPathCountByCustomString = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCustomString",
			new String[] {String.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(CustomDataImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = CustomDataPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.com.liferay.custom.data.model.CustomData"),
			true);
	}

	@Override
	@Reference(
		target = CustomDataPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = CustomDataPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private boolean _columnBitmaskEnabled;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_CUSTOMDATA =
		"SELECT customData FROM CustomData customData";

	private static final String _SQL_SELECT_CUSTOMDATA_WHERE =
		"SELECT customData FROM CustomData customData WHERE ";

	private static final String _SQL_COUNT_CUSTOMDATA =
		"SELECT COUNT(customData) FROM CustomData customData";

	private static final String _SQL_COUNT_CUSTOMDATA_WHERE =
		"SELECT COUNT(customData) FROM CustomData customData WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "customData.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No CustomData exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No CustomData exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		CustomDataPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	static {
		try {
			Class.forName(CustomDataPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}