package com.amall.core.dao;

import com.amall.core.bean.GoodsReturnLog;
import com.amall.core.bean.GoodsReturnLogExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface GoodsReturnLogMapper {
    int countByExample(GoodsReturnLogExample example);

    int deleteByExample(GoodsReturnLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GoodsReturnLog record);

    Long insertSelective(GoodsReturnLog record);

    List<GoodsReturnLog> selectByExample(GoodsReturnLogExample example);
    List<GoodsReturnLog> selectByExampleWithPage(GoodsReturnLogExample example);

    GoodsReturnLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GoodsReturnLog record, @Param("example") GoodsReturnLogExample example);

    int updateByExample(@Param("record") GoodsReturnLog record, @Param("example") GoodsReturnLogExample example);

    int updateByPrimaryKeySelective(GoodsReturnLog record);

    int updateByPrimaryKey(GoodsReturnLog record);
}