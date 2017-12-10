package com.amall.core.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.amall.core.bean.doulog;
import com.amall.core.bean.doulogExample;

public interface doulogMapper {
    int countByExample(doulogExample example);

    int deleteByExample(doulogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(doulog record);

    int insertSelective(doulog record);

    List<doulog> selectByExample(doulogExample example);
    List<doulog> selectByExampleWithBLOBsAndPage(doulogExample example);

    doulog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") doulog record, @Param("example") doulogExample example);
    
    int updateByExample(@Param("record") doulog record, @Param("example") doulogExample example);

    int updateByPrimaryKeySelective(doulog record);

    int updateByPrimaryKey(doulog record);
}