package com.amall.core.dao;

import com.amall.core.bean.CloudGoodsOrder;
import com.amall.core.bean.CloudGoodsOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CloudGoodsOrderMapper {
    int countByExample(CloudGoodsOrderExample example);

    int deleteByExample(CloudGoodsOrderExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CloudGoodsOrder record);

    Long insertSelective(CloudGoodsOrder record);

    List<CloudGoodsOrder> selectByExample(CloudGoodsOrderExample example);
    List<CloudGoodsOrder> selectByExampleWithPage(CloudGoodsOrderExample example);

    CloudGoodsOrder selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CloudGoodsOrder record, @Param("example") CloudGoodsOrderExample example);

    int updateByExample(@Param("record") CloudGoodsOrder record, @Param("example") CloudGoodsOrderExample example);

    int updateByPrimaryKeySelective(CloudGoodsOrder record);

    int updateByPrimaryKey(CloudGoodsOrder record);
}