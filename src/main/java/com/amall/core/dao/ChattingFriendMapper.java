package com.amall.core.dao;

import com.amall.core.bean.ChattingFriend;
import com.amall.core.bean.ChattingFriendExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ChattingFriendMapper {
    int countByExample(ChattingFriendExample example);

    int deleteByExample(ChattingFriendExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ChattingFriend record);

    Long insertSelective(ChattingFriend record);

    List<ChattingFriend> selectByExample(ChattingFriendExample example);
    List<ChattingFriend> selectByExampleWithPage(ChattingFriendExample example);

    ChattingFriend selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ChattingFriend record, @Param("example") ChattingFriendExample example);

    int updateByExample(@Param("record") ChattingFriend record, @Param("example") ChattingFriendExample example);

    int updateByPrimaryKeySelective(ChattingFriend record);

    int updateByPrimaryKey(ChattingFriend record);
}