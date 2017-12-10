package com.amall.core.dao;

import com.amall.core.bean.User2RoleExample;
import com.amall.core.bean.User2Role;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface User2RoleMapper {
    int countByExample(User2RoleExample example);

    int deleteByExample(User2RoleExample example);

    int deleteByPrimaryKey(User2Role key);

    int insert(User2Role record);

    Long insertSelective(User2Role record);

    List<User2Role> selectByExample(User2RoleExample example);

    int updateByExampleSelective(@Param("record") User2Role record, @Param("example") User2RoleExample example);

    int updateByExample(@Param("record") User2Role record, @Param("example") User2RoleExample example);
}