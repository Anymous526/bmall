package com.amall.core.dao;

import com.amall.core.bean.PromoteDream;
import com.amall.core.bean.PromoteDreamExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PromoteDreamMapper {
    int countByExample(PromoteDreamExample example);

    int deleteByExample(PromoteDreamExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PromoteDream record);

    int insertSelective(PromoteDream record);

    List<PromoteDream> selectByExample(PromoteDreamExample example);

    PromoteDream selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PromoteDream record, @Param("example") PromoteDreamExample example);

    int updateByExample(@Param("record") PromoteDream record, @Param("example") PromoteDreamExample example);

    int updateByPrimaryKeySelective(PromoteDream record);

    int updateByPrimaryKey(PromoteDream record);
}