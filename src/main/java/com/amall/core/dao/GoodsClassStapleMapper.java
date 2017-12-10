package com.amall.core.dao;

import com.amall.core.bean.GoodsClassStaple;
import com.amall.core.bean.GoodsClassStapleExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface GoodsClassStapleMapper {
    int countByExample(GoodsClassStapleExample example);

    int deleteByExample(GoodsClassStapleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GoodsClassStaple record);

    Long insertSelective(GoodsClassStaple record);

    List<GoodsClassStaple> selectByExample(GoodsClassStapleExample example);
    List<GoodsClassStaple> selectByExampleWithPage(GoodsClassStapleExample example);

    GoodsClassStaple selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GoodsClassStaple record, @Param("example") GoodsClassStapleExample example);

    int updateByExample(@Param("record") GoodsClassStaple record, @Param("example") GoodsClassStapleExample example);

    int updateByPrimaryKeySelective(GoodsClassStaple record);

    int updateByPrimaryKey(GoodsClassStaple record);
}