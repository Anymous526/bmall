package com.amall.core.dao;

import com.amall.core.bean.Consult;
import com.amall.core.bean.ConsultExample;
import com.amall.core.bean.ConsultWithBLOBs;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ConsultMapper {
    int countByExample(ConsultExample example);

    int deleteByExample(ConsultExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ConsultWithBLOBs record);

    Long insertSelective(ConsultWithBLOBs record);

    List<ConsultWithBLOBs> selectByExampleWithBLOBs(ConsultExample example);
    List<ConsultWithBLOBs> selectByExampleWithBLOBsAndPage(ConsultExample example);

    List<Consult> selectByExample(ConsultExample example);
    List<Consult> selectByExampleWithPage(ConsultExample example);

    ConsultWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ConsultWithBLOBs record, @Param("example") ConsultExample example);

    int updateByExampleWithBLOBs(@Param("record") ConsultWithBLOBs record, @Param("example") ConsultExample example);

    int updateByExample(@Param("record") Consult record, @Param("example") ConsultExample example);

    int updateByPrimaryKeySelective(ConsultWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ConsultWithBLOBs record);

    int updateByPrimaryKey(Consult record);
}