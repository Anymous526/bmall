package com.amall.core.dao;

import com.amall.core.bean.PromoteVipHistory;
import com.amall.core.bean.PromoteVipHistoryExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PromoteVipHistoryMapper {
    int countByExample(PromoteVipHistoryExample example);

    int deleteByExample(PromoteVipHistoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PromoteVipHistory record);

    int insertSelective(PromoteVipHistory record);

    List<PromoteVipHistory> selectByExample(PromoteVipHistoryExample example);
    
    List<PromoteVipHistory> selectByExampleAndPage(PromoteVipHistoryExample example);

    PromoteVipHistory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PromoteVipHistory record, @Param("example") PromoteVipHistoryExample example);

    int updateByExample(@Param("record") PromoteVipHistory record, @Param("example") PromoteVipHistoryExample example);

    int updateByPrimaryKeySelective(PromoteVipHistory record);

    int updateByPrimaryKey(PromoteVipHistory record);
}