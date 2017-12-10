package com.amall.core.dao;

import com.amall.core.bean.GoodsPoint;
import com.amall.core.bean.GoodsPointExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsPointMapper {
    int countByExample(GoodsPointExample example);

    int deleteByExample(GoodsPointExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GoodsPoint record);

    Long insertSelective(GoodsPoint record);

    List<GoodsPoint> selectByExample(GoodsPointExample example);
    List<GoodsPoint> selectByExampleWithPage(GoodsPointExample example);

    GoodsPoint selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GoodsPoint record, @Param("example") GoodsPointExample example);

    int updateByExample(@Param("record") GoodsPoint record, @Param("example") GoodsPointExample example);

    int updateByPrimaryKeySelective(GoodsPoint record);

    int updateByPrimaryKey(GoodsPoint record);
}