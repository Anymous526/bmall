package com.amall.core.dao;

import com.amall.core.bean.UserCashDepositLog;
import com.amall.core.bean.UserCashDepositLogExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserCashDepositLogMapper {
    int countByExample(UserCashDepositLogExample example);

    int deleteByExample(UserCashDepositLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserCashDepositLog record);

    int insertSelective(UserCashDepositLog record);

    List<UserCashDepositLog> selectByExample(UserCashDepositLogExample example);
    List<UserCashDepositLog> selectByExampleAndPage(UserCashDepositLogExample example);

    UserCashDepositLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserCashDepositLog record, @Param("example") UserCashDepositLogExample example);

    int updateByExample(@Param("record") UserCashDepositLog record, @Param("example") UserCashDepositLogExample example);

    int updateByPrimaryKeySelective(UserCashDepositLog record);

    int updateByPrimaryKey(UserCashDepositLog record);
}