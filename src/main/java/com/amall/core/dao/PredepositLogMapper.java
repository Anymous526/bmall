package com.amall.core.dao;

import com.amall.core.bean.PredepositLog;
import com.amall.core.bean.PredepositLogExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface PredepositLogMapper {
    int countByExample(PredepositLogExample example);

    int deleteByExample(PredepositLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PredepositLog record);

    Long insertSelective(PredepositLog record);

    List<PredepositLog> selectByExampleWithBLOBs(PredepositLogExample example);
    List<PredepositLog> selectByExampleWithBLOBsAndPage(PredepositLogExample example);

    List<PredepositLog> selectByExample(PredepositLogExample example);
    List<PredepositLog> selectByExampleWithPage(PredepositLogExample example);

    PredepositLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PredepositLog record, @Param("example") PredepositLogExample example);

    int updateByExampleWithBLOBs(@Param("record") PredepositLog record, @Param("example") PredepositLogExample example);

    int updateByExample(@Param("record") PredepositLog record, @Param("example") PredepositLogExample example);

    int updateByPrimaryKeySelective(PredepositLog record);

    int updateByPrimaryKeyWithBLOBs(PredepositLog record);

    int updateByPrimaryKey(PredepositLog record);
}