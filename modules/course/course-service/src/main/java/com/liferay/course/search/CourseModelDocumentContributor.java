package com.liferay.course.search;

import com.liferay.course.model.Course;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true,
	property = SearchConstants.KEY_INDEXER_CLASS_NAME +	SearchConstants.COURSE_CLAZZ,
	service = ModelDocumentContributor.class
)
public class CourseModelDocumentContributor
	implements ModelDocumentContributor<Course> {

	@Activate
	public void active(BundleContext bundleContext) {

		System.out.println("CourseModelDocumentContributorActive");
	}

	@Override
	public void contribute(Document document, Course course) {

		document.addDate(Field.MODIFIED_DATE, course.getModifiedDate());

		document.addLocalizedText(Field.TITLE, course.getNameMap());

		document.addText(
			SearchConstants.FIELD_DESCRIPTION, course.getDescription());

		document.addLocalizedText(
			SearchConstants.FIELD_LECTURER, course.getLecturerMap());
	}
}
