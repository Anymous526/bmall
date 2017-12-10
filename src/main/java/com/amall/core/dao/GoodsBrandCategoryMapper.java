package com.amall.core.dao;

import com.amall.core.bean.GoodsBrandCategory;
import com.amall.core.bean.GoodsBrandCategoryExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface GoodsBrandCategoryMapper {
    int countByExample(GoodsBrandCategoryExample example);

    int deleteByExample(GoodsBrandCategoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GoodsBrandCategory record);

    Long insertSelective(GoodsBrandCategory record);

    List<GoodsBrandCategory> selectByExample(GoodsBrandCategoryExample example);
    List<GoodsBrandCategory> selectByExampleWithPage(GoodsBrandCategoryExample example);

    GoodsBrandCategory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GoodsBrandCategory record, @Param("example") GoodsBrandCategoryExample example);

    int updateByExample(@Param("record") GoodsBrandCategory record, @Param("example") GoodsBrandCategoryExample example);

    int updateByPrimaryKeySelective(GoodsBrandCategory record);

    int updateByPrimaryKey(GoodsBrandCategory record);
}