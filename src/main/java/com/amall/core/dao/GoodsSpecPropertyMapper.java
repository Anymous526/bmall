package com.amall.core.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.amall.core.bean.GoodsSpecProperty;
import com.amall.core.bean.GoodsSpecPropertyExample;

public interface GoodsSpecPropertyMapper {
    int countByExample(GoodsSpecPropertyExample example);

    int deleteByExample(GoodsSpecPropertyExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GoodsSpecProperty record);

    Long insertSelective(GoodsSpecProperty record);

    List<GoodsSpecProperty> selectByExample(GoodsSpecPropertyExample example);
    List<GoodsSpecProperty> selectByExampleWithPage(GoodsSpecPropertyExample example);

    GoodsSpecProperty selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GoodsSpecProperty record, @Param("example") GoodsSpecPropertyExample example);

    int updateByExample(@Param("record") GoodsSpecProperty record, @Param("example") GoodsSpecPropertyExample example);

    int updateByPrimaryKeySelective(GoodsSpecProperty record);

    int updateByPrimaryKey(GoodsSpecProperty record);
    
    List<GoodsSpecProperty> selectGoodsPropertyByLeftJoinSpecAndGoodsId(long id);
}