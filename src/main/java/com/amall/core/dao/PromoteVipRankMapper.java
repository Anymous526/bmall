package com.amall.core.dao;

import com.amall.core.bean.PromoteVipRank;
import com.amall.core.bean.PromoteVipRankExample;

import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PromoteVipRankMapper {
    int countByExample(PromoteVipRankExample example);

    int deleteByExample(PromoteVipRankExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PromoteVipRank record);

    int insertSelective(PromoteVipRank record);

    List<PromoteVipRank> selectByExample(PromoteVipRankExample example);
    
    List<PromoteVipRank> selectByExampleAndPage(PromoteVipRankExample example);

    PromoteVipRank selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PromoteVipRank record, @Param("example") PromoteVipRankExample example);

    int updateByExample(@Param("record") PromoteVipRank record, @Param("example") PromoteVipRankExample example);

    int updateByPrimaryKeySelective(PromoteVipRank record);

    int updateByPrimaryKey(PromoteVipRank record);
    
    BigDecimal selectTotalFee();
}