<%@ include file="../init.jsp"%>

<c:set var="course" value="${SEARCH_CONTAINER_RESULT_ROW.object}" />

<liferay-ui:icon-menu markupView="lexicon">

	<portlet:renderURL var="viewCourseURL">
		<portlet:param name="mvcRenderCommandName"
			value="<%= CoursePortletConstants.COURSE_COMMAND_VIEW_COURSE %>" />
		<portlet:param name="redirect" value="${currentURL}" />
		<portlet:param name="<%= CoursePortletConstants.PARAM_COURSE_ID %>" value="${course.courseId}" />
	</portlet:renderURL>

	<liferay-ui:icon message="view" url="${viewCourseURL}" />

	<portlet:renderURL var="editCourseURL">
		<portlet:param name="mvcRenderCommandName"
			value="<%= CoursePortletConstants.COURSE_COMMAND_EDIT_COURSE %>" />
		<portlet:param name="redirect" value="${currentURL}" />
		<portlet:param name="<%= CoursePortletConstants.PARAM_COURSE_ID %>" value="${course.courseId}" />
	</portlet:renderURL>

	<liferay-ui:icon message="edit" url="${editCourseURL}" />

	<portlet:actionURL var="deleteCourseURL" name="<%= CoursePortletConstants.COURSE_COMMAND_DELETE_COURSE %>">
		<portlet:param name="redirect" value="${currentURL}" />
		<portlet:param name="<%= CoursePortletConstants.PARAM_COURSE_ID %>" value="${course.courseId}" />
	</portlet:actionURL>

    <liferay-ui:icon-delete url="${deleteCourseURL}" />
</liferay-ui:icon-menu>