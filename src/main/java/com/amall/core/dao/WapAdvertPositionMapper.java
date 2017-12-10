package com.amall.core.dao;

import com.amall.core.bean.WapAdvertPosition;
import com.amall.core.bean.WapAdvertPositionExample;
import com.amall.core.bean.WapAdvertPositionWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WapAdvertPositionMapper {
    int countByExample(WapAdvertPositionExample example);

    int deleteByExample(WapAdvertPositionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(WapAdvertPositionWithBLOBs record);

    int insertSelective(WapAdvertPositionWithBLOBs record);

    List<WapAdvertPositionWithBLOBs> selectByExampleWithBLOBs(WapAdvertPositionExample example);
    
    List<WapAdvertPositionWithBLOBs> selectByExampleWithBLOBsAndPage(WapAdvertPositionExample example);

    List<WapAdvertPosition> selectByExample(WapAdvertPositionExample example);

    WapAdvertPositionWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WapAdvertPositionWithBLOBs record, @Param("example") WapAdvertPositionExample example);

    int updateByExampleWithBLOBs(@Param("record") WapAdvertPositionWithBLOBs record, @Param("example") WapAdvertPositionExample example);

    int updateByExample(@Param("record") WapAdvertPosition record, @Param("example") WapAdvertPositionExample example);

    int updateByPrimaryKeySelective(WapAdvertPositionWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(WapAdvertPositionWithBLOBs record);

    int updateByPrimaryKey(WapAdvertPosition record);
}