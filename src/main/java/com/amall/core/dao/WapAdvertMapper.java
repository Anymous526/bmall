package com.amall.core.dao;

import com.amall.core.bean.WapAdvert;
import com.amall.core.bean.WapAdvertExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WapAdvertMapper {
    int countByExample(WapAdvertExample example);

    int deleteByExample(WapAdvertExample example);

    int deleteByPrimaryKey(Long id);

    int insert(WapAdvert record);

    int insertSelective(WapAdvert record);

    List<WapAdvert> selectByExample(WapAdvertExample example);
    List<WapAdvert> selectByExampleWithPage(WapAdvertExample example);

    WapAdvert selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WapAdvert record, @Param("example") WapAdvertExample example);

    int updateByExample(@Param("record") WapAdvert record, @Param("example") WapAdvertExample example);

    int updateByPrimaryKeySelective(WapAdvert record);

    int updateByPrimaryKey(WapAdvert record);
}