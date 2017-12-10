package com.amall.core.dao;

import com.amall.core.bean.Role;
import com.amall.core.bean.RoleExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface RoleMapper {
    int countByExample(RoleExample example);

    int deleteByExample(RoleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Role record);

    Long insertSelective(Role record);

    List<Role> selectByExample(RoleExample example);
    List<Role> selectByExampleWithPage(RoleExample example);

    Role selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByExample(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
    
    /**
     * 
     * @todo 通过userId来获取该user的所有权限
     * @author wsw
     * @date 2015年7月13日 下午5:44:35
     * @return List<Role>
     * @param id
     * @return
     */
    List<Role> getRolesToUserByUserIdAndDisplay(long id);

}