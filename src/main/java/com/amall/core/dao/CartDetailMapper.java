package com.amall.core.dao;

import com.amall.core.bean.CartDetail;
import com.amall.core.bean.CartDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CartDetailMapper  {
    int countByExample(CartDetailExample example);

    int deleteByExample(CartDetailExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CartDetail record);

    int insertSelective(CartDetail record);

    List<CartDetail> selectByExampleWithBLOBs(CartDetailExample example);
    List<CartDetail> selectByExampleWithBLOBsAndPage(CartDetailExample example);

    List<CartDetail> selectByExample(CartDetailExample example);

    CartDetail selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CartDetail record, @Param("example") CartDetailExample example);

    int updateByExampleWithBLOBs(@Param("record") CartDetail record, @Param("example") CartDetailExample example);

    int updateByExample(@Param("record") CartDetail record, @Param("example") CartDetailExample example);

    int updateByPrimaryKeySelective(CartDetail record);

    int updateByPrimaryKeyWithBLOBs(CartDetail record);

    int updateByPrimaryKey(CartDetail record);

}