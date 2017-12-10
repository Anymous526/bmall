package com.amall.core.dao;

import com.amall.core.bean.CloudBuyerDetail;
import com.amall.core.bean.CloudBuyerDetailExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CloudBuyerDetailMapper {
    int countByExample(CloudBuyerDetailExample example);

    int deleteByExample(CloudBuyerDetailExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CloudBuyerDetail record);

    int insertSelective(CloudBuyerDetail record);

    List<CloudBuyerDetail> selectByExampleWithBLOBs(CloudBuyerDetailExample example);
    List<CloudBuyerDetail> selectByExampleWithBLOBsAndPage(CloudBuyerDetailExample example);

    List<CloudBuyerDetail> selectByExample(CloudBuyerDetailExample example);

    CloudBuyerDetail selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CloudBuyerDetail record, @Param("example") CloudBuyerDetailExample example);

    int updateByExampleWithBLOBs(@Param("record") CloudBuyerDetail record, @Param("example") CloudBuyerDetailExample example);

    int updateByExample(@Param("record") CloudBuyerDetail record, @Param("example") CloudBuyerDetailExample example);

    int updateByPrimaryKeySelective(CloudBuyerDetail record);

    int updateByPrimaryKeyWithBLOBs(CloudBuyerDetail record);

    int updateByPrimaryKey(CloudBuyerDetail record);
}