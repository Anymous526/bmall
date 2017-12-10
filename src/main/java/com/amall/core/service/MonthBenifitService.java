package com.amall.core.service;

import com.amall.core.bean.MonthBenifit;
import com.amall.core.bean.MonthBenifitDetailExample;
import com.amall.core.bean.MonthBenifitExample;

import java.util.List;

public interface MonthBenifitService {
	
	List<MonthBenifit> queryBenifits(MonthBenifitExample example);
	 MonthBenifit queryBenifit(MonthBenifitExample example2);

}
