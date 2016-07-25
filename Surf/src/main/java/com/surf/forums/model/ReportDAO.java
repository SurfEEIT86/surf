package com.surf.forums.model;

import java.util.List;

public interface ReportDAO {

	ReportVO select(ReportVO vo);

	List<ReportVO> findByArticleno(Integer articleno);

	ReportVO insert(ReportVO vo);
	
	public boolean deleteReportsByArticle(Integer articleNo);

}