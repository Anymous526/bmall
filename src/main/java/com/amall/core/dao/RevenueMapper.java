package com.amall.core.dao;


import com.amall.core.bean.Revenue;
import com.amall.core.bean.RevenueExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RevenueMapper {
    int countByExample(RevenueExample example);

    int deleteByExample(RevenueExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Revenue record);

    int insertSelective(Revenue record);

    List<Revenue> selectByExample(RevenueExample example);
    List<Revenue> selectByExampleWithPage(RevenueExample example);
    Revenue selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Revenue record, @Param("example") RevenueExample example);

    int updateByExample(@Param("record") Revenue record, @Param("example") RevenueExample example);

    int updateByPrimaryKeySelective(Revenue record);

    int updateByPrimaryKey(Revenue record);
}