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
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

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
		CommonConstants.KEY_MVC_COMMAND_NAME + CoursePortletConstants.COURSE_COMMAND_ADD_COURSE
    },
    service = MVCActionCommand.class
)
public class AddCourseMVCActionCommand extends BaseMVCActionCommand{

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		// TODO Auto-generated method stub
		ThemeDisplay themeDisplay =
			(ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		long groupId = themeDisplay.getScopeGroupId();

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			Course.class.getName(), actionRequest);

		Map<Locale, String> nameMap =
			LocalizationUtil.getLocalizationMap(actionRequest, "name");
		String description = ParamUtil.getString(actionRequest, "description");
		Map<Locale, String> lecturerMap =
			LocalizationUtil.getLocalizationMap(actionRequest, "lecturer");
		int duration = ParamUtil.getInteger(actionRequest, "duration");
		int status = ParamUtil.getInteger(actionRequest, "status");

		try {

			_courseService.addCourse(
				groupId, nameMap, description, lecturerMap, duration, status,
				serviceContext);

			SessionMessages.add(
				actionRequest, CoursePortletConstants.KEY_ADDED_COURSE);

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
