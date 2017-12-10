package com.amall.core.dao;

import com.amall.core.bean.SystemMsg;
import com.amall.core.bean.SystemMsgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SystemMsgMapper {
    int countByExample(SystemMsgExample example);

    int deleteByExample(SystemMsgExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SystemMsg record);

    int insertSelective(SystemMsg record);

    List<SystemMsg> selectByExampleWithBLOBs(SystemMsgExample example);
    List<SystemMsg> selectByExampleWithBLOBsAndPage(SystemMsgExample example);

    List<SystemMsg> selectByExample(SystemMsgExample example);
    List<SystemMsg> selectByExampleWithPage(SystemMsgExample example);

    SystemMsg selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SystemMsg record, @Param("example") SystemMsgExample example);

    int updateByExampleWithBLOBs(@Param("record") SystemMsg record, @Param("example") SystemMsgExample example);

    int updateByExample(@Param("record") SystemMsg record, @Param("example") SystemMsgExample example);

    int updateByPrimaryKeySelective(SystemMsg record);

    int updateByPrimaryKeyWithBLOBs(SystemMsg record);

    int updateByPrimaryKey(SystemMsg record);
}