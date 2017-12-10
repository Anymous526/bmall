package com.amall.core.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.amall.core.bean.Evaluate;
import com.amall.core.bean.EvaluateExample;
import com.amall.core.bean.EvaluateWithBLOBs;

public interface EvaluateMapper {
    int countByExample(EvaluateExample example);

    int deleteByExample(EvaluateExample example);

    int deleteByPrimaryKey(Long id);

    int insert(EvaluateWithBLOBs record);

    Long insertSelective(EvaluateWithBLOBs record);

    List<EvaluateWithBLOBs> selectByExampleWithBLOBs(EvaluateExample example);
    List<EvaluateWithBLOBs> selectByExampleWithBLOBsAndPage(EvaluateExample example);

    List<Evaluate> selectByExample(EvaluateExample example);
    List<Evaluate> selectByExampleWithPage(EvaluateExample example);

    EvaluateWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") EvaluateWithBLOBs record, @Param("example") EvaluateExample example);

    int updateByExampleWithBLOBs(@Param("record") EvaluateWithBLOBs record, @Param("example") EvaluateExample example);

    int updateByExample(@Param("record") Evaluate record, @Param("example") EvaluateExample example);

    int updateByPrimaryKeySelective(EvaluateWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(EvaluateWithBLOBs record);

    int updateByPrimaryKey(Evaluate record);
    
    List<EvaluateWithBLOBs> selectByOfLeftJoinStoreId(Long id);
    
    List<EvaluateWithBLOBs>  selectByDistinctGoods();
}