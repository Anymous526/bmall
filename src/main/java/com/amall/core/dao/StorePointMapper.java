package com.amall.core.dao;

import com.amall.core.bean.StorePoint;
import com.amall.core.bean.StorePointExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface StorePointMapper {
    int countByExample(StorePointExample example);

    int deleteByExample(StorePointExample example);

    int deleteByPrimaryKey(Long id);

    int insert(StorePoint record);

    Long insertSelective(StorePoint record);

    List<StorePoint> selectByExample(StorePointExample example);
    List<StorePoint> selectByExampleWithPage(StorePointExample example);

    StorePoint selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") StorePoint record, @Param("example") StorePointExample example);

    int updateByExample(@Param("record") StorePoint record, @Param("example") StorePointExample example);

    int updateByPrimaryKeySelective(StorePoint record);

    int updateByPrimaryKey(StorePoint record);
}