package com.amall.core.dao;

import com.amall.core.bean.ActivityGoods;
import com.amall.core.bean.ActivityGoodsExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ActivityGoodsMapper {
    int countByExample(ActivityGoodsExample example);

    int deleteByExample(ActivityGoodsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ActivityGoods record);

    Long insertSelective(ActivityGoods record);

    List<ActivityGoods> selectByExample(ActivityGoodsExample example);
    List<ActivityGoods> selectByExampleWithPage(ActivityGoodsExample example);

    ActivityGoods selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ActivityGoods record, @Param("example") ActivityGoodsExample example);

    int updateByExample(@Param("record") ActivityGoods record, @Param("example") ActivityGoodsExample example);

    int updateByPrimaryKeySelective(ActivityGoods record);

    int updateByPrimaryKey(ActivityGoods record);
}