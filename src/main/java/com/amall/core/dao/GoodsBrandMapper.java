package com.amall.core.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.amall.core.bean.GoodsBrand;
import com.amall.core.bean.GoodsBrandExample;

public interface GoodsBrandMapper {
    int countByExample(GoodsBrandExample example);

    int deleteByExample(GoodsBrandExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GoodsBrand record);

    Long insertSelective(GoodsBrand record);

    List<GoodsBrand> selectByExampleWithBLOBs(GoodsBrandExample example);
    List<GoodsBrand> selectByExampleWithBLOBsAndPage(GoodsBrandExample example);

    List<GoodsBrand> selectByExample(GoodsBrandExample example);
    List<GoodsBrand> selectByExampleWithPage(GoodsBrandExample example);

    GoodsBrand selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GoodsBrand record, @Param("example") GoodsBrandExample example);

    int updateByExampleWithBLOBs(@Param("record") GoodsBrand record, @Param("example") GoodsBrandExample example);

    int updateByExample(@Param("record") GoodsBrand record, @Param("example") GoodsBrandExample example);

    int updateByPrimaryKeySelective(GoodsBrand record);

    int updateByPrimaryKeyWithBLOBs(GoodsBrand record);

    int updateByPrimaryKey(GoodsBrand record);
    
	List <GoodsBrand> selectGoodsBrand (Map map);//第三张表，amall_goodstype_brand，通过typeId得到GoodsBrand对象
    
    GoodsBrand getGoodsById(Long id);
}