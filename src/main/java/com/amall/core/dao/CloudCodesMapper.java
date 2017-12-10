package com.amall.core.dao;

import com.amall.core.bean.CloudCodes;
import com.amall.core.bean.CloudCodesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CloudCodesMapper {
    int countByExample(CloudCodesExample example);

    int deleteByExample(CloudCodesExample example);

    void batchSave(List<CloudCodes> list);

    int insertSelective(CloudCodes record);

    List<CloudCodes> selectByExample(CloudCodesExample example);

    int updateByExampleSelective(@Param("record") CloudCodes record, @Param("example") CloudCodesExample example);

    int updateByExample(@Param("record") CloudCodes record, @Param("example") CloudCodesExample example);
}