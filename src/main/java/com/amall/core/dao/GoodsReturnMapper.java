package com.amall.core.dao;

import com.amall.core.bean.GoodsReturn;
import com.amall.core.bean.GoodsReturnExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface GoodsReturnMapper {
    int countByExample(GoodsReturnExample example);

    int deleteByExample(GoodsReturnExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GoodsReturn record);

    Long insertSelective(GoodsReturn record);

    List<GoodsReturn> selectByExampleWithBLOBs(GoodsReturnExample example);
    List<GoodsReturn> selectByExampleWithBLOBsAndPage(GoodsReturnExample example);

    List<GoodsReturn> selectByExample(GoodsReturnExample example);
    List<GoodsReturn> selectByExampleWithPage(GoodsReturnExample example);

    GoodsReturn selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GoodsReturn record, @Param("example") GoodsReturnExample example);

    int updateByExampleWithBLOBs(@Param("record") GoodsReturn record, @Param("example") GoodsReturnExample example);

    int updateByExample(@Param("record") GoodsReturn record, @Param("example") GoodsReturnExample example);

    int updateByPrimaryKeySelective(GoodsReturn record);

    int updateByPrimaryKeyWithBLOBs(GoodsReturn record);

    int updateByPrimaryKey(GoodsReturn record);
}