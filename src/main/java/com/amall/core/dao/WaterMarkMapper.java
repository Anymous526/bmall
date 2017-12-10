package com.amall.core.dao;

import com.amall.core.bean.WaterMark;
import com.amall.core.bean.WaterMarkExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface WaterMarkMapper {
    int countByExample(WaterMarkExample example);

    int deleteByExample(WaterMarkExample example);

    int deleteByPrimaryKey(Long id);

    int insert(WaterMark record);

    Long insertSelective(WaterMark record);

    List<WaterMark> selectByExample(WaterMarkExample example);
    List<WaterMark> selectByExampleWithPage(WaterMarkExample example);

    WaterMark selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WaterMark record, @Param("example") WaterMarkExample example);

    int updateByExample(@Param("record") WaterMark record, @Param("example") WaterMarkExample example);

    int updateByPrimaryKeySelective(WaterMark record);

    int updateByPrimaryKey(WaterMark record);
}