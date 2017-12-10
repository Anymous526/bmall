package com.amall.core.dao;

import com.amall.core.bean.GroupGoods;
import com.amall.core.bean.GroupGoodsExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface GroupGoodsMapper {
    int countByExample(GroupGoodsExample example);

    int deleteByExample(GroupGoodsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GroupGoods record);

    Long insertSelective(GroupGoods record);

    List<GroupGoods> selectByExampleWithBLOBs(GroupGoodsExample example);
    List<GroupGoods> selectByExampleWithBLOBsAndPage(GroupGoodsExample example);

    List<GroupGoods> selectByExample(GroupGoodsExample example);
    List<GroupGoods> selectByExampleWithPage(GroupGoodsExample example);

    GroupGoods selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GroupGoods record, @Param("example") GroupGoodsExample example);

    int updateByExampleWithBLOBs(@Param("record") GroupGoods record, @Param("example") GroupGoodsExample example);

    int updateByExample(@Param("record") GroupGoods record, @Param("example") GroupGoodsExample example);

    int updateByPrimaryKeySelective(GroupGoods record);

    int updateByPrimaryKeyWithBLOBs(GroupGoods record);

    int updateByPrimaryKey(GroupGoods record);
}