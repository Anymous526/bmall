package com.amall.core.dao;

import com.amall.core.bean.SystemMsgRecord;
import com.amall.core.bean.SystemMsgRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SystemMsgRecordMapper {
    int countByExample(SystemMsgRecordExample example);

    int deleteByExample(SystemMsgRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SystemMsgRecord record);

    int insertSelective(SystemMsgRecord record);

    List<SystemMsgRecord> selectByExample(SystemMsgRecordExample example);
    
    List<SystemMsgRecord> selectByExampleWithPage(SystemMsgRecordExample example);

    SystemMsgRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SystemMsgRecord record, @Param("example") SystemMsgRecordExample example);

    int updateByExample(@Param("record") SystemMsgRecord record, @Param("example") SystemMsgRecordExample example);

    int updateByPrimaryKeySelective(SystemMsgRecord record);

    int updateByPrimaryKey(SystemMsgRecord record);
    
}