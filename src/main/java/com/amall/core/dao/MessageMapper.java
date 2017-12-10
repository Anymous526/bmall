package com.amall.core.dao;

import com.amall.core.bean.Message;
import com.amall.core.bean.MessageExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface MessageMapper {
    int countByExample(MessageExample example);

    int deleteByExample(MessageExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Message record);

    Long insertSelective(Message record);

    List<Message> selectByExampleWithBLOBs(MessageExample example);
    List<Message> selectByExampleWithBLOBsAndPage(MessageExample example);

    List<Message> selectByExample(MessageExample example);
    List<Message> selectByExampleWithPage(MessageExample example);

    Message selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Message record, @Param("example") MessageExample example);

    int updateByExampleWithBLOBs(@Param("record") Message record, @Param("example") MessageExample example);

    int updateByExample(@Param("record") Message record, @Param("example") MessageExample example);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKeyWithBLOBs(Message record);

    int updateByPrimaryKey(Message record);
}