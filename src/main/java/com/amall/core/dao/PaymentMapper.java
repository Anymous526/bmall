package com.amall.core.dao;

import com.amall.core.bean.Payment;
import com.amall.core.bean.PaymentExample;
import com.amall.core.bean.PaymentWithBLOBs;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface PaymentMapper {
    int countByExample(PaymentExample example);

    int deleteByExample(PaymentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PaymentWithBLOBs record);

    Long insertSelective(PaymentWithBLOBs record);

    List<PaymentWithBLOBs> selectByExampleWithBLOBs(PaymentExample example);
    List<PaymentWithBLOBs> selectByExampleWithBLOBsAndPage(PaymentExample example);

    List<Payment> selectByExample(PaymentExample example);
    List<Payment> selectByExampleWithPage(PaymentExample example);

    PaymentWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PaymentWithBLOBs record, @Param("example") PaymentExample example);

    int updateByExampleWithBLOBs(@Param("record") PaymentWithBLOBs record, @Param("example") PaymentExample example);

    int updateByExample(@Param("record") Payment record, @Param("example") PaymentExample example);

    int updateByPrimaryKeySelective(PaymentWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(PaymentWithBLOBs record);

    int updateByPrimaryKey(Payment record);
}