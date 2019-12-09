package com.liferay.course.web.portlet.action.action;

import com.liferay.constants.CommonConstants;
import com.liferay.course.exception.CourseValidationException;
import com.liferay.course.model.Course;
import com.liferay.course.service.CourseService;
import com.liferay.course.web.constants.CoursePortletConstants;
import com.liferay.course.web.constants.CoursePortletKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
    immediate = true,
    property = {
		CommonConstants.KEY_JAVAX_PORTLET_NAME + CoursePortletKeys.COURSE,
		CommonConstants.KEY_MVC_COMMAND_NAME + CoursePortletConstants.COURSE_COMMAND_EDIT_COURSE
    },
    service = MVCActionCommand.class
)
public class EditCourseMVCActionCommand extends BaseMVCActionCommand{

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			Course.class.getName(), actionRequest);

		long courseId = ParamUtil.getLong(
			actionRequest, CoursePortletConstants.PARAM_COURSE_ID);

		Map<Locale, String> nameMap =
			LocalizationUtil.getLocalizationMap(actionRequest, "name");
		String description = ParamUtil.getString(actionRequest, "description");
		Map<Locale, String> lecturerMap =
			LocalizationUtil.getLocalizationMap(actionRequest, "lecturer");
		int duration = ParamUtil.getInteger(actionRequest, "duration");
		int status = ParamUtil.getInteger(actionRequest, "status");

		try {
			_courseService.updateCourse(
				courseId, nameMap, description, lecturerMap, duration,
				status, serviceContext);

			SessionMessages.add(
				actionRequest, CoursePortletConstants.KEY_UPDATED_COURSE);

			sendRedirect(actionRequest, actionResponse);
		}
		catch (CourseValidationException cve) {

			cve.printStackTrace();

			cve.getErrors().forEach(
				key -> SessionErrors.add(actionRequest, key));

			actionResponse.setRenderParameter(
				CommonConstants.PARAM_MVC_RENDER_COMMAND_NAME,
				CoursePortletConstants.COURSE_COMMAND_EDIT_COURSE);
		}
		catch (PortalException e) {

			e.printStackTrace();

			actionResponse.setRenderParameter(
				CommonConstants.PARAM_MVC_RENDER_COMMAND_NAME,
				CoursePortletConstants.COURSE_COMMAND_EDIT_COURSE);
		}
	}

	@Reference
	private CourseService _courseService;
}
