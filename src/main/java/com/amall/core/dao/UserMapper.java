package com.amall.core.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.amall.core.bean.Role;
import com.amall.core.bean.User;
import com.amall.core.bean.UserExample;

public interface UserMapper {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(User record);

    Long insertSelective(User record);

    List<User> selectByExampleWithBLOBs(UserExample example);
    List<User> selectByExampleWithBLOBsAndPage(UserExample example);

    List<User> selectByExample(UserExample example);
    List<User> selectByExampleWithPage(UserExample example);

    User selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExampleWithBLOBs(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKeyWithBLOBs(User record);

    int updateByPrimaryKey(User record);
    
    List<Role> selectRoleByUserId(Map map);
    
    int insertUserRole(Map map);
}