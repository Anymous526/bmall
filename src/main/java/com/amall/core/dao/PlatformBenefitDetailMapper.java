package com.amall.core.dao;

import com.amall.core.bean.PlatformBenefitDetail;
import com.amall.core.bean.PlatformBenefitDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PlatformBenefitDetailMapper
{

	int countByExample (PlatformBenefitDetailExample example);

	int deleteByExample (PlatformBenefitDetailExample example);

	int deleteByPrimaryKey (Long id);

	int insert (PlatformBenefitDetail record);

	Long insertSelective (PlatformBenefitDetail record);

	List <PlatformBenefitDetail> selectByExample (PlatformBenefitDetailExample example);

	List <PlatformBenefitDetail> selectByExampleAndPage (PlatformBenefitDetailExample example);

	PlatformBenefitDetail selectByPrimaryKey (Long id);

	int updateByExampleSelective (@Param("record") PlatformBenefitDetail record , @Param("example") PlatformBenefitDetailExample example);

	int updateByExample (@Param("record") PlatformBenefitDetail record , @Param("example") PlatformBenefitDetailExample example);

	int updateByPrimaryKeySelective (PlatformBenefitDetail record);

	int updateByPrimaryKey (PlatformBenefitDetail record);
}