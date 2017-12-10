package com.amall.core.dao;

import com.amall.core.bean.Store;
import com.amall.core.bean.StoreExample;
import com.amall.core.bean.StoreWithBLOBs;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

public interface StoreMapper
{

	int countByExample (StoreExample example);

	int deleteByExample (StoreExample example);

	int deleteByPrimaryKey (Long id);

	int insert (StoreWithBLOBs record);

	Long insertSelective (StoreWithBLOBs record);

	List <StoreWithBLOBs> selectByExampleWithBLOBs (StoreExample example);

	List <StoreWithBLOBs> selectByExampleWithBLOBsAndPage (StoreExample example);

	List <Store> selectByExample (StoreExample example);

	List <Store> selectByExampleWithPage (StoreExample example);

	StoreWithBLOBs selectByPrimaryKey (Long id);

	int updateByExampleSelective (@Param("record") StoreWithBLOBs record , @Param("example") StoreExample example);

	int updateByExampleWithBLOBs (@Param("record") StoreWithBLOBs record , @Param("example") StoreExample example);

	int updateByExample (@Param("record") Store record , @Param("example") StoreExample example);

	int updateByPrimaryKeySelective (StoreWithBLOBs record);

	int updateByPrimaryKeyWithBLOBs (StoreWithBLOBs record);

	int updateByPrimaryKey (Store record);

	int getStoreValidation (Map map);

	StoreWithBLOBs getStoreValidation1 (Map map);

	int getStoreNameValidation (String storeName);

	int getStoreOwerCardValidation (String storeOwerCard);

	int getStoreTelephoneValidation (String storeTelpehone);
}