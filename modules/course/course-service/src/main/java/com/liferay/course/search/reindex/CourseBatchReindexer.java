package com.liferay.course.search.reindex;


public interface CourseBatchReindexer {

	public void reindex(long courseId, long companyId);
}
