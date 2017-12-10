package com.amall.core.dao;

import com.amall.core.bean.GroupPriceRange;
import com.amall.core.bean.GroupPriceRangeExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface GroupPriceRangeMapper {
    int countByExample(GroupPriceRangeExample example);

    int deleteByExample(GroupPriceRangeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GroupPriceRange record);

    Long insertSelective(GroupPriceRange record);

    List<GroupPriceRange> selectByExample(GroupPriceRangeExample example);
    List<GroupPriceRange> selectByExampleWithPage(GroupPriceRangeExample example);

    GroupPriceRange selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GroupPriceRange record, @Param("example") GroupPriceRangeExample example);

    int updateByExample(@Param("record") GroupPriceRange record, @Param("example") GroupPriceRangeExample example);

    int updateByPrimaryKeySelective(GroupPriceRange record);

    int updateByPrimaryKey(GroupPriceRange record);
}