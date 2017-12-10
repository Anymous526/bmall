package com.amall.core.dao;

import com.amall.core.bean.PromoteDreamFee;
import com.amall.core.bean.PromoteDreamFeeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PromoteDreamFeeMapper {
    int countByExample(PromoteDreamFeeExample example);

    int deleteByExample(PromoteDreamFeeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PromoteDreamFee record);

    int insertSelective(PromoteDreamFee record);

    List<PromoteDreamFee> selectByExample(PromoteDreamFeeExample example);

    PromoteDreamFee selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PromoteDreamFee record, @Param("example") PromoteDreamFeeExample example);

    int updateByExample(@Param("record") PromoteDreamFee record, @Param("example") PromoteDreamFeeExample example);

    int updateByPrimaryKeySelective(PromoteDreamFee record);

    int updateByPrimaryKey(PromoteDreamFee record);
}