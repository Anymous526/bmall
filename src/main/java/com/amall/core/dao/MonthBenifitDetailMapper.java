package com.amall.core.dao;

import com.amall.core.bean.MonthBenifitDetail;
import com.amall.core.bean.MonthBenifitDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MonthBenifitDetailMapper {
    int countByExample(MonthBenifitDetailExample example);

    int deleteByExample(MonthBenifitDetailExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MonthBenifitDetail record);

    int insertSelective(MonthBenifitDetail record);

    List<MonthBenifitDetail> selectByExample(MonthBenifitDetailExample example);

    MonthBenifitDetail selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MonthBenifitDetail record, @Param("example") MonthBenifitDetailExample example);

    int updateByExample(@Param("record") MonthBenifitDetail record, @Param("example") MonthBenifitDetailExample example);

    int updateByPrimaryKeySelective(MonthBenifitDetail record);

    int updateByPrimaryKey(MonthBenifitDetail record);
}