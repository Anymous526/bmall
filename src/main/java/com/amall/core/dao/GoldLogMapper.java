package com.amall.core.dao;

import com.amall.core.bean.GoldLog;
import com.amall.core.bean.GoldLogExample;
import com.amall.core.bean.GoldLogWithBLOBs;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface GoldLogMapper {
    int countByExample(GoldLogExample example);

    int deleteByExample(GoldLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GoldLogWithBLOBs record);

    Long insertSelective(GoldLogWithBLOBs record);

    List<GoldLogWithBLOBs> selectByExampleWithBLOBs(GoldLogExample example);
    List<GoldLogWithBLOBs> selectByExampleWithBLOBsAndPage(GoldLogExample example);

    List<GoldLog> selectByExample(GoldLogExample example);
    List<GoldLog> selectByExampleWithPage(GoldLogExample example);

    GoldLogWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GoldLogWithBLOBs record, @Param("example") GoldLogExample example);

    int updateByExampleWithBLOBs(@Param("record") GoldLogWithBLOBs record, @Param("example") GoldLogExample example);

    int updateByExample(@Param("record") GoldLog record, @Param("example") GoldLogExample example);

    int updateByPrimaryKeySelective(GoldLogWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(GoldLogWithBLOBs record);

    int updateByPrimaryKey(GoldLog record);
}