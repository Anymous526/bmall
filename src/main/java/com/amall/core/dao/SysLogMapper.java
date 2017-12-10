package com.amall.core.dao;

import com.amall.core.bean.SysLog;
import com.amall.core.bean.SysLogExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SysLogMapper {
    int countByExample(SysLogExample example);

    int deleteByExample(SysLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysLog record);

    Long insertSelective(SysLog record);

    List<SysLog> selectByExampleWithBLOBs(SysLogExample example);
    List<SysLog> selectByExampleWithBLOBsAndPage(SysLogExample example);

    List<SysLog> selectByExample(SysLogExample example);
    List<SysLog> selectByExampleWithPage(SysLogExample example);

    SysLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysLog record, @Param("example") SysLogExample example);

    int updateByExampleWithBLOBs(@Param("record") SysLog record, @Param("example") SysLogExample example);

    int updateByExample(@Param("record") SysLog record, @Param("example") SysLogExample example);

    int updateByPrimaryKeySelective(SysLog record);

    int updateByPrimaryKeyWithBLOBs(SysLog record);

    int updateByPrimaryKey(SysLog record);
}