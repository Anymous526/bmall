package com.amall.core.dao;

import com.amall.core.bean.Role2Res;
import com.amall.core.bean.Role2ResExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Role2ResMapper {
    int countByExample(Role2ResExample example);

    int deleteByExample(Role2ResExample example);

    int insert(Role2Res record);

    Long insertSelective(Role2Res record);

    List<Role2Res> selectByExample(Role2ResExample example);

    int updateByExampleSelective(@Param("record") Role2Res record, @Param("example") Role2ResExample example);

    int updateByExample(@Param("record") Role2Res record, @Param("example") Role2ResExample example);
}