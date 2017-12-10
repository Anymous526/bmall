package com.amall.core.dao;

import com.amall.core.bean.Report;
import com.amall.core.bean.ReportExample;
import com.amall.core.bean.ReportWithBLOBs;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ReportMapper {
    int countByExample(ReportExample example);

    int deleteByExample(ReportExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ReportWithBLOBs record);

    Long insertSelective(ReportWithBLOBs record);

    List<ReportWithBLOBs> selectByExampleWithBLOBs(ReportExample example);
    List<ReportWithBLOBs> selectByExampleWithBLOBsAndPage(ReportExample example);

    List<Report> selectByExample(ReportExample example);
    List<Report> selectByExampleWithPage(ReportExample example);

    ReportWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ReportWithBLOBs record, @Param("example") ReportExample example);

    int updateByExampleWithBLOBs(@Param("record") ReportWithBLOBs record, @Param("example") ReportExample example);

    int updateByExample(@Param("record") Report record, @Param("example") ReportExample example);

    int updateByPrimaryKeySelective(ReportWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ReportWithBLOBs record);

    int updateByPrimaryKey(Report record);
}