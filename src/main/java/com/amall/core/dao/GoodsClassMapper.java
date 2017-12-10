package com.amall.core.dao;

import com.amall.core.bean.GoodsClass;
import com.amall.core.bean.GoodsClassExample;
import com.amall.core.bean.GoodsClassWithBLOBs;
import com.amall.core.bean.GoodsSpecial;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface GoodsClassMapper {
    int countByExample(GoodsClassExample example);

    int deleteByExample(GoodsClassExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GoodsClassWithBLOBs record);

    Long insertSelective(GoodsClassWithBLOBs record);

    List<GoodsClassWithBLOBs> selectByExampleWithBLOBs(GoodsClassExample example);
    List<GoodsClassWithBLOBs> selectByExampleWithBLOBsAndPage(GoodsClassExample example);

    List<GoodsClass> selectByExample(GoodsClassExample example);
    List<GoodsClass> selectByExampleWithPage(GoodsClassExample example);

    GoodsClassWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GoodsClassWithBLOBs record, @Param("example") GoodsClassExample example);

    int updateByExampleWithBLOBs(@Param("record") GoodsClassWithBLOBs record, @Param("example") GoodsClassExample example);

    int updateByExample(@Param("record") GoodsClass record, @Param("example") GoodsClassExample example);

    int updateByPrimaryKeySelective(GoodsClassWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(GoodsClassWithBLOBs record);

    int updateByPrimaryKey(GoodsClass record);
    
    List<GoodsSpecial> selectClass(Integer id);
}