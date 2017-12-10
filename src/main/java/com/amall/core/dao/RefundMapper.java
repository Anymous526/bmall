package com.amall.core.dao;

import com.amall.core.bean.Refund;
import com.amall.core.bean.RefundExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface RefundMapper {
    int countByExample(RefundExample example);

    int deleteByExample(RefundExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Refund record);

    Long insertSelective(Refund record);

    List<Refund> selectByExample(RefundExample example);
    List<Refund> selectByExampleWithPage(RefundExample example);

    Refund selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Refund record, @Param("example") RefundExample example);

    int updateByExample(@Param("record") Refund record, @Param("example") RefundExample example);

    int updateByPrimaryKeySelective(Refund record);

    int updateByPrimaryKey(Refund record);
}