package com.amall.core.dao;

import com.amall.core.bean.OrderExportEntity;
import com.amall.core.bean.OrderForm;
import com.amall.core.bean.OrderFormExample;
import com.amall.core.bean.OrderFormWithBLOBs;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface OrderFormMapper {
    int countByExample(OrderFormExample example);

    int deleteByExample(OrderFormExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrderFormWithBLOBs record);
  
    Long insertSelective(OrderFormWithBLOBs record);

    List<OrderFormWithBLOBs> selectByExampleWithBLOBs(OrderFormExample example);
    List<OrderFormWithBLOBs> selectByExampleWithBLOBsAndPage(OrderFormExample example);

    List<OrderForm> selectByExample(OrderFormExample example);

    OrderFormWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrderFormWithBLOBs record, @Param("example") OrderFormExample example);

    int updateByExampleWithBLOBs(@Param("record") OrderFormWithBLOBs record, @Param("example") OrderFormExample example);

    int updateByExample(@Param("record") OrderForm record, @Param("example") OrderFormExample example);

    int updateByPrimaryKeySelective(OrderFormWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(OrderFormWithBLOBs record);

    int updateByPrimaryKey(OrderForm record);
    
    
    public List<OrderFormWithBLOBs> getUserAndPrice(OrderFormExample example);
    
    /**
     * 
     * @todo 通过传入商品名字进行模糊查询,并返回该orderForm信息
     * @author wsw
     * @date 2015年6月27日 上午10:13:39
     * @return List<OrderFormWithBLOBs>
     * @param condition
     * @return
     */
    List<OrderFormWithBLOBs> selectOfByGoodsNameLike(String condition);
    
    List<OrderExportEntity> selectOrderExport();
    
    List<OrderExportEntity> selectOtowOOrderExport();
    
    List<OrderExportEntity>  selectStoreOrderExport(long storeId);
    
}