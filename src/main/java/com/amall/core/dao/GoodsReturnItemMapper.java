package com.amall.core.dao;

import com.amall.core.bean.GoodsReturnItem;
import com.amall.core.bean.GoodsReturnItemExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface GoodsReturnItemMapper {
    int countByExample(GoodsReturnItemExample example);

    int deleteByExample(GoodsReturnItemExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GoodsReturnItem record);

    Long insertSelective(GoodsReturnItem record);

    List<GoodsReturnItem> selectByExampleWithBLOBs(GoodsReturnItemExample example);
    List<GoodsReturnItem> selectByExampleWithBLOBsAndPage(GoodsReturnItemExample example);

    List<GoodsReturnItem> selectByExample(GoodsReturnItemExample example);
    List<GoodsReturnItem> selectByExampleWithPage(GoodsReturnItemExample example);

    GoodsReturnItem selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GoodsReturnItem record, @Param("example") GoodsReturnItemExample example);

    int updateByExampleWithBLOBs(@Param("record") GoodsReturnItem record, @Param("example") GoodsReturnItemExample example);

    int updateByExample(@Param("record") GoodsReturnItem record, @Param("example") GoodsReturnItemExample example);

    int updateByPrimaryKeySelective(GoodsReturnItem record);

    int updateByPrimaryKeyWithBLOBs(GoodsReturnItem record);

    int updateByPrimaryKey(GoodsReturnItem record);
}