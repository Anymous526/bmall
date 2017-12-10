package com.amall.core.dao;

import com.amall.core.bean.DeliveryGoods;
import com.amall.core.bean.DeliveryGoodsExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface DeliveryGoodsMapper {
    int countByExample(DeliveryGoodsExample example);

    int deleteByExample(DeliveryGoodsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DeliveryGoods record);

    Long insertSelective(DeliveryGoods record);

    List<DeliveryGoods> selectByExample(DeliveryGoodsExample example);
    List<DeliveryGoods> selectByExampleWithPage(DeliveryGoodsExample example);

    DeliveryGoods selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DeliveryGoods record, @Param("example") DeliveryGoodsExample example);

    int updateByExample(@Param("record") DeliveryGoods record, @Param("example") DeliveryGoodsExample example);

    int updateByPrimaryKeySelective(DeliveryGoods record);

    int updateByPrimaryKey(DeliveryGoods record);
}