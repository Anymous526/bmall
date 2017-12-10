package com.amall.core.dao;

import com.amall.core.bean.PlatformEarningDetail;
import com.amall.core.bean.PlatformEarningDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PlatformEarningDetailMapper {
    int countByExample(PlatformEarningDetailExample example);

    int deleteByExample(PlatformEarningDetailExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PlatformEarningDetail record);

    Long insertSelective(PlatformEarningDetail record);

    List<PlatformEarningDetail> selectByExample(PlatformEarningDetailExample example);
    List<PlatformEarningDetail> selectByExampleAndPage(PlatformEarningDetailExample example);

    PlatformEarningDetail selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PlatformEarningDetail record, @Param("example") PlatformEarningDetailExample example);

    int updateByExample(@Param("record") PlatformEarningDetail record, @Param("example") PlatformEarningDetailExample example);

    int updateByPrimaryKeySelective(PlatformEarningDetail record);

    int updateByPrimaryKey(PlatformEarningDetail record);
}