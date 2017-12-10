package com.amall.core.dao;

import com.amall.core.bean.ShopBenefit;
import com.amall.core.bean.ShopBenefitExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShopBenefitMapper {
    int countByExample(ShopBenefitExample example);

    int deleteByExample(ShopBenefitExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShopBenefit record);

    Long insertSelective(ShopBenefit record);

    List<ShopBenefit> selectByExample(ShopBenefitExample example);
    List<ShopBenefit> selectByExampleAndPage(ShopBenefitExample example);

    ShopBenefit selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShopBenefit record, @Param("example") ShopBenefitExample example);

    int updateByExample(@Param("record") ShopBenefit record, @Param("example") ShopBenefitExample example);

    int updateByPrimaryKeySelective(ShopBenefit record);

    int updateByPrimaryKey(ShopBenefit record);
}