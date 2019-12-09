package com.liferay.course.web.portlet.action.action;

import com.liferay.constants.CommonConstants;
import com.liferay.course.exception.CourseValidationException;
import com.liferay.course.service.CourseService;
import com.liferay.course.web.constants.CoursePortletConstants;
import com.liferay.course.web.constants.CoursePortletKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
    immediate = true,
    property = {
		CommonConstants.KEY_JAVAX_PORTLET_NAME + CoursePortletKeys.COURSE,
		CommonConstants.KEY_MVC_COMMAND_NAME + CoursePortletConstants.COURSE_COMMAND_DELETE_COURSE
    },
    service = MVCActionCommand.class
)
public class DeleteCourseMVCActionCommand extends BaseMVCActionCommand{

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		long courseId = ParamUtil.getLong(
			actionRequest, CoursePortletConstants.PARAM_COURSE_ID);

		try {

			_courseService.deleteCourse(courseId);

			SessionMessages.add(
				actionRequest, CoursePortletConstants.KEY_DELETED_COURSE);

			sendRedirect(actionRequest, actionResponse);
		}
		catch (CourseValidationException cve) {

			cve.printStackTrace();

			cve.getErrors().forEach(
				key -> SessionErrors.add(actionRequest, key));
		}
		catch (PortalException e) {

			e.printStackTrace();
		}

	}

	@Reference
	private CourseService _courseService;
}
