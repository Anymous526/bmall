package com.amall.core.dao;

import com.amall.core.bean.StoreVisit;
import com.amall.core.bean.StoreVisitExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StoreVisitMapper {
    int countByExample(StoreVisitExample example);

    int deleteByExample(StoreVisitExample example);

    int deleteByPrimaryKey(Long id);

    int insert(StoreVisit record);

    int insertSelective(StoreVisit record);

    List<StoreVisit> selectByExample(StoreVisitExample example);

    StoreVisit selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") StoreVisit record, @Param("example") StoreVisitExample example);

    int updateByExample(@Param("record") StoreVisit record, @Param("example") StoreVisitExample example);

    int updateByPrimaryKeySelective(StoreVisit record);

    int updateByPrimaryKey(StoreVisit record);
}