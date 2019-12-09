package com.liferay.course.upgrade.v_1_0_0;

import com.liferay.course.enums.CourseEnums;
import com.liferay.course.service.CourseService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.GroupConstants;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class InitSampleData extends UpgradeProcess {

	public InitSampleData(CourseService courseService) {

		this._courseService = courseService;
	}

	@Override
	protected void doUpgrade()
		throws Exception {

		try {

			_log.info("Start initiation course sample data.");

			if (_courseService.getCoursesCount() > 0) {

				return;
			}

			long guestGroupId = GroupLocalServiceUtil.getGroup(
				COMPANYID, GROUP_GUEST_NAME).getGroupId();

			long guestUserID = UserLocalServiceUtil.getUserIdByEmailAddress(
				COMPANYID, DEFAULT_USER_EMAIL);

			ServiceContext serviceContext = new ServiceContext();

			serviceContext.setUserId(guestUserID);

			for (Object[] obj : listSampleData) {

				_courseService.addCourse(
					guestGroupId, buildMapLocale(obj[0].toString()),
					obj[1].toString(), buildMapLocale(obj[2].toString()),
					(int) obj[3], (int) obj[4], serviceContext);
			}
		}
		catch (PortalException e) {

			_log.error(e.getMessage());
		}
		finally {

			_log.info("End initiation course sample data!!!");
		}
	}

	private Map<Locale, String> buildMapLocale(String value) {

		Locale defaultLocale = LocaleUtil.getSiteDefault();

		Map<Locale, String> mapValue = new HashMap<Locale, String>();

		mapValue.put(defaultLocale, value);

		return mapValue;
	}

	private static final List<Object[]> listSampleData;

	private CourseService _courseService;

	private static final int DEFAULT_DURATION = 5;

	private static final int DEFAULT_NUM = 5;

	private static final long COMPANYID = PortalUtil.getDefaultCompanyId();

	private static final String DEFAULT_USER_EMAIL = "default@liferay.com";

	private static final String GROUP_GUEST_NAME = GroupConstants.GUEST;

	static {

		listSampleData = new ArrayList<>();

		for (int i = 0; i < DEFAULT_NUM; i++) {

			String txt = " #" + i;

			listSampleData.add(
				new Object[] {
					"Name" + txt, "Description" + txt, "Lecturer" + txt,
					DEFAULT_DURATION, CourseEnums.Available.getValue()
				});
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(InitSampleData.class);
}
