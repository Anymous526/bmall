package com.amall.core.service;

import java.util.List;

import com.amall.core.bean.MonthBenifitDetail;
import com.amall.core.bean.MonthBenifitDetailExample;

public interface MonthBenifitDedtailService {
	
	List<MonthBenifitDetail> queryBenifitDetails(MonthBenifitDetailExample example);
	MonthBenifitDetail queryBenifitDetail(MonthBenifitDetailExample example);
}
