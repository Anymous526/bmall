package com.amall.core.dao;

import com.amall.core.bean.IntegralGoods;
import com.amall.core.bean.IntegralGoodsExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface IntegralGoodsMapper {
    int countByExample(IntegralGoodsExample example);

    int deleteByExample(IntegralGoodsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(IntegralGoods record);

    Long insertSelective(IntegralGoods record);

    List<IntegralGoods> selectByExample(IntegralGoodsExample example);
    List<IntegralGoods> selectByExampleWithPage(IntegralGoodsExample example);

    IntegralGoods selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") IntegralGoods record, @Param("example") IntegralGoodsExample example);

    int updateByExample(@Param("record") IntegralGoods record, @Param("example") IntegralGoodsExample example);

    int updateByPrimaryKeySelective(IntegralGoods record);

    int updateByPrimaryKey(IntegralGoods record);
    
}