package com.amall.core.dao;

import com.amall.core.bean.Goods2Photo;
import com.amall.core.bean.Goods2PhotoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Goods2PhotoMapper {
    int countByExample(Goods2PhotoExample example);

    int deleteByExample(Goods2PhotoExample example);

    int insert(Goods2Photo record);

    int insertSelective(Goods2Photo record);

    List<Goods2Photo> selectByExample(Goods2PhotoExample example);

    int updateByExampleSelective(@Param("record") Goods2Photo record, @Param("example") Goods2PhotoExample example);

    int updateByExample(@Param("record") Goods2Photo record, @Param("example") Goods2PhotoExample example);
}