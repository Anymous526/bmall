package com.amall.core.dao;

import com.amall.core.bean.Bargain;
import com.amall.core.bean.BargainExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface BargainMapper {
    int countByExample(BargainExample example);

    int deleteByExample(BargainExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Bargain record);

    Long insertSelective(Bargain record);

    List<Bargain> selectByExampleWithBLOBs(BargainExample example);
    List<Bargain> selectByExampleWithBLOBsAndPage(BargainExample example);

    List<Bargain> selectByExample(BargainExample example);
    List<Bargain> selectByExampleWithPage(BargainExample example);

    Bargain selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Bargain record, @Param("example") BargainExample example);

    int updateByExampleWithBLOBs(@Param("record") Bargain record, @Param("example") BargainExample example);

    int updateByExample(@Param("record") Bargain record, @Param("example") BargainExample example);

    int updateByPrimaryKeySelective(Bargain record);

    int updateByPrimaryKeyWithBLOBs(Bargain record);

    int updateByPrimaryKey(Bargain record);
}