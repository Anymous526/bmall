package com.amall.core.dao;

import com.amall.core.bean.CloudGoods;
import com.amall.core.bean.CloudGoodsExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CloudGoodsMapper {
    int countByExample(CloudGoodsExample example);

    int deleteByExample(CloudGoodsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CloudGoods record);

    int insertSelective(CloudGoods record);

    List<CloudGoods> selectByExample(CloudGoodsExample example);
    List<CloudGoods> selectByExampleWithPage(CloudGoodsExample example);

    CloudGoods selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CloudGoods record, @Param("example") CloudGoodsExample example);

    int updateByExample(@Param("record") CloudGoods record, @Param("example") CloudGoodsExample example);

    int updateByPrimaryKeySelective(CloudGoods record);

    int updateByPrimaryKey(CloudGoods record);
}