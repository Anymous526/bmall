package com.amall.core.dao;

import com.amall.core.bean.ZTCGoldLog;
import com.amall.core.bean.ZTCGoldLogExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ZTCGoldLogMapper {
    int countByExample(ZTCGoldLogExample example);

    int deleteByExample(ZTCGoldLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ZTCGoldLog record);

    Long insertSelective(ZTCGoldLog record);

    List<ZTCGoldLog> selectByExample(ZTCGoldLogExample example);
    List<ZTCGoldLog> selectByExampleWithPage(ZTCGoldLogExample example);

    ZTCGoldLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ZTCGoldLog record, @Param("example") ZTCGoldLogExample example);

    int updateByExample(@Param("record") ZTCGoldLog record, @Param("example") ZTCGoldLogExample example);

    int updateByPrimaryKeySelective(ZTCGoldLog record);

    int updateByPrimaryKey(ZTCGoldLog record);
}