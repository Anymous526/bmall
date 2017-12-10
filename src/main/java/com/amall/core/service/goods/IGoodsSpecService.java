package com.amall.core.service.goods;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.amall.core.bean.GoodsSpec;
import com.amall.core.bean.GoodsSpecExample;

public abstract interface IGoodsSpecService {

	
	public int countByExample(GoodsSpecExample example);

	public int deleteByExample(GoodsSpecExample example);

    public int deleteByPrimaryKey(Long id);

    public int insert(GoodsSpec record);

    public int insertSelective(GoodsSpec record);

    public List<GoodsSpec> selectByExample(GoodsSpecExample example);

    public GoodsSpec selectByPrimaryKey(Long id);

    public int updateByExample(@Param("record") GoodsSpec record);

    public int updateByPrimaryKey(GoodsSpec record);
}
