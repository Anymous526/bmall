package com.amall.core.dao;

import com.amall.core.bean.OrderAddress;
import com.amall.core.bean.OrderAddressExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderAddressMapper {
    int countByExample(OrderAddressExample example);

    int deleteByExample(OrderAddressExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrderAddress record);

    Long insertSelective(OrderAddress record);

    List<OrderAddress> selectByExample(OrderAddressExample example);
    List<OrderAddress> selectByExampleWithPage(OrderAddressExample example);

    OrderAddress selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrderAddress record, @Param("example") OrderAddressExample example);

    int updateByExample(@Param("record") OrderAddress record, @Param("example") OrderAddressExample example);

    int updateByPrimaryKeySelective(OrderAddress record);

    int updateByPrimaryKey(OrderAddress record);
}