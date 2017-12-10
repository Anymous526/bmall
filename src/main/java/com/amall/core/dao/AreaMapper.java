package com.amall.core.dao;

import com.amall.core.bean.Area;
import com.amall.core.bean.AreaExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface AreaMapper {
    int countByExample(AreaExample example);

    int deleteByExample(AreaExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Area record);

    Long insertSelective(Area record);

    List<Area> selectByExample(AreaExample example);
    List<Area> selectByExampleWithPage(AreaExample example);

    Area selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Area record, @Param("example") AreaExample example);

    int updateByExample(@Param("record") Area record, @Param("example") AreaExample example);

    int updateByPrimaryKeySelective(Area record);

    int updateByPrimaryKey(Area record);
}