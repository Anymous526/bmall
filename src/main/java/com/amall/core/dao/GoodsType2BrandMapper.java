package com.amall.core.dao;

import com.amall.core.bean.GoodsType2Brand;
import com.amall.core.bean.GoodsType2BrandExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsType2BrandMapper {
    int countByExample(GoodsType2BrandExample example);

    int deleteByExample(GoodsType2BrandExample example);

    int insert(GoodsType2Brand record);

    int insertSelective(GoodsType2Brand record);

    List<GoodsType2Brand> selectByExample(GoodsType2BrandExample example);

    int updateByExampleSelective(@Param("record") GoodsType2Brand record, @Param("example") GoodsType2BrandExample example);

    int updateByExample(@Param("record") GoodsType2Brand record, @Param("example") GoodsType2BrandExample example);
}