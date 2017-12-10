package com.amall.core.dao;

import com.amall.core.bean.ComplaintGoods;
import com.amall.core.bean.ComplaintGoodsExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ComplaintGoodsMapper {
    int countByExample(ComplaintGoodsExample example);

    int deleteByExample(ComplaintGoodsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ComplaintGoods record);

    Long insertSelective(ComplaintGoods record);

    List<ComplaintGoods> selectByExampleWithBLOBs(ComplaintGoodsExample example);
    List<ComplaintGoods> selectByExampleWithBLOBsAndPage(ComplaintGoodsExample example);

    List<ComplaintGoods> selectByExample(ComplaintGoodsExample example);
    List<ComplaintGoods> selectByExampleWithPage(ComplaintGoodsExample example);

    ComplaintGoods selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ComplaintGoods record, @Param("example") ComplaintGoodsExample example);

    int updateByExampleWithBLOBs(@Param("record") ComplaintGoods record, @Param("example") ComplaintGoodsExample example);

    int updateByExample(@Param("record") ComplaintGoods record, @Param("example") ComplaintGoodsExample example);

    int updateByPrimaryKeySelective(ComplaintGoods record);

    int updateByPrimaryKeyWithBLOBs(ComplaintGoods record);

    int updateByPrimaryKey(ComplaintGoods record);
}