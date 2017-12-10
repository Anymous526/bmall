package com.amall.core.dao;

import com.amall.core.bean.CloudGoods;
import com.amall.core.bean.CloudGoodsAuto;
import com.amall.core.bean.CloudGoodsAutoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CloudGoodsAutoMapper
{

	int countByExample (CloudGoodsAutoExample example);

	int deleteByExample (CloudGoodsAutoExample example);

	int deleteByPrimaryKey (Long id);

	int insert (CloudGoodsAuto record);

	Long insertSelective (CloudGoodsAuto record);

	List <CloudGoodsAuto> selectByExample (CloudGoodsAutoExample example);

	List <CloudGoods> selectByExampleWithPage (CloudGoodsAutoExample example);

	CloudGoodsAuto selectByPrimaryKey (Long id);

	int updateByExampleSelective (@Param("record") CloudGoodsAuto record , @Param("example") CloudGoodsAutoExample example);

	int updateByExample (@Param("record") CloudGoodsAuto record , @Param("example") CloudGoodsAutoExample example);

	int updateByPrimaryKeySelective (CloudGoodsAuto record);

	int updateByPrimaryKey (CloudGoodsAuto record);
}