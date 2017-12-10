package com.amall.core.dao;

import com.amall.core.bean.RoleGroup;
import com.amall.core.bean.RoleGroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleGroupMapper
{

	int countByExample (RoleGroupExample example);

	int deleteByExample (RoleGroupExample example);

	int deleteByPrimaryKey (Long id);

	int insert (RoleGroup record);

	Long insertSelective (RoleGroup record);

	List <RoleGroup> selectByExample (RoleGroupExample example);

	List <RoleGroup> selectByExampleWithPage (RoleGroupExample example);

	RoleGroup selectByPrimaryKey (Long id);

	int updateByExampleSelective (@Param("record") RoleGroup record , @Param("example") RoleGroupExample example);

	int updateByExample (@Param("record") RoleGroup record , @Param("example") RoleGroupExample example);

	int updateByPrimaryKeySelective (RoleGroup record);

	int updateByPrimaryKey (RoleGroup record);
}