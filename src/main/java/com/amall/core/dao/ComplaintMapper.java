package com.amall.core.dao;

import com.amall.core.bean.Complaint;
import com.amall.core.bean.ComplaintExample;
import com.amall.core.bean.ComplaintWithBLOBs;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ComplaintMapper {
    int countByExample(ComplaintExample example);

    int deleteByExample(ComplaintExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ComplaintWithBLOBs record);

    Long insertSelective(ComplaintWithBLOBs record);

    List<ComplaintWithBLOBs> selectByExampleWithBLOBs(ComplaintExample example);
    List<ComplaintWithBLOBs> selectByExampleWithBLOBsAndPage(ComplaintExample example);

    List<Complaint> selectByExample(ComplaintExample example);
    List<Complaint> selectByExampleWithPage(ComplaintExample example);

    ComplaintWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ComplaintWithBLOBs record, @Param("example") ComplaintExample example);

    int updateByExampleWithBLOBs(@Param("record") ComplaintWithBLOBs record, @Param("example") ComplaintExample example);

    int updateByExample(@Param("record") Complaint record, @Param("example") ComplaintExample example);

    int updateByPrimaryKeySelective(ComplaintWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ComplaintWithBLOBs record);

    int updateByPrimaryKey(Complaint record);
}