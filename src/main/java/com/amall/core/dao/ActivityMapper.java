package com.amall.core.dao;

import com.amall.core.bean.Activity;
import com.amall.core.bean.ActivityExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ActivityMapper {
    int countByExample(ActivityExample example);

    int deleteByExample(ActivityExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Activity record);

    Long insertSelective(Activity record);

    List<Activity> selectByExampleWithBLOBs(ActivityExample example);
    List<Activity> selectByExampleWithBLOBsAndPage(ActivityExample example);

    List<Activity> selectByExample(ActivityExample example);
    List<Activity> selectByExampleWithPage(ActivityExample example);

    Activity selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Activity record, @Param("example") ActivityExample example);

    int updateByExampleWithBLOBs(@Param("record") Activity record, @Param("example") ActivityExample example);

    int updateByExample(@Param("record") Activity record, @Param("example") ActivityExample example);

    int updateByPrimaryKeySelective(Activity record);

    int updateByPrimaryKeyWithBLOBs(Activity record);

    int updateByPrimaryKey(Activity record);
}