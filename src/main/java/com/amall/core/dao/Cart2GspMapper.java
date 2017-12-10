package com.amall.core.dao;

import com.amall.core.bean.Cart2Gsp;
import com.amall.core.bean.Cart2GspExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Cart2GspMapper {
    int countByExample(Cart2GspExample example);

    int deleteByExample(Cart2GspExample example);

    int insert(Cart2Gsp record);

    int insertSelective(Cart2Gsp record);

    List<Cart2Gsp> selectByExample(Cart2GspExample example);

    int updateByExampleSelective(@Param("record") Cart2Gsp record, @Param("example") Cart2GspExample example);

    int updateByExample(@Param("record") Cart2Gsp record, @Param("example") Cart2GspExample example);
}