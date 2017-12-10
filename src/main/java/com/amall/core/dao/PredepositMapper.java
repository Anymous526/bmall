package com.amall.core.dao;

import com.amall.core.bean.Predeposit;
import com.amall.core.bean.PredepositExample;
import com.amall.core.bean.PredepositWithBLOBs;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface PredepositMapper {
    int countByExample(PredepositExample example);

    int deleteByExample(PredepositExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PredepositWithBLOBs record);

    Long insertSelective(PredepositWithBLOBs record);

    List<PredepositWithBLOBs> selectByExampleWithBLOBs(PredepositExample example);
    List<PredepositWithBLOBs> selectByExampleWithBLOBsAndPage(PredepositExample example);

    List<Predeposit> selectByExample(PredepositExample example);
    List<Predeposit> selectByExampleWithPage(PredepositExample example);

    PredepositWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PredepositWithBLOBs record, @Param("example") PredepositExample example);

    int updateByExampleWithBLOBs(@Param("record") PredepositWithBLOBs record, @Param("example") PredepositExample example);

    int updateByExample(@Param("record") Predeposit record, @Param("example") PredepositExample example);

    int updateByPrimaryKeySelective(PredepositWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(PredepositWithBLOBs record);

    int updateByPrimaryKey(Predeposit record);
}