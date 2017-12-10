package com.amall.core.dao;

import com.amall.core.bean.ChattingLog;
import com.amall.core.bean.ChattingLogExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ChattingLogMapper {
    int countByExample(ChattingLogExample example);

    int deleteByExample(ChattingLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ChattingLog record);

    Long insertSelective(ChattingLog record);

    List<ChattingLog> selectByExampleWithBLOBs(ChattingLogExample example);
    List<ChattingLog> selectByExampleWithBLOBsAndPage(ChattingLogExample example);

    List<ChattingLog> selectByExample(ChattingLogExample example);
    List<ChattingLog> selectByExampleWithPage(ChattingLogExample example);

    ChattingLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ChattingLog record, @Param("example") ChattingLogExample example);

    int updateByExampleWithBLOBs(@Param("record") ChattingLog record, @Param("example") ChattingLogExample example);

    int updateByExample(@Param("record") ChattingLog record, @Param("example") ChattingLogExample example);

    int updateByPrimaryKeySelective(ChattingLog record);

    int updateByPrimaryKeyWithBLOBs(ChattingLog record);

    int updateByPrimaryKey(ChattingLog record);
    
    List<ChattingLog> selectLogsByMarkAndUser1Id(long user1Id);
}