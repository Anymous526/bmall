package com.amall.core.dao;

import com.amall.core.bean.Favorite;
import com.amall.core.bean.FavoriteExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface FavoriteMapper {
    int countByExample(FavoriteExample example);

    int deleteByExample(FavoriteExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Favorite record);

    Long insertSelective(Favorite record);

    List<Favorite> selectByExample(FavoriteExample example);
    List<Favorite> selectByExampleWithPage(FavoriteExample example);

    Favorite selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Favorite record, @Param("example") FavoriteExample example);

    int updateByExample(@Param("record") Favorite record, @Param("example") FavoriteExample example);

    int updateByPrimaryKeySelective(Favorite record);

    int updateByPrimaryKey(Favorite record);
}