package com.liferay.course.web.portlet.action.render;

import com.liferay.constants.CommonConstants;
import com.liferay.course.enums.CourseEnums;
import com.liferay.course.model.Course;
import com.liferay.course.service.CourseService;
import com.liferay.course.utils.CourseUtil;
import com.liferay.course.web.constants.CoursePortletConstants;
import com.liferay.course.web.constants.CoursePortletKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;

import java.text.DateFormat;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	immediate = true,
	property = {
		CommonConstants.KEY_JAVAX_PORTLET_NAME + CoursePortletKeys.COURSE,
		CommonConstants.KEY_MVC_COMMAND_NAME + CoursePortletConstants.COURSE_COMMAND_VIEW_COURSE
	},
	service = MVCRenderCommand.class
)
public class ViewSingleCourseMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws PortletException {

		DateFormat dateFormat = DateFormatFactoryUtil.getSimpleDateFormat(
			CommonConstants.DATE_PATTERN, renderRequest.getLocale());

		long courseId = ParamUtil.getLong(
			renderRequest, CoursePortletConstants.PARAM_COURSE_ID);

		try {

			Course course = _courseService.getCourse(courseId);

			renderRequest.setAttribute("course", course);
			renderRequest.setAttribute("courseStatus", CourseEnums.getCourseEnumFromValue(course.getStatus()).getKey());
			renderRequest.setAttribute(
				"createDate", dateFormat.format(course.getCreateDate()));

			CourseUtil.setBackIconVisible(renderRequest);
		}
		catch (PortalException pe) {

			pe.printStackTrace();
		}

		return CoursePortletKeys.COURSE_VIEW_URL;
	}

	@Reference
	private CourseService _courseService;
}
