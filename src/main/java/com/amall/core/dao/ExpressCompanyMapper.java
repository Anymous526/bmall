package com.amall.core.dao;

import com.amall.core.bean.ExpressCompany;
import com.amall.core.bean.ExpressCompanyExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ExpressCompanyMapper {
    int countByExample(ExpressCompanyExample example);

    int deleteByExample(ExpressCompanyExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ExpressCompany record);

    Long insertSelective(ExpressCompany record);

    List<ExpressCompany> selectByExample(ExpressCompanyExample example);
    List<ExpressCompany> selectByExampleWithPage(ExpressCompanyExample example);

    ExpressCompany selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ExpressCompany record, @Param("example") ExpressCompanyExample example);

    int updateByExample(@Param("record") ExpressCompany record, @Param("example") ExpressCompanyExample example);

    int updateByPrimaryKeySelective(ExpressCompany record);

    int updateByPrimaryKey(ExpressCompany record);
}