package com.amall.core.dao;

import com.amall.core.bean.UserConfig;
import com.amall.core.bean.UserConfigExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface UserConfigMapper {
    int countByExample(UserConfigExample example);

    int deleteByExample(UserConfigExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserConfig record);

    Long insertSelective(UserConfig record);

    List<UserConfig> selectByExample(UserConfigExample example);
    List<UserConfig> selectByExampleWithPage(UserConfigExample example);

    UserConfig selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserConfig record, @Param("example") UserConfigExample example);

    int updateByExample(@Param("record") UserConfig record, @Param("example") UserConfigExample example);

    int updateByPrimaryKeySelective(UserConfig record);

    int updateByPrimaryKey(UserConfig record);
}