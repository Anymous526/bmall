package com.amall.core.dao;

import com.amall.core.bean.TransArea;
import com.amall.core.bean.TransAreaExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface TransAreaMapper {
    int countByExample(TransAreaExample example);

    int deleteByExample(TransAreaExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TransArea record);

    Long insertSelective(TransArea record);

    List<TransArea> selectByExample(TransAreaExample example);
    List<TransArea> selectByExampleWithPage(TransAreaExample example);

    TransArea selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TransArea record, @Param("example") TransAreaExample example);

    int updateByExample(@Param("record") TransArea record, @Param("example") TransAreaExample example);

    int updateByPrimaryKeySelective(TransArea record);

    int updateByPrimaryKey(TransArea record);
}