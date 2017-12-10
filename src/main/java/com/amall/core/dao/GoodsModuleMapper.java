package com.amall.core.dao;

import com.amall.core.bean.GoodsModule;
import com.amall.core.bean.GoodsModuleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsModuleMapper {
    int countByExample(GoodsModuleExample example);

    int deleteByExample(GoodsModuleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GoodsModule record);

    Long insertSelective(GoodsModule record);

    List<GoodsModule> selectByExample(GoodsModuleExample example);
    List<GoodsModule> selectByExampleWithPage(GoodsModuleExample example);

    GoodsModule selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GoodsModule record, @Param("example") GoodsModuleExample example);

    int updateByExample(@Param("record") GoodsModule record, @Param("example") GoodsModuleExample example);

    int updateByPrimaryKeySelective(GoodsModule record);

    int updateByPrimaryKey(GoodsModule record);
}