package com.amall.core.dao;

import com.amall.core.bean.StoreCount;
import com.amall.core.bean.StoreCountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StoreCountMapper {
    int countByExample(StoreCountExample example);

    int deleteByExample(StoreCountExample example);

    int deleteByPrimaryKey(Long id);

    int insert(StoreCount record);

    Long insertSelective(StoreCount record);

    List<StoreCount> selectByExample(StoreCountExample example);

    StoreCount selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") StoreCount record, @Param("example") StoreCountExample example);

    int updateByExample(@Param("record") StoreCount record, @Param("example") StoreCountExample example);

    int updateByPrimaryKeySelective(StoreCount record);

    int updateByPrimaryKey(StoreCount record);
}