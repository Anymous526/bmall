package com.amall.core.dao;

import com.amall.core.bean.Return2Gsp;
import com.amall.core.bean.Return2GspExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Return2GspMapper {
    int countByExample(Return2GspExample example);

    int deleteByExample(Return2GspExample example);

    int insert(Return2Gsp record);

    int insertSelective(Return2Gsp record);

    List<Return2Gsp> selectByExample(Return2GspExample example);

    int updateByExampleSelective(@Param("record") Return2Gsp record, @Param("example") Return2GspExample example);

    int updateByExample(@Param("record") Return2Gsp record, @Param("example") Return2GspExample example);
}