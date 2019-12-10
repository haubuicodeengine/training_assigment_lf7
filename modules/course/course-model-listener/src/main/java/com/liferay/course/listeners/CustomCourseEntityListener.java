package com.liferay.course.listeners;

import com.liferay.course.model.Course;
import com.liferay.course.service.CourseService;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	immediate = true,
	service = ModelListener.class
)
public class CustomCourseEntityListener extends BaseModelListener<Course> {

	@Override
	public void onBeforeCreate(Course model)
		throws ModelListenerException {

		if (!checkOverMaximumNumberOfCourse(model)) {

			throw new ModelListenerException(ERROR_MESSAGE_MAXMIMUM_NUMBER);
		}

		super.onBeforeCreate(model);
	}

	private boolean checkOverMaximumNumberOfCourse(Course course) {

		long userId = course.getUserId();

		long groupId = course.getGroupId();

		if (_courseService.getCoursesCountByGroupIdAndUserId(
			groupId, userId) >= MAXIMUM_NUMBER_OF_COURSES) {

			return false;
		}

		return true;
	}

	@Reference
	CourseService _courseService;

	private static final long MAXIMUM_NUMBER_OF_COURSES = 3;

	private static final String ERROR_MESSAGE_MAXMIMUM_NUMBER =
		"you-are-only-allowed-to-create-up-to-" + MAXIMUM_NUMBER_OF_COURSES +
			"-courses";
}
