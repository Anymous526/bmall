package com.amall.core.dao;

import com.amall.core.bean.ReportSubject;
import com.amall.core.bean.ReportSubjectExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ReportSubjectMapper {
    int countByExample(ReportSubjectExample example);

    int deleteByExample(ReportSubjectExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ReportSubject record);

    Long insertSelective(ReportSubject record);

    List<ReportSubject> selectByExample(ReportSubjectExample example);
    List<ReportSubject> selectByExampleWithPage(ReportSubjectExample example);

    ReportSubject selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ReportSubject record, @Param("example") ReportSubjectExample example);

    int updateByExample(@Param("record") ReportSubject record, @Param("example") ReportSubjectExample example);

    int updateByPrimaryKeySelective(ReportSubject record);

    int updateByPrimaryKey(ReportSubject record);
}