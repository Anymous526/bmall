package com.amall.core.dao;

import com.amall.core.bean.PromoteVipItem;
import com.amall.core.bean.PromoteVipItemExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PromoteVipItemMapper {
    int countByExample(PromoteVipItemExample example);

    int deleteByExample(PromoteVipItemExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PromoteVipItem record);

    int insertSelective(PromoteVipItem record);

    List<PromoteVipItem> selectByExample(PromoteVipItemExample example);
    
    List<PromoteVipItem> selectByExampleAndPage(PromoteVipItemExample example);

    PromoteVipItem selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PromoteVipItem record, @Param("example") PromoteVipItemExample example);

    int updateByExample(@Param("record") PromoteVipItem record, @Param("example") PromoteVipItemExample example);

    int updateByPrimaryKeySelective(PromoteVipItem record);

    int updateByPrimaryKey(PromoteVipItem record);
}