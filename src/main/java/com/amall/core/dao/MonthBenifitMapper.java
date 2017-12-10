package com.amall.core.dao;

import com.amall.core.bean.MonthBenifit;
import com.amall.core.bean.MonthBenifitExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MonthBenifitMapper {
    int countByExample(MonthBenifitExample example);

    int deleteByExample(MonthBenifitExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MonthBenifit record);

    int insertSelective(MonthBenifit record);

    List<MonthBenifit> selectByExample(MonthBenifitExample example);

    MonthBenifit selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MonthBenifit record, @Param("example") MonthBenifitExample example);

    int updateByExample(@Param("record") MonthBenifit record, @Param("example") MonthBenifitExample example);

    int updateByPrimaryKeySelective(MonthBenifit record);

    int updateByPrimaryKey(MonthBenifit record);
}