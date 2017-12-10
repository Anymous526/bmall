package com.amall.core.dao;

import com.amall.core.bean.CloudStatistics;
import com.amall.core.bean.CloudStatisticsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CloudStatisticsMapper {
    int countByExample(CloudStatisticsExample example);

    int deleteByExample(CloudStatisticsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CloudStatistics record);

    int insertSelective(CloudStatistics record);

    List<CloudStatistics> selectByExample(CloudStatisticsExample example);

    CloudStatistics selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CloudStatistics record, @Param("example") CloudStatisticsExample example);

    int updateByExample(@Param("record") CloudStatistics record, @Param("example") CloudStatisticsExample example);

    int updateByPrimaryKeySelective(CloudStatistics record);

    int updateByPrimaryKey(CloudStatistics record);
}