package com.amall.core.dao;

import com.amall.core.bean.BuZhu;
import com.amall.core.bean.BuZhuExample;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface BuZhuMapper {
    int countByExample(BuZhuExample example);

    int deleteByExample(BuZhuExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BuZhu record);

    int insertSelective(BuZhu record);

    List<BuZhu> selectByExample(BuZhuExample example);

    BuZhu selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BuZhu record, @Param("example") BuZhuExample example);

    int updateByExample(@Param("record") BuZhu record, @Param("example") BuZhuExample example);

    int updateByPrimaryKeySelective(BuZhu record);

    int updateByPrimaryKey(BuZhu record);
    
    List<BuZhu> selectBuZhu(@SuppressWarnings("rawtypes") HashMap map);
}