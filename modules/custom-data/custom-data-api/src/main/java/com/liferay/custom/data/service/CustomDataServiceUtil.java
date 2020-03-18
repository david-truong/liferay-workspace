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
 * Provides the remote service utility for CustomData. This utility wraps
 * <code>com.liferay.custom.data.service.impl.CustomDataServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see CustomDataService
 * @generated
 */
public class CustomDataServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.custom.data.service.impl.CustomDataServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static CustomDataService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CustomDataService, CustomDataService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(CustomDataService.class);

		ServiceTracker<CustomDataService, CustomDataService> serviceTracker =
			new ServiceTracker<CustomDataService, CustomDataService>(
				bundle.getBundleContext(), CustomDataService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}