package com.amall.core.dao;

import com.amall.core.bean.Accessory;
import com.amall.core.bean.AccessoryExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface AccessoryMapper {
    int countByExample(AccessoryExample example);

    int deleteByExample(AccessoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Accessory record);

    Long insertSelective(Accessory record);

    List<Accessory> selectByExample(AccessoryExample example);
    List<Accessory> selectByExampleWithBLOBs(AccessoryExample example);
    List<Accessory> selectByExampleWithPage(AccessoryExample example);

    Accessory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Accessory record, @Param("example") AccessoryExample example);

    int updateByExample(@Param("record") Accessory record, @Param("example") AccessoryExample example);

    int updateByPrimaryKeySelective(Accessory record);

    int updateByPrimaryKey(Accessory record);
    
    /**
     * 
     * @author wsw
     * @date 2015年6月18日 下午4:50:00
     * @todo 通过goods_id获取对应的照片集合
     * @return List<Accessory>
     * @param id
     * @return
     */
    List<Accessory> getAccListOfGoodsByPhotoId(Long id);
}