package com.amall.core.dao;

import com.amall.core.bean.ReportType;
import com.amall.core.bean.ReportTypeExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ReportTypeMapper {
    int countByExample(ReportTypeExample example);

    int deleteByExample(ReportTypeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ReportType record);

    Long insertSelective(ReportType record);

    List<ReportType> selectByExampleWithBLOBs(ReportTypeExample example);
    List<ReportType> selectByExampleWithBLOBsAndPage(ReportTypeExample example);

    List<ReportType> selectByExample(ReportTypeExample example);
    List<ReportType> selectByExampleWithPage(ReportTypeExample example);

    ReportType selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ReportType record, @Param("example") ReportTypeExample example);

    int updateByExampleWithBLOBs(@Param("record") ReportType record, @Param("example") ReportTypeExample example);

    int updateByExample(@Param("record") ReportType record, @Param("example") ReportTypeExample example);

    int updateByPrimaryKeySelective(ReportType record);

    int updateByPrimaryKeyWithBLOBs(ReportType record);

    int updateByPrimaryKey(ReportType record);
}