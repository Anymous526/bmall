package com.amall.core.dao;

import com.amall.core.bean.StoreCart;
import com.amall.core.bean.StoreCartExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface StoreCartMapper {
    int countByExample(StoreCartExample example);

    int deleteByExample(StoreCartExample example);

    int deleteByPrimaryKey(Long id);

    int insert(StoreCart record);

    Long insertSelective(StoreCart record);

    List<StoreCart> selectByExample(StoreCartExample example);
    List<StoreCart> selectByExampleWithPage(StoreCartExample example);

    StoreCart selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") StoreCart record, @Param("example") StoreCartExample example);

    int updateByExample(@Param("record") StoreCart record, @Param("example") StoreCartExample example);

    int updateByPrimaryKeySelective(StoreCart record);

    int updateByPrimaryKey(StoreCart record);
}