package com.amall.core.dao;

import com.amall.core.bean.WeekBenifit;
import com.amall.core.bean.WeekBenifitExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WeekBenifitMapper {
    int countByExample(WeekBenifitExample example);

    int deleteByExample(WeekBenifitExample example);

    int deleteByPrimaryKey(Long id);

    int insert(WeekBenifit record);

    int insertSelective(WeekBenifit record);

    List<WeekBenifit> selectByExample(WeekBenifitExample example);

    WeekBenifit selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WeekBenifit record, @Param("example") WeekBenifitExample example);

    int updateByExample(@Param("record") WeekBenifit record, @Param("example") WeekBenifitExample example);

    int updateByPrimaryKeySelective(WeekBenifit record);

    int updateByPrimaryKey(WeekBenifit record);
}