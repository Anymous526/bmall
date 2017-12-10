package com.amall.core.dao;

import com.amall.core.bean.StoreStat;
import com.amall.core.bean.StoreStatExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface StoreStatMapper {
    int countByExample(StoreStatExample example);

    int deleteByExample(StoreStatExample example);

    int deleteByPrimaryKey(Long id);

    int insert(StoreStat record);

    Long insertSelective(StoreStat record);

    List<StoreStat> selectByExample(StoreStatExample example);
    List<StoreStat> selectByExampleWithPage(StoreStatExample example);

    StoreStat selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") StoreStat record, @Param("example") StoreStatExample example);

    int updateByExample(@Param("record") StoreStat record, @Param("example") StoreStatExample example);

    int updateByPrimaryKeySelective(StoreStat record);

    int updateByPrimaryKey(StoreStat record);
}