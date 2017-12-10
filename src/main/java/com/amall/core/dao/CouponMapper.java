package com.amall.core.dao;

import com.amall.core.bean.Coupon;
import com.amall.core.bean.CouponExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface CouponMapper {
    int countByExample(CouponExample example);

    int deleteByExample(CouponExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Coupon record);

    Long insertSelective(Coupon record);

    List<Coupon> selectByExample(CouponExample example);
    List<Coupon> selectByExampleWithPage(CouponExample example);

    Coupon selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Coupon record, @Param("example") CouponExample example);

    int updateByExample(@Param("record") Coupon record, @Param("example") CouponExample example);

    int updateByPrimaryKeySelective(Coupon record);

    int updateByPrimaryKey(Coupon record);
}