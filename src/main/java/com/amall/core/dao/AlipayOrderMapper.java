package com.amall.core.dao;

import com.amall.core.bean.AlipayOrder;
import com.amall.core.bean.AlipayOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AlipayOrderMapper {
    int countByExample(AlipayOrderExample example);

    int deleteByExample(AlipayOrderExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AlipayOrder record);

    Long insertSelective(AlipayOrder record);

    List<AlipayOrder> selectByExample(AlipayOrderExample example);
    
    AlipayOrder selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AlipayOrder record, @Param("example") AlipayOrderExample example);

    int updateByExample(@Param("record") AlipayOrder record, @Param("example") AlipayOrderExample example);

    int updateByPrimaryKeySelective(AlipayOrder record);

    int updateByPrimaryKey(AlipayOrder record);
}