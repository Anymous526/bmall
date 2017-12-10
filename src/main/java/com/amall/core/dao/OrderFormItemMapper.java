package com.amall.core.dao;

import com.amall.core.bean.OrderFormItem;
import com.amall.core.bean.OrderFormItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderFormItemMapper {
    int countByExample(OrderFormItemExample example);

    int deleteByExample(OrderFormItemExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrderFormItem record);

    int insertSelective(OrderFormItem record);

    List<OrderFormItem> selectByExampleWithBLOBs(OrderFormItemExample example);
    List<OrderFormItem> selectByExampleWithBLOBsAndPage(OrderFormItemExample example);

    List<OrderFormItem> selectByExample(OrderFormItemExample example);

    OrderFormItem selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrderFormItem record, @Param("example") OrderFormItemExample example);

    int updateByExampleWithBLOBs(@Param("record") OrderFormItem record, @Param("example") OrderFormItemExample example);

    int updateByExample(@Param("record") OrderFormItem record, @Param("example") OrderFormItemExample example);

    int updateByPrimaryKeySelective(OrderFormItem record);

    int updateByPrimaryKeyWithBLOBs(OrderFormItem record);

    int updateByPrimaryKey(OrderFormItem record);
}