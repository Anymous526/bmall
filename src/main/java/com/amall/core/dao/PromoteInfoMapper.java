package com.amall.core.dao;

import com.amall.core.bean.PromoteInfo;
import com.amall.core.bean.PromoteInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PromoteInfoMapper {
    int countByExample(PromoteInfoExample example);

    int deleteByExample(PromoteInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PromoteInfo record);

    Long insertSelective(PromoteInfo record);

    List<PromoteInfo> selectByExample(PromoteInfoExample example);

    PromoteInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PromoteInfo record, @Param("example") PromoteInfoExample example);

    int updateByExample(@Param("record") PromoteInfo record, @Param("example") PromoteInfoExample example);

    int updateByPrimaryKeySelective(PromoteInfo record);

    int updateByPrimaryKey(PromoteInfo record);
}