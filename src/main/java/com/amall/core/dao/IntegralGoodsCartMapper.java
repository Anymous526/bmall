package com.amall.core.dao;

import com.amall.core.bean.IntegralGoodsCart;
import com.amall.core.bean.IntegralGoodsCartExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface IntegralGoodsCartMapper {
    int countByExample(IntegralGoodsCartExample example);

    int deleteByExample(IntegralGoodsCartExample example);

    int deleteByPrimaryKey(Long id);

    int insert(IntegralGoodsCart record);

    Long insertSelective(IntegralGoodsCart record);

    List<IntegralGoodsCart> selectByExample(IntegralGoodsCartExample example);
    List<IntegralGoodsCart> selectByExampleWithPage(IntegralGoodsCartExample example);

    IntegralGoodsCart selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") IntegralGoodsCart record, @Param("example") IntegralGoodsCartExample example);

    int updateByExample(@Param("record") IntegralGoodsCart record, @Param("example") IntegralGoodsCartExample example);

    int updateByPrimaryKeySelective(IntegralGoodsCart record);

    int updateByPrimaryKey(IntegralGoodsCart record);
}