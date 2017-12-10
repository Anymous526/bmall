package com.amall.core.dao;

import com.amall.core.bean.StoreSlide;
import com.amall.core.bean.StoreSlideExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface StoreSlideMapper {
    int countByExample(StoreSlideExample example);

    int deleteByExample(StoreSlideExample example);

    int deleteByPrimaryKey(Long id);

    int insert(StoreSlide record);

    Long insertSelective(StoreSlide record);

    List<StoreSlide> selectByExample(StoreSlideExample example);
    List<StoreSlide> selectByExampleWithPage(StoreSlideExample example);

    StoreSlide selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") StoreSlide record, @Param("example") StoreSlideExample example);

    int updateByExample(@Param("record") StoreSlide record, @Param("example") StoreSlideExample example);

    int updateByPrimaryKeySelective(StoreSlide record);

    int updateByPrimaryKey(StoreSlide record);
}