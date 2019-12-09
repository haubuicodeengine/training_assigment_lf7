<%@ include file="../init.jsp"%>

<div class="container-fluid-1280">

	<h1>${course.getName(locale)}</h1>

	<h3><liferay-ui:message key="course-information" /></h3>

	<div class="course-metadata">

		<dl>
			<dt><liferay-ui:message key="created" /></dt>
			<dd>${createDate}</dd>

			<dt><liferay-ui:message key="description" /></dt>
			<dd>${course.getDescription()}</dd>

			<dt><liferay-ui:message key="lecturer" /></dt>
			<dd>${course.getLecturer(locale)}</dd>

			<dt><liferay-ui:message key="duration" /></dt>
			<dd>${course.getDuration()}</dd>

			<dt><liferay-ui:message key="status" /></dt>
			<dd><liferay-ui:message key="${courseStatus}" /></dd>
		</dl>
	</div>
</div>