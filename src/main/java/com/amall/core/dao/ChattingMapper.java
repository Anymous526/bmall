package com.amall.core.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.amall.core.bean.Chatting;
import com.amall.core.bean.ChattingExample;

public interface ChattingMapper
{

	int countByExample (ChattingExample example);

	int deleteByExample (ChattingExample example);

	int deleteByPrimaryKey (Long id);

	int insert (Chatting record);

	Long insertSelective (Chatting record);

	List <Chatting> selectByExample (ChattingExample example);

	List <Chatting> selectByExampleWithPage (ChattingExample example);

	Chatting selectByPrimaryKey (Long id);

	int updateByExampleSelective (@Param("record") Chatting record , @Param("example") ChattingExample example);

	int updateByExample (@Param("record") Chatting record , @Param("example") ChattingExample example);

	int updateByPrimaryKeySelective (Chatting record);

	int updateByPrimaryKey (Chatting record);

	List <Chatting> selectChattings (Map<? extends Object,? extends Object> map);// map键设为userId
}