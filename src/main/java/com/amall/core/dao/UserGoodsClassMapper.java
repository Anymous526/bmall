package com.amall.core.dao;

import com.amall.core.bean.UserGoodsClass;
import com.amall.core.bean.UserGoodsClassExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface UserGoodsClassMapper {
    int countByExample(UserGoodsClassExample example);

    int deleteByExample(UserGoodsClassExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserGoodsClass record);

    Long insertSelective(UserGoodsClass record);

    List<UserGoodsClass> selectByExample(UserGoodsClassExample example);
    List<UserGoodsClass> selectByExampleWithPage(UserGoodsClassExample example);

    UserGoodsClass selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserGoodsClass record, @Param("example") UserGoodsClassExample example);

    int updateByExample(@Param("record") UserGoodsClass record, @Param("example") UserGoodsClassExample example);

    int updateByPrimaryKeySelective(UserGoodsClass record);

    int updateByPrimaryKey(UserGoodsClass record);
}