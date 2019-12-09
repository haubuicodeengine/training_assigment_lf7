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
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	immediate = true,
	property = {
		CommonConstants.KEY_JAVAX_PORTLET_NAME + CoursePortletKeys.COURSE,
		CommonConstants.KEY_MVC_COMMAND_NAME + CoursePortletConstants.COURSE_COMMAND_EDIT_COURSE
	},
	service = MVCRenderCommand.class
)
public class EditCourseMVCRenderCommand implements MVCRenderCommand{

	@Override
	public String render(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws PortletException {

		Course course = null;

		long courseId = ParamUtil.getLong(
			renderRequest, CoursePortletConstants.PARAM_COURSE_ID);

		if (Validator.isNotNull(courseId)) {
			try {

				course = _courseService.getCourse(courseId);
			}
			catch (PortalException e) {
				e.printStackTrace();
			}
		}

		CourseUtil.setBackIconVisible(renderRequest);
		addMoreAttribute(renderRequest);

		renderRequest.setAttribute("course", course);
		renderRequest.setAttribute("courseClass", Course.class);

		return CoursePortletKeys.COURSE_ADD_EDIT_URL;
	}

	private void addMoreAttribute(RenderRequest renderRequest) {

		renderRequest.setAttribute("courseEnums", CourseEnums.values());
	}

    @Reference
    private CourseService _courseService;

}
