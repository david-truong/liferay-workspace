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

package com.liferay.custom.data.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for CustomData. This utility wraps
 * <code>com.liferay.custom.data.service.impl.CustomDataLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see CustomDataLocalService
 * @generated
 */
public class CustomDataLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.custom.data.service.impl.CustomDataLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the custom data to the database. Also notifies the appropriate model listeners.
	 *
	 * @param customData the custom data
	 * @return the custom data that was added
	 */
	public static com.liferay.custom.data.model.CustomData addCustomData(
		com.liferay.custom.data.model.CustomData customData) {

		return getService().addCustomData(customData);
	}

	/**
	 * Creates a new custom data with the primary key. Does not add the custom data to the database.
	 *
	 * @param customDataId the primary key for the new custom data
	 * @return the new custom data
	 */
	public static com.liferay.custom.data.model.CustomData createCustomData(
		long customDataId) {

		return getService().createCustomData(customDataId);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			createPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the custom data from the database. Also notifies the appropriate model listeners.
	 *
	 * @param customData the custom data
	 * @return the custom data that was removed
	 */
	public static com.liferay.custom.data.model.CustomData deleteCustomData(
		com.liferay.custom.data.model.CustomData customData) {

		return getService().deleteCustomData(customData);
	}

	/**
	 * Deletes the custom data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param customDataId the primary key of the custom data
	 * @return the custom data that was removed
	 * @throws PortalException if a custom data with the primary key could not be found
	 */
	public static com.liferay.custom.data.model.CustomData deleteCustomData(
			long customDataId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteCustomData(customDataId);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.custom.data.model.impl.CustomDataModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.custom.data.model.impl.CustomDataModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.liferay.custom.data.model.CustomData fetchCustomData(
		long customDataId) {

		return getService().fetchCustomData(customDataId);
	}

	/**
	 * Returns the custom data matching the UUID and group.
	 *
	 * @param uuid the custom data's UUID
	 * @param groupId the primary key of the group
	 * @return the matching custom data, or <code>null</code> if a matching custom data could not be found
	 */
	public static com.liferay.custom.data.model.CustomData
		fetchCustomDataByUuidAndGroupId(String uuid, long groupId) {

		return getService().fetchCustomDataByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the custom data with the primary key.
	 *
	 * @param customDataId the primary key of the custom data
	 * @return the custom data
	 * @throws PortalException if a custom data with the primary key could not be found
	 */
	public static com.liferay.custom.data.model.CustomData getCustomData(
			long customDataId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getCustomData(customDataId);
	}

	/**
	 * Returns the custom data matching the UUID and group.
	 *
	 * @param uuid the custom data's UUID
	 * @param groupId the primary key of the group
	 * @return the matching custom data
	 * @throws PortalException if a matching custom data could not be found
	 */
	public static com.liferay.custom.data.model.CustomData
			getCustomDataByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getCustomDataByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the custom datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.custom.data.model.impl.CustomDataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of custom datas
	 * @param end the upper bound of the range of custom datas (not inclusive)
	 * @return the range of custom datas
	 */
	public static java.util.List<com.liferay.custom.data.model.CustomData>
		getCustomDatas(int start, int end) {

		return getService().getCustomDatas(start, end);
	}

	/**
	 * Returns all the custom datas matching the UUID and company.
	 *
	 * @param uuid the UUID of the custom datas
	 * @param companyId the primary key of the company
	 * @return the matching custom datas, or an empty list if no matches were found
	 */
	public static java.util.List<com.liferay.custom.data.model.CustomData>
		getCustomDatasByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getCustomDatasByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of custom datas matching the UUID and company.
	 *
	 * @param uuid the UUID of the custom datas
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of custom datas
	 * @param end the upper bound of the range of custom datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching custom datas, or an empty list if no matches were found
	 */
	public static java.util.List<com.liferay.custom.data.model.CustomData>
		getCustomDatasByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.liferay.custom.data.model.CustomData> orderByComparator) {

		return getService().getCustomDatasByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of custom datas.
	 *
	 * @return the number of custom datas
	 */
	public static int getCustomDatasCount() {
		return getService().getCustomDatasCount();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the custom data in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param customData the custom data
	 * @return the custom data that was updated
	 */
	public static com.liferay.custom.data.model.CustomData updateCustomData(
		com.liferay.custom.data.model.CustomData customData) {

		return getService().updateCustomData(customData);
	}

	public static CustomDataLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<CustomDataLocalService, CustomDataLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(CustomDataLocalService.class);

		ServiceTracker<CustomDataLocalService, CustomDataLocalService>
			serviceTracker =
				new ServiceTracker
					<CustomDataLocalService, CustomDataLocalService>(
						bundle.getBundleContext(), CustomDataLocalService.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}