package com.amall.core.dao;

import com.amall.core.bean.GoodsModuleFloorNext;
import com.amall.core.bean.GoodsModuleFloorNextExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsModuleFloorNextMapper
{

	int countByExample (GoodsModuleFloorNextExample example);

	int deleteByExample (GoodsModuleFloorNextExample example);

	int deleteByPrimaryKey (Long id);

	int insert (GoodsModuleFloorNext record);

	Long insertSelective (GoodsModuleFloorNext record);

	List <GoodsModuleFloorNext> selectByExample (GoodsModuleFloorNextExample example);

	GoodsModuleFloorNext selectByPrimaryKey (Long id);

	GoodsModuleFloorNext selectByPrimaryKey (Integer id);

	int updateByExampleSelective (@Param("record") GoodsModuleFloorNext record , @Param("example") GoodsModuleFloorNextExample example);

	int updateByExample (@Param("record") GoodsModuleFloorNext record , @Param("example") GoodsModuleFloorNextExample example);

	int updateByPrimaryKeySelective (GoodsModuleFloorNext record);

	int updateByPrimaryKey (GoodsModuleFloorNext record);
}