package com.amall.core.dao;

import com.amall.core.bean.JmsFail;
import com.amall.core.bean.JmsFailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JmsFailMapper {
    int countByExample(JmsFailExample example);

    int deleteByExample(JmsFailExample example);

    int deleteByPrimaryKey(Long id);

    int insert(JmsFail record);

    int insertSelective(JmsFail record);

    List<JmsFail> selectByExample(JmsFailExample example);

    JmsFail selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") JmsFail record, @Param("example") JmsFailExample example);

    int updateByExample(@Param("record") JmsFail record, @Param("example") JmsFailExample example);

    int updateByPrimaryKeySelective(JmsFail record);

    int updateByPrimaryKey(JmsFail record);
}