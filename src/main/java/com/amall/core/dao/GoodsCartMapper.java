package com.amall.core.dao;

import com.amall.core.bean.GoodsCart;
import com.amall.core.bean.GoodsCartExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface GoodsCartMapper {
    int countByExample(GoodsCartExample example);

    int deleteByExample(GoodsCartExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GoodsCart record);

    Long insertSelective(GoodsCart record);

    List<GoodsCart> selectByExampleWithBLOBs(GoodsCartExample example);
    List<GoodsCart> selectByExampleWithBLOBsAndPage(GoodsCartExample example);

    List<GoodsCart> selectByExample(GoodsCartExample example);
    List<GoodsCart> selectByExampleWithPage(GoodsCartExample example);

    GoodsCart selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GoodsCart record, @Param("example") GoodsCartExample example);

    int updateByExampleWithBLOBs(@Param("record") GoodsCart record, @Param("example") GoodsCartExample example);

    int updateByExample(@Param("record") GoodsCart record, @Param("example") GoodsCartExample example);

    int updateByPrimaryKeySelective(GoodsCart record);

    int updateByPrimaryKeyWithBLOBs(GoodsCart record);

    int updateByPrimaryKey(GoodsCart record);
}