package com.amall.core.dao;

import com.amall.core.bean.Dynamic;
import com.amall.core.bean.DynamicExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface DynamicMapper {
    int countByExample(DynamicExample example);

    int deleteByExample(DynamicExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Dynamic record);

    Long insertSelective(Dynamic record);

    List<Dynamic> selectByExampleWithBLOBs(DynamicExample example);
    List<Dynamic> selectByExampleWithBLOBsAndPage(DynamicExample example);

    List<Dynamic> selectByExample(DynamicExample example);
    List<Dynamic> selectByExampleWithPage(DynamicExample example);

    Dynamic selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Dynamic record, @Param("example") DynamicExample example);

    int updateByExampleWithBLOBs(@Param("record") Dynamic record, @Param("example") DynamicExample example);

    int updateByExample(@Param("record") Dynamic record, @Param("example") DynamicExample example);

    int updateByPrimaryKeySelective(Dynamic record);

    int updateByPrimaryKeyWithBLOBs(Dynamic record);

    int updateByPrimaryKey(Dynamic record);
}