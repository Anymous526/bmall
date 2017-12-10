package com.amall.core.dao;

import com.amall.core.bean.MutualBenefit;
import com.amall.core.bean.MutualBenefitExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MutualBenefitMapper {
    int countByExample(MutualBenefitExample example);

    int deleteByExample(MutualBenefitExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MutualBenefit record);

    Long insertSelective(MutualBenefit record);

    List<MutualBenefit> selectByExample(MutualBenefitExample example);
    List<MutualBenefit> selectByExampleAndPage(MutualBenefitExample example);

    MutualBenefit selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MutualBenefit record, @Param("example") MutualBenefitExample example);

    int updateByExample(@Param("record") MutualBenefit record, @Param("example") MutualBenefitExample example);

    int updateByPrimaryKeySelective(MutualBenefit record);

    int updateByPrimaryKey(MutualBenefit record);
}