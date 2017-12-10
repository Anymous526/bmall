package com.amall.core.dao;

import com.amall.core.bean.Res;
import com.amall.core.bean.ResExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ResMapper {
    int countByExample(ResExample example);

    int deleteByExample(ResExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Res record);

    Long insertSelective(Res record);

    List<Res> selectByExample(ResExample example);
    List<Res> selectByExampleWithPage(ResExample example);

    Res selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Res record, @Param("example") ResExample example);

    int updateByExample(@Param("record") Res record, @Param("example") ResExample example);

    int updateByPrimaryKeySelective(Res record);

    int updateByPrimaryKey(Res record);
}