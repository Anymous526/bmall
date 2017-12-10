package com.amall.core.dao;

import com.amall.core.bean.doulog;
import com.amall.core.bean.doulogExample;
import com.amall.core.bean.userMoneyDetail;
import com.amall.core.bean.userMoneyDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface userMoneyDetailMapper {
    int countByExample(userMoneyDetailExample example);

    int deleteByExample(userMoneyDetailExample example);

    int deleteByPrimaryKey(Long id);

    int insert(userMoneyDetail record);

    int insertSelective(userMoneyDetail record);

    List<userMoneyDetail> selectByExample(userMoneyDetailExample example);
    List<userMoneyDetail> selectByExampleWithBLOBsAndPage(userMoneyDetailExample example);
    
    userMoneyDetail selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") userMoneyDetail record, @Param("example") userMoneyDetailExample example);

    int updateByExample(@Param("record") userMoneyDetail record, @Param("example") userMoneyDetailExample example);

    int updateByPrimaryKeySelective(userMoneyDetail record);

    int updateByPrimaryKey(userMoneyDetail record);
}