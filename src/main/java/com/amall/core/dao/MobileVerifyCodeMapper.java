package com.amall.core.dao;

import com.amall.core.bean.MobileVerifyCode;
import com.amall.core.bean.MobileVerifyCodeExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface MobileVerifyCodeMapper {
    int countByExample(MobileVerifyCodeExample example);

    int deleteByExample(MobileVerifyCodeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MobileVerifyCode record);

    Long insertSelective(MobileVerifyCode record);

    List<MobileVerifyCode> selectByExample(MobileVerifyCodeExample example);
    List<MobileVerifyCode> selectByExampleWithPage(MobileVerifyCodeExample example);

    MobileVerifyCode selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MobileVerifyCode record, @Param("example") MobileVerifyCodeExample example);

    int updateByExample(@Param("record") MobileVerifyCode record, @Param("example") MobileVerifyCodeExample example);

    int updateByPrimaryKeySelective(MobileVerifyCode record);

    int updateByPrimaryKey(MobileVerifyCode record);
}