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

package com.liferay.samplestruts.struts.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

/**
 * @author Brian Wing Shun Chan
 */
public class UnsubscribeForm extends ValidatorForm {

	public String getEmailAddress() {
		return _emailAddress;
	}

	public String getFirstName() {
		return _firstName;
	}

	public String getLastName() {
		return _lastName;
	}

	@Override
	public void reset(ActionMapping actionMapping, HttpServletRequest req) {
		_firstName = null;
		_lastName = null;
		_emailAddress = null;
	}

	public void setEmailAddress(String emailAddress) {
		_emailAddress = emailAddress;
	}

	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	public void setLastName(String lastName) {
		_lastName = lastName;
	}

	@Override
	public String toString() {
		return _firstName + " " + _lastName + " " + _emailAddress;
	}

	private String _emailAddress;
	private String _firstName;
	private String _lastName;

}