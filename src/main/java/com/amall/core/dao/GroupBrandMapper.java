package com.amall.core.dao;

import com.amall.core.bean.GroupBrand;
import com.amall.core.bean.GroupBrandExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GroupBrandMapper {
    int countByExample(GroupBrandExample example);

    int deleteByExample(GroupBrandExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GroupBrand record);

    Long insertSelective(GroupBrand record);

    List<GroupBrand> selectByExample(GroupBrandExample example);

    GroupBrand selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GroupBrand record, @Param("example") GroupBrandExample example);

    int updateByExample(@Param("record") GroupBrand record, @Param("example") GroupBrandExample example);

    int updateByPrimaryKeySelective(GroupBrand record);

    int updateByPrimaryKey(GroupBrand record);
    
    List<GroupBrand> selectByExampleWithPage(GroupBrandExample example);//增加分页查询
    
}