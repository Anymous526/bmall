package com.amall.core.dao;

import com.amall.core.bean.CombinLog;
import com.amall.core.bean.CombinLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CombinLogMapper
{

	int countByExample (CombinLogExample example);

	int deleteByExample (CombinLogExample example);

	int deleteByPrimaryKey (Long id);

	int insert (CombinLog record);

	Long insertSelective (CombinLog record);

	List <CombinLog> selectByExample (CombinLogExample example);

	List <CombinLog> selectByExampleWithPage (CombinLogExample example);

	CombinLog selectByPrimaryKey (Long id);

	int updateByExampleSelective (@Param("record") CombinLog record , @Param("example") CombinLogExample example);

	int updateByExample (@Param("record") CombinLog record , @Param("example") CombinLogExample example);

	int updateByPrimaryKeySelective (CombinLog record);

	int updateByPrimaryKey (CombinLog record);
}