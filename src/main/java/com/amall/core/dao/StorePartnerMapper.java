package com.amall.core.dao;

import com.amall.core.bean.StorePartner;
import com.amall.core.bean.StorePartnerExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface StorePartnerMapper {
    int countByExample(StorePartnerExample example);

    int deleteByExample(StorePartnerExample example);

    int deleteByPrimaryKey(Long id);

    int insert(StorePartner record);

    Long insertSelective(StorePartner record);

    List<StorePartner> selectByExample(StorePartnerExample example);
    List<StorePartner> selectByExampleWithPage(StorePartnerExample example);

    StorePartner selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") StorePartner record, @Param("example") StorePartnerExample example);

    int updateByExample(@Param("record") StorePartner record, @Param("example") StorePartnerExample example);

    int updateByPrimaryKeySelective(StorePartner record);

    int updateByPrimaryKey(StorePartner record);
}