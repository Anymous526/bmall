package com.amall.core.dao;

import com.amall.core.bean.AdvertPosition;
import com.amall.core.bean.AdvertPositionExample;
import com.amall.core.bean.AdvertPositionWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdvertPositionMapper {
    int countByExample(AdvertPositionExample example);

    int deleteByExample(AdvertPositionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AdvertPositionWithBLOBs record);

    Long insertSelective(AdvertPositionWithBLOBs record);

    List<AdvertPositionWithBLOBs> selectByExampleWithBLOBs(AdvertPositionExample example);
	List<AdvertPositionWithBLOBs> selectByExampleWithBLOBsAndPage(AdvertPositionExample example);

    List<AdvertPosition> selectByExample(AdvertPositionExample example);

    AdvertPositionWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AdvertPositionWithBLOBs record, @Param("example") AdvertPositionExample example);

    int updateByExampleWithBLOBs(@Param("record") AdvertPositionWithBLOBs record, @Param("example") AdvertPositionExample example);

    int updateByExample(@Param("record") AdvertPosition record, @Param("example") AdvertPositionExample example);

    int updateByPrimaryKeySelective(AdvertPositionWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(AdvertPositionWithBLOBs record);

    int updateByPrimaryKey(AdvertPosition record);
}