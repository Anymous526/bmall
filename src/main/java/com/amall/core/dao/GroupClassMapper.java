package com.amall.core.dao;

import com.amall.core.bean.GroupClass;
import com.amall.core.bean.GroupClassExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GroupClassMapper {
    int countByExample(GroupClassExample example);

    int deleteByExample(GroupClassExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GroupClass record);

    Long insertSelective(GroupClass record);

    List<GroupClass> selectByExample(GroupClassExample example);
	List<GroupClass> selectByExampleWithPage(GroupClassExample example);

    GroupClass selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GroupClass record, @Param("example") GroupClassExample example);

    int updateByExample(@Param("record") GroupClass record, @Param("example") GroupClassExample example);

    int updateByPrimaryKeySelective(GroupClass record);

    int updateByPrimaryKey(GroupClass record);
}