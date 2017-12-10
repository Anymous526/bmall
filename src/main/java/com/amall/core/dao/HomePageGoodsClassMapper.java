package com.amall.core.dao;

import com.amall.core.bean.HomePageGoodsClass;
import com.amall.core.bean.HomePageGoodsClassExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface HomePageGoodsClassMapper {
    int countByExample(HomePageGoodsClassExample example);

    int deleteByExample(HomePageGoodsClassExample example);

    int deleteByPrimaryKey(Long id);

    int insert(HomePageGoodsClass record);

    Long insertSelective(HomePageGoodsClass record);

    List<HomePageGoodsClass> selectByExample(HomePageGoodsClassExample example);
    List<HomePageGoodsClass> selectByExampleWithPage(HomePageGoodsClassExample example);

    HomePageGoodsClass selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") HomePageGoodsClass record, @Param("example") HomePageGoodsClassExample example);

    int updateByExample(@Param("record") HomePageGoodsClass record, @Param("example") HomePageGoodsClassExample example);

    int updateByPrimaryKeySelective(HomePageGoodsClass record);

    int updateByPrimaryKey(HomePageGoodsClass record);
}