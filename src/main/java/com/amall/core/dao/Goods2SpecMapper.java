package com.amall.core.dao;

import com.amall.core.bean.Goods2Spec;
import com.amall.core.bean.Goods2SpecExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Goods2SpecMapper {
    int countByExample(Goods2SpecExample example);

    int deleteByExample(Goods2SpecExample example);

    int insert(Goods2Spec record);

    int insertSelective(Goods2Spec record);

    List<Goods2Spec> selectByExample(Goods2SpecExample example);

    int updateByExampleSelective(@Param("record") Goods2Spec record, @Param("example") Goods2SpecExample example);

    int updateByExample(@Param("record") Goods2Spec record, @Param("example") Goods2SpecExample example);
}