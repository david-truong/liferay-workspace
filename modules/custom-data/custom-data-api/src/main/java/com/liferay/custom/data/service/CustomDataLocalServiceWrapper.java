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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CustomDataLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CustomDataLocalService
 * @generated
 */
public class CustomDataLocalServiceWrapper
	implements CustomDataLocalService, ServiceWrapper<CustomDataLocalService> {

	public CustomDataLocalServiceWrapper(
		CustomDataLocalService customDataLocalService) {

		_customDataLocalService = customDataLocalService;
	}

	/**
	 * Adds the custom data to the database. Also notifies the appropriate model listeners.
	 *
	 * @param customData the custom data
	 * @return the custom data that was added
	 */
	@Override
	public com.liferay.custom.data.model.CustomData addCustomData(
		com.liferay.custom.data.model.CustomData customData) {

		return _customDataLocalService.addCustomData(customData);
	}

	/**
	 * Creates a new custom data with the primary key. Does not add the custom data to the database.
	 *
	 * @param customDataId the primary key for the new custom data
	 * @return the new custom data
	 */
	@Override
	public com.liferay.custom.data.model.CustomData createCustomData(
		long customDataId) {

		return _customDataLocalService.createCustomData(customDataId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _customDataLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the custom data from the database. Also notifies the appropriate model listeners.
	 *
	 * @param customData the custom data
	 * @return the custom data that was removed
	 */
	@Override
	public com.liferay.custom.data.model.CustomData deleteCustomData(
		com.liferay.custom.data.model.CustomData customData) {

		return _customDataLocalService.deleteCustomData(customData);
	}

	/**
	 * Deletes the custom data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param customDataId the primary key of the custom data
	 * @return the custom data that was removed
	 * @throws PortalException if a custom data with the primary key could not be found
	 */
	@Override
	public com.liferay.custom.data.model.CustomData deleteCustomData(
			long customDataId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _customDataLocalService.deleteCustomData(customDataId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _customDataLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _customDataLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _customDataLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _customDataLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _customDataLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _customDataLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _customDataLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.liferay.custom.data.model.CustomData fetchCustomData(
		long customDataId) {

		return _customDataLocalService.fetchCustomData(customDataId);
	}

	/**
	 * Returns the custom data matching the UUID and group.
	 *
	 * @param uuid the custom data's UUID
	 * @param groupId the primary key of the group
	 * @return the matching custom data, or <code>null</code> if a matching custom data could not be found
	 */
	@Override
	public com.liferay.custom.data.model.CustomData
		fetchCustomDataByUuidAndGroupId(String uuid, long groupId) {

		return _customDataLocalService.fetchCustomDataByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _customDataLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the custom data with the primary key.
	 *
	 * @param customDataId the primary key of the custom data
	 * @return the custom data
	 * @throws PortalException if a custom data with the primary key could not be found
	 */
	@Override
	public com.liferay.custom.data.model.CustomData getCustomData(
			long customDataId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _customDataLocalService.getCustomData(customDataId);
	}

	/**
	 * Returns the custom data matching the UUID and group.
	 *
	 * @param uuid the custom data's UUID
	 * @param groupId the primary key of the group
	 * @return the matching custom data
	 * @throws PortalException if a matching custom data could not be found
	 */
	@Override
	public com.liferay.custom.data.model.CustomData
			getCustomDataByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _customDataLocalService.getCustomDataByUuidAndGroupId(
			uuid, groupId);
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
	@Override
	public java.util.List<com.liferay.custom.data.model.CustomData>
		getCustomDatas(int start, int end) {

		return _customDataLocalService.getCustomDatas(start, end);
	}

	/**
	 * Returns all the custom datas matching the UUID and company.
	 *
	 * @param uuid the UUID of the custom datas
	 * @param companyId the primary key of the company
	 * @return the matching custom datas, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.liferay.custom.data.model.CustomData>
		getCustomDatasByUuidAndCompanyId(String uuid, long companyId) {

		return _customDataLocalService.getCustomDatasByUuidAndCompanyId(
			uuid, companyId);
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
	@Override
	public java.util.List<com.liferay.custom.data.model.CustomData>
		getCustomDatasByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.liferay.custom.data.model.CustomData> orderByComparator) {

		return _customDataLocalService.getCustomDatasByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of custom datas.
	 *
	 * @return the number of custom datas
	 */
	@Override
	public int getCustomDatasCount() {
		return _customDataLocalService.getCustomDatasCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _customDataLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _customDataLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _customDataLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _customDataLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the custom data in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param customData the custom data
	 * @return the custom data that was updated
	 */
	@Override
	public com.liferay.custom.data.model.CustomData updateCustomData(
		com.liferay.custom.data.model.CustomData customData) {

		return _customDataLocalService.updateCustomData(customData);
	}

	@Override
	public CustomDataLocalService getWrappedService() {
		return _customDataLocalService;
	}

	@Override
	public void setWrappedService(
		CustomDataLocalService customDataLocalService) {

		_customDataLocalService = customDataLocalService;
	}

	private CustomDataLocalService _customDataLocalService;

}