package com.amall.core.dao;

import com.amall.core.bean.CloudBuyCodes;
import com.amall.core.bean.CloudBuyCodesExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CloudBuyCodesMapper {
    int countByExample(CloudBuyCodesExample example);

    int deleteByExample(CloudBuyCodesExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CloudBuyCodes record);

    int insertSelective(CloudBuyCodes record);

    List<CloudBuyCodes> selectByExampleWithBLOBs(CloudBuyCodesExample example);
    List<CloudBuyCodes> selectByExampleWithBLOBsAndPage(CloudBuyCodesExample example);

    List<CloudBuyCodes> selectByExample(CloudBuyCodesExample example);

    CloudBuyCodes selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CloudBuyCodes record, @Param("example") CloudBuyCodesExample example);

    int updateByExampleWithBLOBs(@Param("record") CloudBuyCodes record, @Param("example") CloudBuyCodesExample example);

    int updateByExample(@Param("record") CloudBuyCodes record, @Param("example") CloudBuyCodesExample example);

    int updateByPrimaryKeySelective(CloudBuyCodes record);

    int updateByPrimaryKeyWithBLOBs(CloudBuyCodes record);

    int updateByPrimaryKey(CloudBuyCodes record);
}