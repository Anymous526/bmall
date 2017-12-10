package com.amall.core.dao;

import com.amall.core.bean.DeliveryLog;
import com.amall.core.bean.DeliveryLogExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface DeliveryLogMapper {
    int countByExample(DeliveryLogExample example);

    int deleteByExample(DeliveryLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DeliveryLog record);

    Long insertSelective(DeliveryLog record);

    List<DeliveryLog> selectByExample(DeliveryLogExample example);

    List<DeliveryLog> selectByExampleWithPage(DeliveryLogExample example);
    DeliveryLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DeliveryLog record, @Param("example") DeliveryLogExample example);

    int updateByExample(@Param("record") DeliveryLog record, @Param("example") DeliveryLogExample example);

    int updateByPrimaryKeySelective(DeliveryLog record);

    int updateByPrimaryKey(DeliveryLog record);
}