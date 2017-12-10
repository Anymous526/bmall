package com.amall.core.dao;

import com.amall.core.bean.GoodsBrand;
import com.amall.core.bean.GoodsType;
import com.amall.core.bean.GoodsTypeExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface GoodsTypeMapper {
    int countByExample(GoodsTypeExample example);

    int deleteByExample(GoodsTypeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GoodsType record);

    Long insertSelective(GoodsType record);

    List<GoodsType> selectByExample(GoodsTypeExample example);
    List<GoodsType> selectByExampleWithPage(GoodsTypeExample example);

    GoodsType selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GoodsType record, @Param("example") GoodsTypeExample example);

    int updateByExample(@Param("record") GoodsType record, @Param("example") GoodsTypeExample example);

    int updateByPrimaryKeySelective(GoodsType record);

    int updateByPrimaryKey(GoodsType record);
    
    List<GoodsBrand> selectGoodsBrandRightJoinByGoodsTypeId(long id);
}