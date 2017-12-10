package com.amall.core.dao;

import com.amall.core.bean.SpareGoods;
import com.amall.core.bean.SpareGoodsExample;
import com.amall.core.bean.SpareGoodsWithBLOBs;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SpareGoodsMapper {
    int countByExample(SpareGoodsExample example);

    int deleteByExample(SpareGoodsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SpareGoodsWithBLOBs record);

    Long insertSelective(SpareGoodsWithBLOBs record);

    List<SpareGoodsWithBLOBs> selectByExampleWithBLOBs(SpareGoodsExample example);
    List<SpareGoodsWithBLOBs> selectByExampleWithBLOBsAndPage(SpareGoodsExample example);

    List<SpareGoods> selectByExample(SpareGoodsExample example);
    List<SpareGoods> selectByExampleWithPage(SpareGoodsExample example);

    SpareGoodsWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SpareGoodsWithBLOBs record, @Param("example") SpareGoodsExample example);

    int updateByExampleWithBLOBs(@Param("record") SpareGoodsWithBLOBs record, @Param("example") SpareGoodsExample example);

    int updateByExample(@Param("record") SpareGoods record, @Param("example") SpareGoodsExample example);

    int updateByPrimaryKeySelective(SpareGoodsWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(SpareGoodsWithBLOBs record);

    int updateByPrimaryKey(SpareGoods record);
}