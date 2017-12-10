package com.amall.core.service.goods;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.GoodsCart;
import com.amall.core.bean.GoodsCartExample;
import com.amall.core.dao.GoodsCartMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class GoodsCartServiceImpl implements IGoodsCartService {

	@Resource 
	private GoodsCartMapper  goodsCartDao;

	public Long add(GoodsCart example) {
		return goodsCartDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public GoodsCart getByKey(Long id) {
		return goodsCartDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		return goodsCartDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(GoodsCartExample example) {
		return goodsCartDao.deleteByExample(example);
	}

	public Integer updateByObject(GoodsCart record) {
		return goodsCartDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(GoodsCartExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),goodsCartDao.countByExample(example));
		p.setList(goodsCartDao.selectByExampleWithBLOBsAndPage(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<GoodsCart> getObjectList(GoodsCartExample example) {
		return goodsCartDao.selectByExampleWithBLOBs(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(GoodsCartExample example) {
		return goodsCartDao.countByExample(example);
	}


}
