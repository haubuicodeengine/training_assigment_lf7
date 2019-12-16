package com.liferay.course.search;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.search.spi.model.result.contributor.ModelSummaryContributor;

import java.util.Locale;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true,
	property = SearchConstants.KEY_INDEXER_CLASS_NAME + SearchConstants.COURSE_CLAZZ,
	service = ModelSummaryContributor.class
)
public class CourseModelSummaryContributor implements ModelSummaryContributor {

	@Activate
	public void active(BundleContext bundleContext) {

		System.out.println("CourseModelSummaryContributorActive");
	}

	@Override
	public Summary getSummary(
		Document document, Locale locale, String snippet) {

		Summary summary = createSummary(document);

		summary.setMaxContentLength(SearchConstants.MAX_CONTENT_LENGTH);

		return summary;
	}

	private Summary createSummary(Document document) {

		String prefix = Field.SNIPPET + StringPool.UNDERLINE;

		String title = document.get(prefix + Field.TITLE, Field.TITLE);

		return new Summary(title, StringPool.BLANK);
	}
}
