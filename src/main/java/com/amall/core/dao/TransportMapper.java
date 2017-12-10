package com.amall.core.dao;

import com.amall.core.bean.Transport;
import com.amall.core.bean.TransportExample;
import com.amall.core.bean.TransportWithBLOBs;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface TransportMapper {
    int countByExample(TransportExample example);

    int deleteByExample(TransportExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TransportWithBLOBs record);

    Long insertSelective(TransportWithBLOBs record);

    List<TransportWithBLOBs> selectByExampleWithBLOBs(TransportExample example);
    List<TransportWithBLOBs> selectByExampleWithBLOBsAndPage(TransportExample example);

    List<Transport> selectByExample(TransportExample example);
    List<Transport> selectByExampleWithPage(TransportExample example);

    TransportWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TransportWithBLOBs record, @Param("example") TransportExample example);

    int updateByExampleWithBLOBs(@Param("record") TransportWithBLOBs record, @Param("example") TransportExample example);

    int updateByExample(@Param("record") Transport record, @Param("example") TransportExample example);

    int updateByPrimaryKeySelective(TransportWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(TransportWithBLOBs record);

    int updateByPrimaryKey(Transport record);
}