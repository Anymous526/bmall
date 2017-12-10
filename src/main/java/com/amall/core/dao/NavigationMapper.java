package com.amall.core.dao;

import com.amall.core.bean.Navigation;
import com.amall.core.bean.NavigationExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface NavigationMapper {
    int countByExample(NavigationExample example);

    int deleteByExample(NavigationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Navigation record);

    Long insertSelective(Navigation record);

    List<Navigation> selectByExample(NavigationExample example);
    List<Navigation> selectByExampleWithPage(NavigationExample example);

    Navigation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Navigation record, @Param("example") NavigationExample example);

    int updateByExample(@Param("record") Navigation record, @Param("example") NavigationExample example);

    int updateByPrimaryKeySelective(Navigation record);

    int updateByPrimaryKey(Navigation record);
}