package com.amall.core.service.integral;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.IntegralGoodsCart;
import com.amall.core.bean.IntegralGoodsCartExample;
import com.amall.core.dao.IntegralGoodsCartMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class IntegralGoodsCartServiceImpl implements IIntegralGoodsCartService {

	@Resource
	private IntegralGoodsCartMapper integralGoodsCartDao;

	public Long add(IntegralGoodsCart example) {
		
		return integralGoodsCartDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public IntegralGoodsCart getByKey(Long id) {
		
		return integralGoodsCartDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		
		return integralGoodsCartDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(IntegralGoodsCartExample example) {
		
		return integralGoodsCartDao.deleteByExample(example);
	}

	public Integer updateByObject(IntegralGoodsCart record) {
		
		return integralGoodsCartDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(IntegralGoodsCartExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),integralGoodsCartDao.countByExample(example));
		p.setList(integralGoodsCartDao.selectByExampleWithPage(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<IntegralGoodsCart> getObjectList(
			IntegralGoodsCartExample example) {
		
		return integralGoodsCartDao.selectByExample(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(IntegralGoodsCartExample example) {
		
		return integralGoodsCartDao.countByExample(example);
	}


}
