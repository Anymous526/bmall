package com.amall.core.dao;

import com.amall.core.bean.SpareGoodsClass;
import com.amall.core.bean.SpareGoodsClassExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SpareGoodsClassMapper {
    int countByExample(SpareGoodsClassExample example);

    int deleteByExample(SpareGoodsClassExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SpareGoodsClass record);

    Long insertSelective(SpareGoodsClass record);

    List<SpareGoodsClass> selectByExample(SpareGoodsClassExample example);
    List<SpareGoodsClass> selectByExampleWithPage(SpareGoodsClassExample example);

    SpareGoodsClass selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SpareGoodsClass record, @Param("example") SpareGoodsClassExample example);

    int updateByExample(@Param("record") SpareGoodsClass record, @Param("example") SpareGoodsClassExample example);

    int updateByPrimaryKeySelective(SpareGoodsClass record);

    int updateByPrimaryKey(SpareGoodsClass record);
}