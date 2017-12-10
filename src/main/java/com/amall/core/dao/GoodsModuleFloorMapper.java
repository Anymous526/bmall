package com.amall.core.dao;

import com.amall.core.bean.GoodsModuleFloor;
import com.amall.core.bean.GoodsModuleFloorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsModuleFloorMapper {
    int countByExample(GoodsModuleFloorExample example);

    int deleteByExample(GoodsModuleFloorExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GoodsModuleFloor record);

    Long insertSelective(GoodsModuleFloor record);

    List<GoodsModuleFloor> selectByExample(GoodsModuleFloorExample example);
    List<GoodsModuleFloor> selectByExampleWithPage(GoodsModuleFloorExample example);

    GoodsModuleFloor selectByPrimaryKey(Long id);
    GoodsModuleFloor selectByPrimaryKey(Integer id);
    int updateByExampleSelective(@Param("record") GoodsModuleFloor record, @Param("example") GoodsModuleFloorExample example);

    int updateByExample(@Param("record") GoodsModuleFloor record, @Param("example") GoodsModuleFloorExample example);

    int updateByPrimaryKeySelective(GoodsModuleFloor record);

    int updateByPrimaryKey(GoodsModuleFloor record);
}