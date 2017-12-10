package com.amall.core.dao;

import com.amall.core.bean.FengHong;
import com.amall.core.bean.FengHongExample;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FengHongMapper
{

	int countByExample (FengHongExample example);

	int deleteByExample (FengHongExample example);

	int deleteByPrimaryKey (Long id);

	int insert (FengHong record);

	int insertSelective (FengHong record);

	List <FengHong> selectByExample (FengHongExample example);

	FengHong selectByPrimaryKey (Long id);

	int updateByExampleSelective (@Param("record") FengHong record , @Param("example") FengHongExample example);

	int updateByExample (@Param("record") FengHong record , @Param("example") FengHongExample example);

	int updateByPrimaryKeySelective (FengHong record);

	int updateByPrimaryKey (FengHong record);

	List <FengHong> selectFengHong (HashMap map);
}