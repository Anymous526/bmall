package com.amall.core.dao;

import com.amall.core.bean.GoldRecord;
import com.amall.core.bean.GoldRecordExample;
import com.amall.core.bean.GoldRecordWithBLOBs;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface GoldRecordMapper {
    int countByExample(GoldRecordExample example);

    int deleteByExample(GoldRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GoldRecordWithBLOBs record);

    Long insertSelective(GoldRecordWithBLOBs record);

    List<GoldRecordWithBLOBs> selectByExampleWithBLOBs(GoldRecordExample example);
    List<GoldRecordWithBLOBs> selectByExampleWithBLOBsAndPage(GoldRecordExample example);

    List<GoldRecord> selectByExample(GoldRecordExample example);
    List<GoldRecord> selectByExampleWithPage(GoldRecordExample example);

    GoldRecordWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GoldRecordWithBLOBs record, @Param("example") GoldRecordExample example);

    int updateByExampleWithBLOBs(@Param("record") GoldRecordWithBLOBs record, @Param("example") GoldRecordExample example);

    int updateByExample(@Param("record") GoldRecord record, @Param("example") GoldRecordExample example);

    int updateByPrimaryKeySelective(GoldRecordWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(GoldRecordWithBLOBs record);

    int updateByPrimaryKey(GoldRecord record);
}