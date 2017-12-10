package com.amall.core.dao;

import com.amall.core.bean.ArticleClass;
import com.amall.core.bean.ArticleClassExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ArticleClassMapper {
    int countByExample(ArticleClassExample example);

    int deleteByExample(ArticleClassExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ArticleClass record);

    Long insertSelective(ArticleClass record);

    List<ArticleClass> selectByExample(ArticleClassExample example);
    List<ArticleClass> selectByExampleWithPage(ArticleClassExample example);

    ArticleClass selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ArticleClass record, @Param("example") ArticleClassExample example);

    int updateByExample(@Param("record") ArticleClass record, @Param("example") ArticleClassExample example);

    int updateByPrimaryKeySelective(ArticleClass record);

    int updateByPrimaryKey(ArticleClass record);
}