package com.amall.core.dao;

import com.amall.core.bean.Advert;
import com.amall.core.bean.AdvertExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface AdvertMapper {
    int countByExample(AdvertExample example);

    int deleteByExample(AdvertExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Advert record);

    Long insertSelective(Advert record);

    List<Advert> selectByExample(AdvertExample example);
    List<Advert> selectByExampleWithPage(AdvertExample example);

    Advert selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Advert record, @Param("example") AdvertExample example);

    int updateByExample(@Param("record") Advert record, @Param("example") AdvertExample example);

    int updateByPrimaryKeySelective(Advert record);

    int updateByPrimaryKey(Advert record);
}