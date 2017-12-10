package com.amall.core.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.amall.core.bean.GoodsClass2Spec;
import com.amall.core.bean.GoodsClass2SpecExample;

public interface GoodsClass2SpecMapper {
    int countByExample(GoodsClass2SpecExample example);

    int deleteByExample(GoodsClass2SpecExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GoodsClass2Spec record);

    int insertSelective(GoodsClass2Spec record);

    List<GoodsClass2Spec> selectByExample(GoodsClass2SpecExample example);

    GoodsClass2Spec selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GoodsClass2Spec record, @Param("example") GoodsClass2SpecExample example);

    int updateByExample(@Param("record") GoodsClass2Spec record, @Param("example") GoodsClass2SpecExample example);

    int updateByPrimaryKeySelective(GoodsClass2Spec record);

    int updateByPrimaryKey(GoodsClass2Spec record);
}