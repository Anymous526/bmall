package com.amall.core.dao;

import com.amall.core.bean.IntegralLog;
import com.amall.core.bean.IntegralLogExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface IntegralLogMapper {
    int countByExample(IntegralLogExample example);

    int deleteByExample(IntegralLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(IntegralLog record);

    Long insertSelective(IntegralLog record);

    List<IntegralLog> selectByExampleWithBLOBs(IntegralLogExample example);
    List<IntegralLog> selectByExampleWithBLOBsAndPage(IntegralLogExample example);

    List<IntegralLog> selectByExample(IntegralLogExample example);
    List<IntegralLog> selectByExampleWithPage(IntegralLogExample example);

    IntegralLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") IntegralLog record, @Param("example") IntegralLogExample example);

    int updateByExampleWithBLOBs(@Param("record") IntegralLog record, @Param("example") IntegralLogExample example);

    int updateByExample(@Param("record") IntegralLog record, @Param("example") IntegralLogExample example);

    int updateByPrimaryKeySelective(IntegralLog record);

    int updateByPrimaryKeyWithBLOBs(IntegralLog record);

    int updateByPrimaryKey(IntegralLog record);
}