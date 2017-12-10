package com.amall.core.dao;

import com.amall.core.bean.RechargeLog;
import com.amall.core.bean.RechargeLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RechargeLogMapper {
    int countByExample(RechargeLogExample example);

    int deleteByExample(RechargeLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RechargeLog record);

    Long insertSelective(RechargeLog record);

    List<RechargeLog> selectByExample(RechargeLogExample example);
    List<RechargeLog> selectByExampleAndPage(RechargeLogExample example);

    RechargeLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RechargeLog record, @Param("example") RechargeLogExample example);

    int updateByExample(@Param("record") RechargeLog record, @Param("example") RechargeLogExample example);

    int updateByPrimaryKeySelective(RechargeLog record);

    int updateByPrimaryKey(RechargeLog record);
}