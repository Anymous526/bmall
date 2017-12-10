package com.amall.core.dao;

import com.amall.core.bean.CashDeposit;
import com.amall.core.bean.CashDepositExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CashDepositMapper {
    int countByExample(CashDepositExample example);

    int deleteByExample(CashDepositExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CashDeposit record);

    int insertSelective(CashDeposit record);

    List<CashDeposit> selectByExample(CashDepositExample example);
    
    List<CashDeposit> selectByExampleWithPage(CashDepositExample example);

    CashDeposit selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CashDeposit record, @Param("example") CashDepositExample example);

    int updateByExample(@Param("record") CashDeposit record, @Param("example") CashDepositExample example);

    int updateByPrimaryKeySelective(CashDeposit record);

    int updateByPrimaryKey(CashDeposit record);
}