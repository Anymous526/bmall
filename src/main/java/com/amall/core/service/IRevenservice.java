package com.amall.core.service;

import com.amall.core.bean.Revenue;
import com.amall.core.bean.RevenueExample;
import com.amall.core.web.page.Pagination;

public abstract interface IRevenservice
{

	int add (Revenue revenue);

	Pagination list (RevenueExample example);
}
