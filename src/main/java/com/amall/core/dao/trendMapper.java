package com.amall.core.dao;

import com.amall.core.bean.trend;
import com.amall.core.bean.trendExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface trendMapper {
    int countByExample(trendExample example);

    int deleteByExample(trendExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(trend record);

    int insertSelective(trend record);

    List<trend> selectByExample(trendExample example);

    trend selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") trend record, @Param("example") trendExample example);

    int updateByExample(@Param("record") trend record, @Param("example") trendExample example);

    int updateByPrimaryKeySelective(trend record);

    int updateByPrimaryKey(trend record);
}