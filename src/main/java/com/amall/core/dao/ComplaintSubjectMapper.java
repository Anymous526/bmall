package com.amall.core.dao;

import com.amall.core.bean.ComplaintSubject;
import com.amall.core.bean.ComplaintSubjectExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ComplaintSubjectMapper {
    int countByExample(ComplaintSubjectExample example);

    int deleteByExample(ComplaintSubjectExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ComplaintSubject record);

    Long insertSelective(ComplaintSubject record);

    List<ComplaintSubject> selectByExampleWithBLOBs(ComplaintSubjectExample example);
    List<ComplaintSubject> selectByExampleWithBLOBsAndPage(ComplaintSubjectExample example);

    List<ComplaintSubject> selectByExample(ComplaintSubjectExample example);
    List<ComplaintSubject> selectByExampleWithPage(ComplaintSubjectExample example);

    ComplaintSubject selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ComplaintSubject record, @Param("example") ComplaintSubjectExample example);

    int updateByExampleWithBLOBs(@Param("record") ComplaintSubject record, @Param("example") ComplaintSubjectExample example);

    int updateByExample(@Param("record") ComplaintSubject record, @Param("example") ComplaintSubjectExample example);

    int updateByPrimaryKeySelective(ComplaintSubject record);

    int updateByPrimaryKeyWithBLOBs(ComplaintSubject record);

    int updateByPrimaryKey(ComplaintSubject record);
}