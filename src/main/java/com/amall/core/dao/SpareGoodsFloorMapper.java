package com.amall.core.dao;

import com.amall.core.bean.SpareGoodsFloor;
import com.amall.core.bean.SpareGoodsFloorExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SpareGoodsFloorMapper {
    int countByExample(SpareGoodsFloorExample example);

    int deleteByExample(SpareGoodsFloorExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SpareGoodsFloor record);

    Long insertSelective(SpareGoodsFloor record);

    List<SpareGoodsFloor> selectByExample(SpareGoodsFloorExample example);
    List<SpareGoodsFloor> selectByExampleWithPage(SpareGoodsFloorExample example);

    SpareGoodsFloor selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SpareGoodsFloor record, @Param("example") SpareGoodsFloorExample example);

    int updateByExample(@Param("record") SpareGoodsFloor record, @Param("example") SpareGoodsFloorExample example);

    int updateByPrimaryKeySelective(SpareGoodsFloor record);

    int updateByPrimaryKey(SpareGoodsFloor record);
}