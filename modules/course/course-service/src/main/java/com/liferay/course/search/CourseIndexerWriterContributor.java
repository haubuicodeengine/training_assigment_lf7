package com.liferay.course.search;

import com.liferay.course.model.Course;
import com.liferay.course.search.reindex.CourseBatchReindexer;
import com.liferay.course.service.CourseLocalService;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.batch.DynamicQueryBatchIndexingActionableFactory;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.index.contributor.helper.ModelIndexerWriterDocumentHelper;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	immediate = true,
	property = SearchConstants.KEY_INDEXER_CLASS_NAME + SearchConstants.COURSE_CLAZZ,
	service = ModelIndexerWriterContributor.class
)
public class CourseIndexerWriterContributor
	implements ModelIndexerWriterContributor<Course> {

	@Activate
	public void active(BundleContext bundleContext) {

		System.out.println("CourseIndexerWriterContributorActive");
	}

	@Override
	public void customize(
		BatchIndexingActionable batchIndexingActionable,
		ModelIndexerWriterDocumentHelper modelIndexerWriterDocumentHelper) {

		batchIndexingActionable.setPerformActionMethod((Course course) -> {

			Document document =
				modelIndexerWriterDocumentHelper.getDocument(course);

			batchIndexingActionable.addDocuments(document);
		});
	}

	@Override
	public BatchIndexingActionable getBatchIndexingActionable() {

		return dynamicQueryBatchIndexingActionableFactory.getBatchIndexingActionable(
			courseLocalService.getIndexableActionableDynamicQuery());
	}

	@Override
	public long getCompanyId(Course course) {

		return course.getCompanyId();
	}

	@Override
	public void modelIndexed(Course course) {

		courseBatchReindexer.reindex(
			course.getCourseId(), course.getCompanyId());
	}

	@Reference
	protected DynamicQueryBatchIndexingActionableFactory dynamicQueryBatchIndexingActionableFactory;

	@Reference
	protected CourseBatchReindexer courseBatchReindexer;

	@Reference
	protected CourseLocalService courseLocalService;

}
