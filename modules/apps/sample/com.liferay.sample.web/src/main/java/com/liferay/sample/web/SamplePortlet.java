package com.liferay.sample.web;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.sample.model.Foo;
import com.liferay.sample.service.FooLocalServiceUtil;

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Sample Portlet",
		"javax.portlet.security-role-ref=power-user,user",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.resource-bundle=content.Language"
	},
	service = Portlet.class
)
public class SamplePortlet extends MVCPortlet {

	@Override
	public void processAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws IOException, PortletException {

		try {
			String cmd = ParamUtil.getString(actionRequest, Constants.CMD);

			if (cmd.equals(Constants.ADD) || cmd.equals(Constants.UPDATE)) {
				updateFoo(actionRequest);
			}
			else if (cmd.equals(Constants.DELETE)) {
				deleteFoo(actionRequest);
			}

			if (Validator.isNotNull(cmd)) {
				if (SessionErrors.isEmpty(actionRequest)) {
					SessionMessages.add(actionRequest, "requestProcessed");
				}

				String redirect = ParamUtil.getString(
					actionRequest, "redirect");

				actionResponse.sendRedirect(redirect);
			}
		}
		catch (Exception e) {
			throw new PortletException(e);
		}
	}

	protected void deleteFoo(ActionRequest actionRequest) throws Exception {
		long fooId = ParamUtil.getLong(actionRequest, "fooId");

		FooLocalServiceUtil.deleteFoo(fooId);
	}

	protected void updateFoo(ActionRequest actionRequest) throws Exception {
		long fooId = ParamUtil.getLong(actionRequest, "fooId");

		String field1 = ParamUtil.getString(actionRequest, "field1");
		boolean field2 = ParamUtil.getBoolean(actionRequest, "field2");
		int field3 = ParamUtil.getInteger(actionRequest, "field3");
		String field5 = ParamUtil.getString(actionRequest, "field5");

		int dateMonth = ParamUtil.getInteger(actionRequest, "field4Month");
		int dateDay = ParamUtil.getInteger(actionRequest, "field4Day");
		int dateYear = ParamUtil.getInteger(actionRequest, "field4Year");
		int dateHour = ParamUtil.getInteger(actionRequest, "field4Hour");
		int dateMinute = ParamUtil.getInteger(actionRequest, "field4Minute");
		int dateAmPm = ParamUtil.getInteger(actionRequest, "field4AmPm");

		if (dateAmPm == Calendar.PM) {
			dateHour += 12;
		}

		Date field4 = PortalUtil.getDate(
			dateMonth, dateDay, dateYear, dateHour, dateMinute,
			PortalException.class);

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			Foo.class.getName(), actionRequest);

		if (fooId <= 0) {
			FooLocalServiceUtil.addFoo(
				field1, field2, field3, field4, field5, serviceContext);
		}
		else {
			FooLocalServiceUtil.updateFoo(
				fooId, field1, field2, field3, field4, field5, serviceContext);
		}
	}
	
}