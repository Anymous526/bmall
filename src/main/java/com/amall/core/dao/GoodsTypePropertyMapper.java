package com.amall.core.dao;

import com.amall.core.bean.GoodsTypeProperty;
import com.amall.core.bean.GoodsTypePropertyExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface GoodsTypePropertyMapper {
    int countByExample(GoodsTypePropertyExample example);

    int deleteByExample(GoodsTypePropertyExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GoodsTypeProperty record);

    Long insertSelective(GoodsTypeProperty record);

    List<GoodsTypeProperty> selectByExample(GoodsTypePropertyExample example);
    List<GoodsTypeProperty> selectByExampleWithPage(GoodsTypePropertyExample example);

    GoodsTypeProperty selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GoodsTypeProperty record, @Param("example") GoodsTypePropertyExample example);

    int updateByExample(@Param("record") GoodsTypeProperty record, @Param("example") GoodsTypePropertyExample example);

    int updateByPrimaryKeySelective(GoodsTypeProperty record);

    int updateByPrimaryKey(GoodsTypeProperty record);
}