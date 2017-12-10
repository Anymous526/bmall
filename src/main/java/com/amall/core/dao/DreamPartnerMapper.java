package com.amall.core.dao;

import com.amall.core.bean.DreamPartner;
import com.amall.core.bean.DreamPartnerExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DreamPartnerMapper {
    int countByExample(DreamPartnerExample example);

    int deleteByExample(DreamPartnerExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DreamPartner record);

    int insertSelective(DreamPartner record);

    List<DreamPartner> selectByExample(DreamPartnerExample example);
    
    List<DreamPartner> selectByExampleWithPage(DreamPartnerExample example);

    DreamPartner selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DreamPartner record, @Param("example") DreamPartnerExample example);

    int updateByExample(@Param("record") DreamPartner record, @Param("example") DreamPartnerExample example);

    int updateByPrimaryKeySelective(DreamPartner record);

    int updateByPrimaryKey(DreamPartner record);
}