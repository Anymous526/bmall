package com.amall.core.dao;

import com.amall.core.bean.SnsFriend;
import com.amall.core.bean.SnsFriendExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SnsFriendMapper {
    int countByExample(SnsFriendExample example);

    int deleteByExample(SnsFriendExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SnsFriend record);

    Long insertSelective(SnsFriend record);

    List<SnsFriend> selectByExample(SnsFriendExample example);
    List<SnsFriend> selectByExampleWithPage(SnsFriendExample example);

    SnsFriend selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SnsFriend record, @Param("example") SnsFriendExample example);

    int updateByExample(@Param("record") SnsFriend record, @Param("example") SnsFriendExample example);

    int updateByPrimaryKeySelective(SnsFriend record);

    int updateByPrimaryKey(SnsFriend record);
}