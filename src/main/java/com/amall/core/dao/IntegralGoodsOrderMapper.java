package com.amall.core.dao;

import com.amall.core.bean.IntegralGoodsOrder;
import com.amall.core.bean.IntegralGoodsOrderExample;
import com.amall.core.bean.IntegralGoodsOrderWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IntegralGoodsOrderMapper {
    int countByExample(IntegralGoodsOrderExample example);

    int deleteByExample(IntegralGoodsOrderExample example);

    int deleteByPrimaryKey(Long id);

    Long insert(IntegralGoodsOrderWithBLOBs record);

    Long insertSelective(IntegralGoodsOrderWithBLOBs record);

    List<IntegralGoodsOrderWithBLOBs> selectByExampleWithBLOBs(IntegralGoodsOrderExample example);
    List<IntegralGoodsOrderWithBLOBs> selectByExampleWithBLOBsAndPage(IntegralGoodsOrderExample example);

    List<IntegralGoodsOrder> selectByExample(IntegralGoodsOrderExample example);

    IntegralGoodsOrderWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") IntegralGoodsOrderWithBLOBs record, @Param("example") IntegralGoodsOrderExample example);

    int updateByExampleWithBLOBs(@Param("record") IntegralGoodsOrderWithBLOBs record, @Param("example") IntegralGoodsOrderExample example);

    int updateByExample(@Param("record") IntegralGoodsOrder record, @Param("example") IntegralGoodsOrderExample example);

    int updateByPrimaryKeySelective(IntegralGoodsOrderWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(IntegralGoodsOrderWithBLOBs record);

    int updateByPrimaryKey(IntegralGoodsOrder record);

}