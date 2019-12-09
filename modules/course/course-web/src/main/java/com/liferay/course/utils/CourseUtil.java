package com.liferay.course.utils;

import com.liferay.constants.CommonConstants;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.RenderRequest;

public class CourseUtil {

	public static void setBackIconVisible(RenderRequest renderRequest) {

		ThemeDisplay themeDisplay =
			(ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		// Set back icon visible.

		PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();
		portletDisplay.setShowBackIcon(true);

		String redirect = renderRequest.getParameter(CommonConstants.REDIRECT);
		portletDisplay.setURLBack(redirect);
	}
}
