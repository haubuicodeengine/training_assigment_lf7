package com.liferay.course.search;

import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.search.query.QueryHelper;
import com.liferay.portal.search.spi.model.query.contributor.KeywordQueryContributor;
import com.liferay.portal.search.spi.model.query.contributor.helper.KeywordQueryContributorHelper;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	immediate = true,
	property = SearchConstants.KEY_INDEXER_CLASS_NAME + SearchConstants.COURSE_CLAZZ,
	service = KeywordQueryContributor.class
)
public class CourseKeywordQueryContributor implements KeywordQueryContributor {

	@Activate
	public void active(BundleContext bundleContext) {

		System.out.println("CourseKeywordQueryContributorActive");
	}

	@Override
	public void contribute(
		String keywords, BooleanQuery booleanQuery,
		KeywordQueryContributorHelper keywordQueryContributorHelper) {

		SearchContext searchContext =
			keywordQueryContributorHelper.getSearchContext();

		queryHelper.addSearchLocalizedTerm(
			booleanQuery, searchContext, Field.TITLE, true);

		queryHelper.addSearchTerm(
			booleanQuery, searchContext, SearchConstants.FIELD_DESCRIPTION,
			true);

		queryHelper.addSearchLocalizedTerm(
			booleanQuery, searchContext, SearchConstants.FIELD_LECTURER, true);
	}

	@Reference
	protected QueryHelper queryHelper;
}
