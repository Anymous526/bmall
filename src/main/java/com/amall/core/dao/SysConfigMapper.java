package com.amall.core.dao;

import com.amall.core.bean.SysConfig;
import com.amall.core.bean.SysConfigExample;
import com.amall.core.bean.SysConfigWithBLOBs;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SysConfigMapper {
    int countByExample(SysConfigExample example);

    int deleteByExample(SysConfigExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysConfigWithBLOBs record);

    Long insertSelective(SysConfigWithBLOBs record);

    List<SysConfigWithBLOBs> selectByExampleWithBLOBs(SysConfigExample example);
    List<SysConfigWithBLOBs> selectByExampleWithBLOBsAndPage(SysConfigExample example);

    List<SysConfig> selectByExample(SysConfigExample example);
    List<SysConfig> selectByExampleWithPage(SysConfigExample example);

    SysConfigWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysConfigWithBLOBs record, @Param("example") SysConfigExample example);

    int updateByExampleWithBLOBs(@Param("record") SysConfigWithBLOBs record, @Param("example") SysConfigExample example);

    int updateByExample(@Param("record") SysConfig record, @Param("example") SysConfigExample example);

    int updateByPrimaryKeySelective(SysConfigWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(SysConfigWithBLOBs record);

    int updateByPrimaryKey(SysConfig record);
}