package com.amall.core.dao;

import com.amall.core.bean.RechargeBenefit;
import com.amall.core.bean.RechargeBenefitExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RechargeBenefitMapper {
    int countByExample(RechargeBenefitExample example);

    int deleteByExample(RechargeBenefitExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RechargeBenefit record);

    Long insertSelective(RechargeBenefit record);

    List<RechargeBenefit> selectByExample(RechargeBenefitExample example);
    List<RechargeBenefit> selectByExampleAndPage(RechargeBenefitExample example);

    RechargeBenefit selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RechargeBenefit record, @Param("example") RechargeBenefitExample example);

    int updateByExample(@Param("record") RechargeBenefit record, @Param("example") RechargeBenefitExample example);

    int updateByPrimaryKeySelective(RechargeBenefit record);

    int updateByPrimaryKey(RechargeBenefit record);
}