package com.amall.core.dao;

import com.amall.core.bean.DreamPartnerCash;
import com.amall.core.bean.DreamPartnerCashExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DreamPartnerCashMapper {
    int countByExample(DreamPartnerCashExample example);

    int deleteByExample(DreamPartnerCashExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DreamPartnerCash record);

    int insertSelective(DreamPartnerCash record);

    List<DreamPartnerCash> selectByExample(DreamPartnerCashExample example);
    
    List<DreamPartnerCash> selectByExampleWithPage(DreamPartnerCashExample example);

    DreamPartnerCash selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DreamPartnerCash record, @Param("example") DreamPartnerCashExample example);

    int updateByExample(@Param("record") DreamPartnerCash record, @Param("example") DreamPartnerCashExample example);

    int updateByPrimaryKeySelective(DreamPartnerCash record);

    int updateByPrimaryKey(DreamPartnerCash record);
}