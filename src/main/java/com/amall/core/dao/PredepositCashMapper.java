package com.amall.core.dao;

import com.amall.core.bean.PredepositCash;
import com.amall.core.bean.PredepositCashExample;
import com.amall.core.bean.PredepositCashWithBLOBs;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface PredepositCashMapper {
    int countByExample(PredepositCashExample example);

    int deleteByExample(PredepositCashExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PredepositCashWithBLOBs record);

    Long insertSelective(PredepositCashWithBLOBs record);

    List<PredepositCashWithBLOBs> selectByExampleWithBLOBs(PredepositCashExample example);
    List<PredepositCashWithBLOBs> selectByExampleWithBLOBsAndPage(PredepositCashExample example);

    List<PredepositCash> selectByExample(PredepositCashExample example);
    List<PredepositCash> selectByExampleWithPage(PredepositCashExample example);

    PredepositCashWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PredepositCashWithBLOBs record, @Param("example") PredepositCashExample example);

    int updateByExampleWithBLOBs(@Param("record") PredepositCashWithBLOBs record, @Param("example") PredepositCashExample example);

    int updateByExample(@Param("record") PredepositCash record, @Param("example") PredepositCashExample example);

    int updateByPrimaryKeySelective(PredepositCashWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(PredepositCashWithBLOBs record);

    int updateByPrimaryKey(PredepositCash record);
}