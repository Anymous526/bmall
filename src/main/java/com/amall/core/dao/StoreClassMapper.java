package com.amall.core.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.amall.core.bean.StoreClass;
import com.amall.core.bean.StoreClassExample;

public interface StoreClassMapper
{

	int countByExample (StoreClassExample example);

	int deleteByExample (StoreClassExample example);

	int deleteByPrimaryKey (Long id);

	int insert (StoreClass record);

	Long insertSelective (StoreClass record);

	List <StoreClass> selectByExample (StoreClassExample example);

	List <StoreClass> selectByExampleWithPage (StoreClassExample example);

	StoreClass selectByPrimaryKey (Long id);

	int updateByExampleSelective (@Param("record") StoreClass record , @Param("example") StoreClassExample example);

	int updateByExample (@Param("record") StoreClass record , @Param("example") StoreClassExample example);

	int updateByPrimaryKeySelective (StoreClass record);

	int updateByPrimaryKey (StoreClass record);

	List <StoreClass> selectChilds (Map map);
}