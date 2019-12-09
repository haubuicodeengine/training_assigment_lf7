package com.liferay.course;

import com.liferay.portal.kernel.events.Action;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ces
 */
public class MyWarHook1LoginPostAction extends Action {

	@Override
	public void run(HttpServletRequest request, HttpServletResponse response) {

		long userId = PortalUtil.getUserId(request);

		User user = UserLocalServiceUtil.fetchUser(userId);

		redirectURL(user, response);
	}

	private void redirectURL(User user, HttpServletResponse response) {

		try {
			if (containRole(user.getRoles(), ROLE_STAFF)) {
				response.sendRedirect(ROLE_STAFF_REDIRECT_URL);
				return;
			}
		}
		catch (Exception e) {

			e.printStackTrace();
		}
	}

	private boolean containRole(List<Role> roles, String roleCheck) {

		for (Role role : roles) {
			if (role.getName().toLowerCase().equals(roleCheck.toLowerCase())) {
				return true;
			}
		}

		return false;
	}

	private static final String ROLE_STAFF = "staff";

	private static final String ROLE_STAFF_REDIRECT_URL = "/web/courses";

}