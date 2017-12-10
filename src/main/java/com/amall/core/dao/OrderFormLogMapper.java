package com.amall.core.dao;

import com.amall.core.bean.OrderFormLog;
import com.amall.core.bean.OrderFormLogExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface OrderFormLogMapper {
    int countByExample(OrderFormLogExample example);

    int deleteByExample(OrderFormLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrderFormLog record);

    Long insertSelective(OrderFormLog record);

    List<OrderFormLog> selectByExampleWithBLOBs(OrderFormLogExample example);
    List<OrderFormLog> selectByExampleWithBLOBsAndPage(OrderFormLogExample example);

    List<OrderFormLog> selectByExample(OrderFormLogExample example);
    List<OrderFormLog> selectByExampleWithPage(OrderFormLogExample example);

    OrderFormLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrderFormLog record, @Param("example") OrderFormLogExample example);

    int updateByExampleWithBLOBs(@Param("record") OrderFormLog record, @Param("example") OrderFormLogExample example);

    int updateByExample(@Param("record") OrderFormLog record, @Param("example") OrderFormLogExample example);

    int updateByPrimaryKeySelective(OrderFormLog record);

    int updateByPrimaryKeyWithBLOBs(OrderFormLog record);

    int updateByPrimaryKey(OrderFormLog record);
}