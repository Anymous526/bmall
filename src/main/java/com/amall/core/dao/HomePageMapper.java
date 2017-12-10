package com.amall.core.dao;

import com.amall.core.bean.HomePage;
import com.amall.core.bean.HomePageExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface HomePageMapper {
    int countByExample(HomePageExample example);

    int deleteByExample(HomePageExample example);

    int deleteByPrimaryKey(Long id);

    int insert(HomePage record);

    Long insertSelective(HomePage record);

    List<HomePage> selectByExample(HomePageExample example);
    List<HomePage> selectByExampleWithPage(HomePageExample example);

    HomePage selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") HomePage record, @Param("example") HomePageExample example);

    int updateByExample(@Param("record") HomePage record, @Param("example") HomePageExample example);

    int updateByPrimaryKeySelective(HomePage record);

    int updateByPrimaryKey(HomePage record);
}