package com.liferay.course.upgrade;

import com.liferay.course.service.CourseService;
import com.liferay.course.upgrade.v_1_0_0.InitSampleData;
import com.liferay.portal.upgrade.registry.UpgradeStepRegistrator;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	immediate = true,
	service = UpgradeStepRegistrator.class
)
public class MyCustomModuleUpgrade implements UpgradeStepRegistrator{

	@Override
	public void register(Registry registry) {

		registry.register(
			FROM_SCHEMA_VERSION, TO_SCHEMA_VERSION,
			new InitSampleData(_courseService));

	}

	@Reference
	private CourseService _courseService;

	private static final String FROM_SCHEMA_VERSION = "1.1.0";

	private static final String TO_SCHEMA_VERSION = "1.2.0";
}
