package com.amall.core.dao;

import com.amall.core.bean.WeekBenifitDetail;
import com.amall.core.bean.WeekBenifitDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WeekBenifitDetailMapper {
    int countByExample(WeekBenifitDetailExample example);

    int deleteByExample(WeekBenifitDetailExample example);

    int deleteByPrimaryKey(Long id);

    int insert(WeekBenifitDetail record);

    int insertSelective(WeekBenifitDetail record);

    List<WeekBenifitDetail> selectByExample(WeekBenifitDetailExample example);

    WeekBenifitDetail selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WeekBenifitDetail record, @Param("example") WeekBenifitDetailExample example);

    int updateByExample(@Param("record") WeekBenifitDetail record, @Param("example") WeekBenifitDetailExample example);

    int updateByPrimaryKeySelective(WeekBenifitDetail record);

    int updateByPrimaryKey(WeekBenifitDetail record);
}