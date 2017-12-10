package com.amall.core.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.amall.core.bean.GoodsSpecProperty;
import com.amall.core.bean.GoodsSpecification;
import com.amall.core.bean.GoodsSpecificationExample;

public interface GoodsSpecificationMapper
{

	int countByExample (GoodsSpecificationExample example);

	int deleteByExample (GoodsSpecificationExample example);

	int deleteByPrimaryKey (Long id);

	int insert (GoodsSpecification record);

	Long insertSelective (GoodsSpecification record);

	List <GoodsSpecification> selectByExample (GoodsSpecificationExample example);

	List <GoodsSpecification> selectByExampleWithPage (GoodsSpecificationExample example);

	GoodsSpecification selectByPrimaryKey (Long id);

	int updateByExampleSelective (@Param("record") GoodsSpecification record , @Param("example") GoodsSpecificationExample example);

	int updateByExample (@Param("record") GoodsSpecification record , @Param("example") GoodsSpecificationExample example);

	int updateByPrimaryKeySelective (GoodsSpecification record);

	int updateByPrimaryKey (GoodsSpecification record);

	List <GoodsSpecification> selectGoodsSpecification (Map map);// 第三张表，根据GoodsType得到GoodsSpecification

	List <GoodsSpecification> selectSpec (HashMap map);

	List <GoodsSpecProperty> selectSpecAll (HashMap map);
}