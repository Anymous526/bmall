package com.amall.core.dao;

import com.amall.core.bean.Visit;
import com.amall.core.bean.VisitExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface VisitMapper {
    int countByExample(VisitExample example);

    int deleteByExample(VisitExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Visit record);

    Long insertSelective(Visit record);

    List<Visit> selectByExample(VisitExample example);
    List<Visit> selectByExampleWithPage(VisitExample example);

    Visit selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Visit record, @Param("example") VisitExample example);

    int updateByExample(@Param("record") Visit record, @Param("example") VisitExample example);

    int updateByPrimaryKeySelective(Visit record);

    int updateByPrimaryKey(Visit record);
}