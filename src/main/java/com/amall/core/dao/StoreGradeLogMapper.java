package com.amall.core.dao;

import com.amall.core.bean.StoreGradeLog;
import com.amall.core.bean.StoreGradeLogExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface StoreGradeLogMapper {
    int countByExample(StoreGradeLogExample example);

    int deleteByExample(StoreGradeLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(StoreGradeLog record);

    Long insertSelective(StoreGradeLog record);

    List<StoreGradeLog> selectByExample(StoreGradeLogExample example);
    List<StoreGradeLog> selectByExampleWithPage(StoreGradeLogExample example);

    StoreGradeLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") StoreGradeLog record, @Param("example") StoreGradeLogExample example);

    int updateByExample(@Param("record") StoreGradeLog record, @Param("example") StoreGradeLogExample example);

    int updateByPrimaryKeySelective(StoreGradeLog record);

    int updateByPrimaryKey(StoreGradeLog record);
}