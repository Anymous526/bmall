package com.amall.core.service;


import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.amall.core.bean.Revenue;
import com.amall.core.bean.RevenueExample;
import com.amall.core.dao.RevenueMapper;
import com.amall.core.web.page.Pagination;
@Service
@Transactional
public class RevenServiceImpl implements IRevenservice{

	@Resource
	private RevenueMapper dao;

	public int add(Revenue revenue) {
		
		return dao.insert(revenue);
	}

	@Transactional(readOnly=true)
	public Pagination list(RevenueExample example) {
		// TODO Auto-generated method stub
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),dao.countByExample(example));
		p.setList(dao.selectByExampleWithPage(example));
		System.err.println(dao.selectByExampleWithPage(example).size());
		return p;
	}

}
