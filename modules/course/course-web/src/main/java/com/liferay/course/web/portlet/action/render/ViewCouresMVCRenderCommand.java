package com.liferay.course.web.portlet.action.render;

import com.liferay.constants.CommonConstants;
import com.liferay.course.model.Course;
import com.liferay.course.service.CourseService;
import com.liferay.course.web.constants.CoursePortletKeys;
import com.liferay.course.web.constants.CoursePortletConstants;
import com.liferay.course.web.display.context.CoursesManagementToolbarDisplayContext;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	immediate = true,
	property = {
		CommonConstants.KEY_JAVAX_PORTLET_NAME + CoursePortletKeys.COURSE,
		CommonConstants.KEY_MVC_COMMAND_NAME + StringPool.SLASH,
		CommonConstants.KEY_MVC_COMMAND_NAME + CoursePortletConstants.COURSE_COMMAND_VIEW_COURSES
	},
	service = MVCRenderCommand.class
)
public class ViewCouresMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws PortletException {

		addCourseListAttributes(renderRequest);

		addManagementToolbarAttributes(renderRequest, renderResponse);

		return CoursePortletKeys.COURSES_VIEW_URL;
	}

	private void addCourseCount(
		RenderRequest renderRequest, long groupId, String keywords) {

		long courseCount =
			_courseService.getCoursesCountByKeywords(groupId, keywords);

		renderRequest.setAttribute(
			CoursePortletConstants.PARAM_COURSE_COUNT, courseCount);
	}

	private void addCourseList(
		RenderRequest renderRequest, long groupId, String keywords) {

		int currentPage = ParamUtil.getInteger(
			renderRequest, SearchContainer.DEFAULT_CUR_PARAM,
			SearchContainer.DEFAULT_CUR);

		int delta = ParamUtil.getInteger(
			renderRequest, SearchContainer.DEFAULT_DELTA_PARAM,
			SearchContainer.DEFAULT_DELTA);

		int start = ((currentPage > 0) ? (currentPage - 1) : 0) * delta;
		int end = start + delta;

		String orderByCol = ParamUtil.getString(
			renderRequest, CommonConstants.PARAM_ORDER_BY_COL,
			CoursePortletConstants.COURSE_COLUMN_NAME);

		String orderByType = ParamUtil.getString(
			renderRequest, CommonConstants.PARAM_ORDER_BY_TYPE,
			CommonConstants.SORT_ASC);

		// Create comparator

		OrderByComparator<Course> comparator =
			OrderByComparatorFactoryUtil.create(
				CoursePortletConstants.TABLE_COURSE, orderByCol,
				!(CommonConstants.SORT_ASC).equals(orderByType));

		List<Course> courses = _courseService.getCoursesByKeywords(
			groupId, keywords, start, end, comparator);

		renderRequest.setAttribute(
			CoursePortletConstants.PARAM_COURSES, courses);
	}

	/**
	 * Adds course list related attributes to the request.
	 * 
	 * @param renderRequest
	 */
	private void addCourseListAttributes(RenderRequest renderRequest) {

		ThemeDisplay themeDisplay =
			(ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		long groupId = themeDisplay.getScopeGroupId();

		String keywords =
			ParamUtil.getString(renderRequest, CommonConstants.PARAM_KEYWORDS);

		addCourseList(renderRequest, groupId, keywords);

		addCourseCount(renderRequest, groupId, keywords);
	}

	/**
	 * Adds Clay management toolbar context object to the request.
	 * @param renderRequest
	 * @param renderResponse
	 */
	private void addManagementToolbarAttributes(
		RenderRequest renderRequest, RenderResponse renderResponse) {

		LiferayPortletRequest liferayPortletRequest =
			_portal.getLiferayPortletRequest(renderRequest);

		LiferayPortletResponse liferayPortletResponse =
			_portal.getLiferayPortletResponse(renderResponse);

		CoursesManagementToolbarDisplayContext coursesManagementToolbarDisplayContext =
			new CoursesManagementToolbarDisplayContext(
				liferayPortletRequest, liferayPortletResponse,
				_portal.getHttpServletRequest(renderRequest));

		renderRequest.setAttribute(
			CoursePortletConstants.PARAM_COURSES_MANAGEMENT_TOOL_BAR_DISPLAY_CONTEXT,
			coursesManagementToolbarDisplayContext);

	}

	@Reference
	private CourseService _courseService;;

	@Reference
	private Portal _portal;
}
