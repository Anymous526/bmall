package com.amall.core.dao;

import com.amall.core.bean.GoodsType2Spec;
import com.amall.core.bean.GoodsType2SpecExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsType2SpecMapper {
    int countByExample(GoodsType2SpecExample example);

    int deleteByExample(GoodsType2SpecExample example);

    int insert(GoodsType2Spec record);

    int insertSelective(GoodsType2Spec record);

    List<GoodsType2Spec> selectByExample(GoodsType2SpecExample example);

    int updateByExampleSelective(@Param("record") GoodsType2Spec record, @Param("example") GoodsType2SpecExample example);

    int updateByExample(@Param("record") GoodsType2Spec record, @Param("example") GoodsType2SpecExample example);
}