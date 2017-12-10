package com.amall.core.dao;

import com.amall.core.bean.Document;
import com.amall.core.bean.DocumentExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface DocumentMapper {
    int countByExample(DocumentExample example);

    int deleteByExample(DocumentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Document record);

    Long insertSelective(Document record);

    List<Document> selectByExampleWithBLOBs(DocumentExample example);
    List<Document> selectByExampleWithBLOBsAndPage(DocumentExample example);

    List<Document> selectByExample(DocumentExample example);
    List<Document> selectByExampleWithPage(DocumentExample example);

    Document selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Document record, @Param("example") DocumentExample example);

    int updateByExampleWithBLOBs(@Param("record") Document record, @Param("example") DocumentExample example);

    int updateByExample(@Param("record") Document record, @Param("example") DocumentExample example);

    int updateByPrimaryKeySelective(Document record);

    int updateByPrimaryKeyWithBLOBs(Document record);

    int updateByPrimaryKey(Document record);
}