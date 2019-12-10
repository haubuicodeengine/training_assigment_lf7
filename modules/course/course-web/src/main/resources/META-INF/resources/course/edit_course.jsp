<%@ include file="../init.jsp"%>

<liferay-ui:error key="serviceErrorDetails">
	<liferay-ui:message key="error.course-service-error" arguments='<%= SessionErrors.get(liferayPortletRequest, "serviceErrorDetails") %>' />
</liferay-ui:error>
<liferay-ui:error key="duration-value-must-be-between-1-and-40" message="duration-value-must-be-between-1-and-40" />
<liferay-ui:error key="please-enter-no-more-than-2000-characters-in-duration-field" message="please-enter-no-more-than-2000-characters-in-duration-field" />
<liferay-ui:error key="courseLecturerEmpty" message="lecturer-is-not-empty" />
<liferay-ui:error key="courseNameEmpty" message="name-is-not-empty" />
<liferay-ui:error key="you-are-only-allowed-to-create-up-to-3-courses" message="you-are-only-allowed-to-create-up-to-3-courses" />

<c:choose>
     <c:when test="${not empty course}">
         <portlet:actionURL var="courseActionURL" name="<%= CoursePortletConstants.COURSE_COMMAND_EDIT_COURSE %>">
             <portlet:param name="redirect" value="${param.redirect}" />
         </portlet:actionURL>

         <c:set var="editTitle" value="edit-course"/>
     </c:when>
     <c:otherwise>
         <portlet:actionURL var="courseActionURL" name="<%= CoursePortletConstants.COURSE_COMMAND_ADD_COURSE %>">
             <portlet:param name="redirect" value="${param.redirect}" />
         </portlet:actionURL>

         <c:set var="editTitle" value="add-course"/>
     </c:otherwise>
 </c:choose>

<div class="container-fluid-1280 edit-course">

	<h1><liferay-ui:message key="${editTitle}" /></h1>

	<aui:model-context bean="${course}" model="${courseClass}" />

	<aui:form action="${courseActionURL}" name="fm">

		<aui:input name="courseId" field="courseId" type="hidden" />

		<aui:fieldset-group markupView="lexicon">
			<aui:fieldset>

				<aui:input name="name">
					<aui:validator name="required" />
				</aui:input>

				<aui:input name="description" type="textarea" />

				<aui:input name="lecturer">
					<aui:validator name="required" />
				</aui:input>

				<aui:input name="duration" type="number">
					<aui:validator name="required" />
				</aui:input>

				<aui:select name="status">
					<c:forEach items="${courseEnums}" var="courseStatus">
						<aui:option value="${courseStatus.getValue()}"><liferay-ui:message key="${courseStatus.getKey()}"/></aui:option>
					</c:forEach>
				</aui:select>
			</aui:fieldset>
		</aui:fieldset-group>

		<aui:row>
			<aui:button-row>
	             <aui:button cssClass="btn btn-primary" type="submit" />
	             <aui:button cssClass="btn btn-secondary" onClick="${param.redirect}" type="cancel" />
	         </aui:button-row>
		</aui:row>
	</aui:form>
</div>