package com.amall.core.dao;

import com.amall.core.bean.RedPaper;
import com.amall.core.bean.RedPaperExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RedPaperMapper {
    int countByExample(RedPaperExample example);

    int deleteByExample(RedPaperExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RedPaper record);

    int insertSelective(RedPaper record);

    List<RedPaper> selectByExample(RedPaperExample example);

    RedPaper selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RedPaper record,@Param("example") RedPaperExample example);

    int updateByExample(@Param("record") RedPaper record, @Param("example") RedPaperExample example);

    int updateByPrimaryKeySelective(RedPaper record);

    int updateByPrimaryKey(RedPaper record);
}