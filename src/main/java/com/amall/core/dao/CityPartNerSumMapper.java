package com.amall.core.dao;

import com.amall.core.bean.CityPartNerSum;
import com.amall.core.bean.CityPartNerSumExample;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface CityPartNerSumMapper {
    int countByExample(CityPartNerSumExample example);

    int deleteByExample(CityPartNerSumExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CityPartNerSum record);

    int insertSelective(CityPartNerSum record);

    List<CityPartNerSum> selectByExample(CityPartNerSumExample example);

    CityPartNerSum selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CityPartNerSum record, @Param("example") CityPartNerSumExample example);

    int updateByExample(@Param("record") CityPartNerSum record, @Param("example") CityPartNerSumExample example);

    int updateByPrimaryKeySelective(CityPartNerSum record);

    int updateByPrimaryKey(CityPartNerSum record);
    
    List<CityPartNerSum> selectByuserId(com.amall.core.bean.CityPartNerSum userid);
    
    List<CityPartNerSum> selectyueji(HashMap<? extends Object,? extends Object> map);
}