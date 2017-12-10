package com.amall.core.dao;

import com.amall.core.bean.StoreNavigation;
import com.amall.core.bean.StoreNavigationExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface StoreNavigationMapper {
    int countByExample(StoreNavigationExample example);

    int deleteByExample(StoreNavigationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(StoreNavigation record);

    Long insertSelective(StoreNavigation record);

    List<StoreNavigation> selectByExampleWithBLOBs(StoreNavigationExample example);
    List<StoreNavigation> selectByExampleWithBLOBsAndPage(StoreNavigationExample example);

    List<StoreNavigation> selectByExample(StoreNavigationExample example);
    List<StoreNavigation> selectByExampleWithPage(StoreNavigationExample example);

    StoreNavigation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") StoreNavigation record, @Param("example") StoreNavigationExample example);

    int updateByExampleWithBLOBs(@Param("record") StoreNavigation record, @Param("example") StoreNavigationExample example);

    int updateByExample(@Param("record") StoreNavigation record, @Param("example") StoreNavigationExample example);

    int updateByPrimaryKeySelective(StoreNavigation record);

    int updateByPrimaryKeyWithBLOBs(StoreNavigation record);

    int updateByPrimaryKey(StoreNavigation record);
}