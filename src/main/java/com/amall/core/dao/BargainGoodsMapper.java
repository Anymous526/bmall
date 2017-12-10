package com.amall.core.dao;

import com.amall.core.bean.BargainGoods;
import com.amall.core.bean.BargainGoodsExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface BargainGoodsMapper {
    int countByExample(BargainGoodsExample example);

    int deleteByExample(BargainGoodsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BargainGoods record);

    Long insertSelective(BargainGoods record);

    List<BargainGoods> selectByExample(BargainGoodsExample example);
    List<BargainGoods> selectByExampleWithPage(BargainGoodsExample example);

    BargainGoods selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BargainGoods record, @Param("example") BargainGoodsExample example);

    int updateByExample(@Param("record") BargainGoods record, @Param("example") BargainGoodsExample example);

    int updateByPrimaryKeySelective(BargainGoods record);

    int updateByPrimaryKey(BargainGoods record);
}