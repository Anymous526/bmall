package com.amall.core.dao;

import com.amall.core.bean.RedPackge;
import com.amall.core.bean.RedPackgeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RedPackgeMapper {
    int countByExample(RedPackgeExample example);

    int deleteByExample(RedPackgeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RedPackge record);

    int insertSelective(RedPackge record);

    List<RedPackge> selectByExample(RedPackgeExample example);
    
    List<RedPackge> selectByExampleWithPage(RedPackgeExample example);

    RedPackge selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RedPackge record,@Param("example") RedPackgeExample example);

    int updateByExample(@Param("record") RedPackge record, @Param("example") RedPackgeExample example);

    int updateByPrimaryKeySelective(RedPackge record);

    int updateByPrimaryKey(RedPackge record);
}