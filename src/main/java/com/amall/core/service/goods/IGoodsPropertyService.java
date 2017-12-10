package com.amall.core.service.goods;

import java.util.List;
import com.amall.core.bean.GoodsProperty;
import com.amall.core.bean.GoodsPropertyExample;

public abstract interface IGoodsPropertyService
{

	int countByExample (GoodsPropertyExample example);

	int deleteByExample (GoodsPropertyExample example);

	int deleteByPrimaryKey (Long id);

	int insert (GoodsProperty record);

	int insertSelective (GoodsProperty record);

	List <GoodsProperty> selectByExample (GoodsPropertyExample example);

	GoodsProperty selectByPrimaryKey (Long id);

	int updateByExample (GoodsProperty record);

	int updateByPrimaryKey (GoodsProperty record);
}
