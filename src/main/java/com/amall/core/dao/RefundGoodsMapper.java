package com.amall.core.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.amall.core.bean.RefundGoods;
import com.amall.core.bean.RefundGoodsExample;

public interface RefundGoodsMapper {
    int countByExample(RefundGoodsExample example);

    int deleteByExample(RefundGoodsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RefundGoods record);

    int insertSelective(RefundGoods record);

    List<RefundGoods> selectByExample(RefundGoodsExample example);

    RefundGoods selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RefundGoods record, @Param("example") RefundGoodsExample example);

    int updateByExample(@Param("record") RefundGoods record, @Param("example") RefundGoodsExample example);

    int updateByPrimaryKeySelective(RefundGoods record);

    int updateByPrimaryKey(RefundGoods record);
}