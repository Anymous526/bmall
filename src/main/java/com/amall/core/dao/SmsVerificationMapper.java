package com.amall.core.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.amall.core.bean.SmsVerification;
import com.amall.core.bean.SmsVerificationExample;

public interface SmsVerificationMapper {
    int countByExample(SmsVerificationExample example);

    int deleteByExample(SmsVerificationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SmsVerification record);

    int insertSelective(SmsVerification record);

    List<SmsVerification> selectByExample(SmsVerificationExample example);

    SmsVerification selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SmsVerification record, @Param("example") SmsVerificationExample example);

    int updateByExample(@Param("record") SmsVerification record, @Param("example") SmsVerificationExample example);

    int updateByPrimaryKeySelective(SmsVerification record);

    int updateByPrimaryKey(SmsVerification record);
}