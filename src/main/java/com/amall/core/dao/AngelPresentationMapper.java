package com.amall.core.dao;

import com.amall.core.bean.AngelPresentation;
import com.amall.core.bean.AngelPresentationExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AngelPresentationMapper {
    int countByExample(AngelPresentationExample example);

    int deleteByExample(AngelPresentationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AngelPresentation record);

    Long insertSelective(AngelPresentation record);

    List<AngelPresentation> selectByExample(AngelPresentationExample example);
    List<AngelPresentation> selectByExampleWithPage(AngelPresentationExample example);

    AngelPresentation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AngelPresentation record, @Param("example") AngelPresentationExample example);

    int updateByExample(@Param("record") AngelPresentation record, @Param("example") AngelPresentationExample example);

    int updateByPrimaryKeySelective(AngelPresentation record);

    int updateByPrimaryKey(AngelPresentation record);
}