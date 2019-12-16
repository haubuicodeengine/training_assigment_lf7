package com.liferay.course.search;

import com.liferay.course.model.Course;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.registrar.ModelSearchRegistrarHelper;
import com.liferay.portal.search.spi.model.result.contributor.ModelSummaryContributor;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

@Component(immediate = true)
public class CourseSearchRegistrar {

	@Activate
	public void active(BundleContext bundleContext) {

		System.out.println("CourseSearchRegistrarActive");

		_serviceRegistration = modelSearchRegistrarHelper.register(
			Course.class, bundleContext, modelSearchDefinition -> {
				modelSearchDefinition.setDefaultSelectedFieldNames(
					Field.ASSET_TAG_NAMES, Field.COMPANY_ID, Field.CONTENT,
					Field.ENTRY_CLASS_NAME, Field.ENTRY_CLASS_PK,
					Field.GROUP_ID, Field.MODIFIED_DATE, Field.SCOPE_GROUP_ID,
					Field.TITLE, Field.UID, SearchConstants.FIELD_DESCRIPTION,
					SearchConstants.FIELD_LECTURER);

				modelSearchDefinition.setModelIndexWriteContributor(
					modelIndexWriterContributor);
				modelSearchDefinition.setModelSummaryContributor(
					modelSummaryContributor);
			});
	}

	@Deactivate
	public void deactive() {

		_serviceRegistration.unregister();
	}

	@Reference
	protected ModelIndexerWriterContributor<Course> modelIndexWriterContributor;

	@Reference
	protected ModelSearchRegistrarHelper modelSearchRegistrarHelper;

	@Reference
	protected ModelSummaryContributor modelSummaryContributor;

	private ServiceRegistration<?> _serviceRegistration;
}
