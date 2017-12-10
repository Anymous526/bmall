package com.amall.core.dao;

import com.amall.core.bean.DouDetail;
import com.amall.core.bean.DouDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DouDetailMapper {
    int countByExample(DouDetailExample example);

    int deleteByExample(DouDetailExample example);

    int insert(DouDetail record);

    int insertSelective(DouDetail record);

    List<DouDetail> selectByExample(DouDetailExample example);

    int updateByExampleSelective(@Param("record") DouDetail record, @Param("example") DouDetailExample example);

    int updateByExample(@Param("record") DouDetail record, @Param("example") DouDetailExample example);
}