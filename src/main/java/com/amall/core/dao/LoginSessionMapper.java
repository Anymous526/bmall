package com.amall.core.dao;

import com.amall.core.bean.LoginSession;
import com.amall.core.bean.LoginSessionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LoginSessionMapper {
    int countByExample(LoginSessionExample example);

    int deleteByExample(LoginSessionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(LoginSession record);

    int insertSelective(LoginSession record);

    List<LoginSession> selectByExample(LoginSessionExample example);

    LoginSession selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") LoginSession record, @Param("example") LoginSessionExample example);

    int updateByExample(@Param("record") LoginSession record, @Param("example") LoginSessionExample example);

    int updateByPrimaryKeySelective(LoginSession record);

    int updateByPrimaryKey(LoginSession record);
}