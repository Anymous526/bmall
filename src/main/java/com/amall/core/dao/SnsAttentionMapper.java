package com.amall.core.dao;

import com.amall.core.bean.SnsAttention;
import com.amall.core.bean.SnsAttentionExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SnsAttentionMapper {
    int countByExample(SnsAttentionExample example);

    int deleteByExample(SnsAttentionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SnsAttention record);

    Long insertSelective(SnsAttention record);

    List<SnsAttention> selectByExample(SnsAttentionExample example);
    List<SnsAttention> selectByExampleWithPage(SnsAttentionExample example);

    SnsAttention selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SnsAttention record, @Param("example") SnsAttentionExample example);

    int updateByExample(@Param("record") SnsAttention record, @Param("example") SnsAttentionExample example);

    int updateByPrimaryKeySelective(SnsAttention record);

    int updateByPrimaryKey(SnsAttention record);
}