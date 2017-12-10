package com.amall.core.dao;

import com.amall.core.bean.PromoteDreamSet;
import com.amall.core.bean.PromoteDreamSetExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PromoteDreamSetMapper {
    int countByExample(PromoteDreamSetExample example);

    int deleteByExample(PromoteDreamSetExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PromoteDreamSet record);

    int insertSelective(PromoteDreamSet record);

    List<PromoteDreamSet> selectByExample(PromoteDreamSetExample example);

    PromoteDreamSet selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PromoteDreamSet record, @Param("example") PromoteDreamSetExample example);

    int updateByExample(@Param("record") PromoteDreamSet record, @Param("example") PromoteDreamSetExample example);

    int updateByPrimaryKeySelective(PromoteDreamSet record);

    int updateByPrimaryKey(PromoteDreamSet record);
}