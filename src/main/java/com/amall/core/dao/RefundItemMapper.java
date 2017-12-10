package com.amall.core.dao;


import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.amall.core.bean.RefundItem;
import com.amall.core.bean.RefundItemExample;

public interface RefundItemMapper {
    int countByExample(RefundItemExample example);

    int deleteByExample(RefundItemExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RefundItem record);

    int insertSelective(RefundItem record);

    List<RefundItem> selectByExample(RefundItemExample example);

    RefundItem selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RefundItem record, @Param("example") RefundItemExample example);

    int updateByExample(@Param("record") RefundItem record, @Param("example") RefundItemExample example);

    int updateByPrimaryKeySelective(RefundItem record);

    int updateByPrimaryKey(RefundItem record);
}