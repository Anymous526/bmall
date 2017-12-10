package com.amall.core.dao;

import com.amall.core.bean.Article;
import com.amall.core.bean.ArticleExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ArticleMapper {
    int countByExample(ArticleExample example);

    int deleteByExample(ArticleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Article record);

    Long insertSelective(Article record);

    List<Article> selectByExampleWithBLOBs(ArticleExample example);
    List<Article> selectByExampleWithBLOBsAndPage(ArticleExample example);

    List<Article> selectByExample(ArticleExample example);
    List<Article> selectByExampleWithPage(ArticleExample example);

    Article selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Article record, @Param("example") ArticleExample example);

    int updateByExampleWithBLOBs(@Param("record") Article record, @Param("example") ArticleExample example);

    int updateByExample(@Param("record") Article record, @Param("example") ArticleExample example);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKeyWithBLOBs(Article record);

    int updateByPrimaryKey(Article record);
}