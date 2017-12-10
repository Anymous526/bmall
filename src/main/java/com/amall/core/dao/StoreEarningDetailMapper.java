package com.amall.core.dao;

import com.amall.core.bean.StoreEarningDetail;
import com.amall.core.bean.StoreEarningDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StoreEarningDetailMapper {
    int countByExample(StoreEarningDetailExample example);

    int deleteByExample(StoreEarningDetailExample example);

    int deleteByPrimaryKey(Long id);

    int insert(StoreEarningDetail record);

    int insertSelective(StoreEarningDetail record);

    List<StoreEarningDetail> selectByExample(StoreEarningDetailExample example);
    List<StoreEarningDetail> selectByExampleAndPage(StoreEarningDetailExample example);

    StoreEarningDetail selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") StoreEarningDetail record, @Param("example") StoreEarningDetailExample example);

    int updateByExample(@Param("record") StoreEarningDetail record, @Param("example") StoreEarningDetailExample example);

    int updateByPrimaryKeySelective(StoreEarningDetail record);

    int updateByPrimaryKey(StoreEarningDetail record);
}