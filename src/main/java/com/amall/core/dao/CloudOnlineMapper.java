package com.amall.core.dao;

import com.amall.core.bean.CloudOnline;
import com.amall.core.bean.CloudOnlineExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CloudOnlineMapper {
    int countByExample(CloudOnlineExample example);

    int deleteByExample(CloudOnlineExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CloudOnline record);

    int insertSelective(CloudOnline record);

    List<CloudOnline> selectByExample(CloudOnlineExample example);
    List<CloudOnline> selectByExampleWithPage(CloudOnlineExample example);

    CloudOnline selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CloudOnline record, @Param("example") CloudOnlineExample example);

    int updateByExample(@Param("record") CloudOnline record, @Param("example") CloudOnlineExample example);

    int updateByPrimaryKeySelective(CloudOnline record);

    int updateByPrimaryKey(CloudOnline record);
}