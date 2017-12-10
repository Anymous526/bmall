package com.amall.core.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.amall.core.bean.VipActiveLog;
import com.amall.core.bean.VipActiveLogExample;

public interface VipActiveLogMapper {
	int countByExample(VipActiveLogExample example);

	int deleteByExample(VipActiveLogExample example);

	int deleteByPrimaryKey(Long id);

	int insert(VipActiveLog record);

	int insertSelective(VipActiveLog record);

	List<VipActiveLog> selectByExampleWithBLOBs(VipActiveLogExample example);

	List<VipActiveLog> selectByExampleWithPage(VipActiveLogExample example);

	List<VipActiveLog> selectByExample(VipActiveLogExample example);

	VipActiveLog selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") VipActiveLog record, @Param("example") VipActiveLogExample example);

	int updateByExampleWithBLOBs(@Param("record") VipActiveLog record, @Param("example") VipActiveLogExample example);

	int updateByExample(@Param("record") VipActiveLog record, @Param("example") VipActiveLogExample example);

	int updateByPrimaryKeySelective(VipActiveLog record);

	int updateByPrimaryKeyWithBLOBs(VipActiveLog record);

	int updateByPrimaryKey(VipActiveLog record);
}