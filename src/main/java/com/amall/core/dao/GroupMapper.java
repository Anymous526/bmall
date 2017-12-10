package com.amall.core.dao;

import com.amall.core.bean.Group;
import com.amall.core.bean.GroupExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface GroupMapper {
    int countByExample(GroupExample example);

    int deleteByExample(GroupExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Group record);

    Long insertSelective(Group record);

    List<Group> selectByExample(GroupExample example);
    List<Group> selectByExampleWithPage(GroupExample example);

    Group selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Group record, @Param("example") GroupExample example);

    int updateByExample(@Param("record") Group record, @Param("example") GroupExample example);

    int updateByPrimaryKeySelective(Group record);

    int updateByPrimaryKey(Group record);
}