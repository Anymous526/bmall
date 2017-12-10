package com.amall.core.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.amall.core.bean.Goods;
import com.amall.core.bean.GoodsExample;
import com.amall.core.bean.GoodsSpecial;
import com.amall.core.bean.GoodsWithBLOBs;

public interface GoodsMapper {
    int countByExample(GoodsExample example);

    int deleteByExample(GoodsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GoodsWithBLOBs record);

    Long insertSelective(GoodsWithBLOBs record);

    List<GoodsWithBLOBs> selectByExampleWithBLOBs(GoodsExample example);
    List<GoodsWithBLOBs> selectByExampleWithBLOBsAndPage(GoodsExample example);

    List<Goods> selectByExample(GoodsExample example);
    List<Goods> selectByExampleWithPage(GoodsExample example);

    GoodsWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GoodsWithBLOBs record, @Param("example") GoodsExample example);

    int updateByExampleWithBLOBs(@Param("record") GoodsWithBLOBs record, @Param("example") GoodsExample example);

    int updateByExample(@Param("record") Goods record, @Param("example") GoodsExample example);

    int updateByPrimaryKeySelective(GoodsWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(GoodsWithBLOBs record);

    int updateByPrimaryKey(Goods record);
    
    List<GoodsWithBLOBs> selectGoodsCombin(Map map);
    
    List<GoodsSpecial> selectGoodsSpecial(Long id);

}