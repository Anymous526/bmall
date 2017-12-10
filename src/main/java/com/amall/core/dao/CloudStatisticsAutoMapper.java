package com.amall.core.dao;

import com.amall.core.bean.CloudStatisticsAuto;
import com.amall.core.bean.CloudStatisticsAutoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CloudStatisticsAutoMapper {
    int countByExample(CloudStatisticsAutoExample example);

    int deleteByExample(CloudStatisticsAutoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CloudStatisticsAuto record);

    int insertSelective(CloudStatisticsAuto record);

    List<CloudStatisticsAuto> selectByExample(CloudStatisticsAutoExample example);

    CloudStatisticsAuto selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CloudStatisticsAuto record, @Param("example") CloudStatisticsAutoExample example);

    int updateByExample(@Param("record") CloudStatisticsAuto record, @Param("example") CloudStatisticsAutoExample example);

    int updateByPrimaryKeySelective(CloudStatisticsAuto record);

    int updateByPrimaryKey(CloudStatisticsAuto record);
}