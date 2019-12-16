package com.liferay.course.search.reindex;

import com.liferay.course.model.Course;
import com.liferay.course.search.SearchConstants;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.Property;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.indexer.IndexerDocumentBuilder;
import com.liferay.portal.search.indexer.IndexerWriter;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	immediate = true,
	service = CourseBatchReindexer.class
)
public class CourseBatchReindexerImpl implements CourseBatchReindexer {

	@Activate
	public void active(BundleContext bundleContext) {

		System.out.println("CourseBatchReindexerImplActive");
	}

	@Override
	public void reindex(long courseId, long companyId) {

		BatchIndexingActionable batchIndexingActionable =
			indexerWriter.getBatchIndexingActionable();

		batchIndexingActionable.setAddCriteriaMethod(
			(DynamicQuery dynamicQuery) -> {

				Property courseIdProperty =
					PropertyFactoryUtil.forName("courseId");

				dynamicQuery.add(courseIdProperty.eq(courseId));
			});

		batchIndexingActionable.setCompanyId(companyId);

		batchIndexingActionable.setPerformActionMethod((Course course) -> {
			Document document = indexerDocumentBuilder.getDocument(course);

			batchIndexingActionable.addDocuments(document);
		});

		batchIndexingActionable.performActions();
	}

	@Reference(target = "(" + SearchConstants.KEY_INDEXER_CLASS_NAME +
		SearchConstants.COURSE_CLAZZ + ")")
	protected IndexerDocumentBuilder indexerDocumentBuilder;

	@Reference(target = "(" + SearchConstants.KEY_INDEXER_CLASS_NAME +
		SearchConstants.COURSE_CLAZZ + ")")
	protected IndexerWriter<Course> indexerWriter;
}
