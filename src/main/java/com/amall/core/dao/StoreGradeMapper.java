package com.amall.core.dao;

import com.amall.core.bean.StoreGrade;
import com.amall.core.bean.StoreGradeExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface StoreGradeMapper {
    int countByExample(StoreGradeExample example);

    int deleteByExample(StoreGradeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(StoreGrade record);

    Long insertSelective(StoreGrade record);

    List<StoreGrade> selectByExampleWithBLOBs(StoreGradeExample example);
    List<StoreGrade> selectByExampleWithBLOBsAndPage(StoreGradeExample example);

    List<StoreGrade> selectByExample(StoreGradeExample example);
    List<StoreGrade> selectByExampleWithPage(StoreGradeExample example);

    StoreGrade selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") StoreGrade record, @Param("example") StoreGradeExample example);

    int updateByExampleWithBLOBs(@Param("record") StoreGrade record, @Param("example") StoreGradeExample example);

    int updateByExample(@Param("record") StoreGrade record, @Param("example") StoreGradeExample example);

    int updateByPrimaryKeySelective(StoreGrade record);

    int updateByPrimaryKeyWithBLOBs(StoreGrade record);

    int updateByPrimaryKey(StoreGrade record);
}