package com.amall.core.dao;

import com.amall.core.bean.CloudShowOrder;
import com.amall.core.bean.CloudShowOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CloudShowOrderMapper {
    int countByExample(CloudShowOrderExample example);

    int deleteByExample(CloudShowOrderExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CloudShowOrder record);

    int insertSelective(CloudShowOrder record);

    List<CloudShowOrder> selectByExample(CloudShowOrderExample example);
    List<CloudShowOrder> selectByExampleWithPage(CloudShowOrderExample example);

    CloudShowOrder selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CloudShowOrder record, @Param("example") CloudShowOrderExample example);

    int updateByExample(@Param("record") CloudShowOrder record, @Param("example") CloudShowOrderExample example);

    int updateByPrimaryKeySelective(CloudShowOrder record);

    int updateByPrimaryKey(CloudShowOrder record);
}