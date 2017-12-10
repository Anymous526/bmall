package com.amall.core.dao;

import com.amall.core.bean.GoodsFloor;
import com.amall.core.bean.GoodsFloorExample;
import com.amall.core.bean.GoodsFloorWithBLOBs;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface GoodsFloorMapper {
    int countByExample(GoodsFloorExample example);

    int deleteByExample(GoodsFloorExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GoodsFloorWithBLOBs record);

    Long insertSelective(GoodsFloorWithBLOBs record);

    List<GoodsFloorWithBLOBs> selectByExampleWithBLOBs(GoodsFloorExample example);
    List<GoodsFloorWithBLOBs> selectByExampleWithBLOBsAndPage(GoodsFloorExample example);

    List<GoodsFloor> selectByExample(GoodsFloorExample example);
    List<GoodsFloor> selectByExampleWithPage(GoodsFloorExample example);

    GoodsFloorWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GoodsFloorWithBLOBs record, @Param("example") GoodsFloorExample example);

    int updateByExampleWithBLOBs(@Param("record") GoodsFloorWithBLOBs record, @Param("example") GoodsFloorExample example);

    int updateByExample(@Param("record") GoodsFloor record, @Param("example") GoodsFloorExample example);

    int updateByPrimaryKeySelective(GoodsFloorWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(GoodsFloorWithBLOBs record);

    int updateByPrimaryKey(GoodsFloor record);
    
    List<GoodsFloorWithBLOBs> selectChildsByInnerJoin(Long id);
}