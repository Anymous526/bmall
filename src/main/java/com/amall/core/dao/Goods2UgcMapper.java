package com.amall.core.dao;

import com.amall.core.bean.Goods2Ugc;
import com.amall.core.bean.Goods2UgcExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Goods2UgcMapper {
    int countByExample(Goods2UgcExample example);

    int deleteByExample(Goods2UgcExample example);

    int insert(Goods2Ugc record);

    int insertSelective(Goods2Ugc record);

    List<Goods2Ugc> selectByExample(Goods2UgcExample example);

    int updateByExampleSelective(@Param("record") Goods2Ugc record, @Param("example") Goods2UgcExample example);

    int updateByExample(@Param("record") Goods2Ugc record, @Param("example") Goods2UgcExample example);
}