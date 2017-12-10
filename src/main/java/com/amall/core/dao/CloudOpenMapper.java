package com.amall.core.dao;

import com.amall.core.bean.CloudOpen;
import com.amall.core.bean.CloudOpenExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CloudOpenMapper {
    int countByExample(CloudOpenExample example);

    int deleteByExample(CloudOpenExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CloudOpen record);

    int insertSelective(CloudOpen record);

    List<CloudOpen> selectByExample(CloudOpenExample example);
    List<CloudOpen> selectByExampleWithPage(CloudOpenExample example);

    CloudOpen selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CloudOpen record, @Param("example") CloudOpenExample example);

    int updateByExample(@Param("record") CloudOpen record, @Param("example") CloudOpenExample example);

    int updateByPrimaryKeySelective(CloudOpen record);

    int updateByPrimaryKey(CloudOpen record);
}