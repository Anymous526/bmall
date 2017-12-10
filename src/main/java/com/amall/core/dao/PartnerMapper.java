package com.amall.core.dao;

import com.amall.core.bean.Partner;
import com.amall.core.bean.PartnerExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface PartnerMapper {
    int countByExample(PartnerExample example);

    int deleteByExample(PartnerExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Partner record);

    Long insertSelective(Partner record);

    List<Partner> selectByExample(PartnerExample example);
    List<Partner> selectByExampleWithPage(PartnerExample example);

    Partner selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Partner record, @Param("example") PartnerExample example);

    int updateByExample(@Param("record") Partner record, @Param("example") PartnerExample example);

    int updateByPrimaryKeySelective(Partner record);

    int updateByPrimaryKey(Partner record);
}