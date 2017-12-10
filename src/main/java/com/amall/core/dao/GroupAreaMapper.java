package com.amall.core.dao;

import com.amall.core.bean.GroupArea;
import com.amall.core.bean.GroupAreaExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface GroupAreaMapper {
    int countByExample(GroupAreaExample example);

    int deleteByExample(GroupAreaExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GroupArea record);

    Long insertSelective(GroupArea record);

    List<GroupArea> selectByExample(GroupAreaExample example);
    List<GroupArea> selectByExampleWithPage(GroupAreaExample example);

    GroupArea selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GroupArea record, @Param("example") GroupAreaExample example);

    int updateByExample(@Param("record") GroupArea record, @Param("example") GroupAreaExample example);

    int updateByPrimaryKeySelective(GroupArea record);

    int updateByPrimaryKey(GroupArea record);
}