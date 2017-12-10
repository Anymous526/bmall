package com.amall.core.service.promote;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.PromoteVipRank;
import com.amall.core.bean.PromoteVipRankExample;
import com.amall.core.dao.PromoteVipRankMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class PromoteVipRankService implements IPromoteVipRankService {

	@Resource
	private PromoteVipRankMapper promoteVipRankDAO;

	public Integer add(PromoteVipRank example)
	{
		return promoteVipRankDAO.insertSelective(example);
	}

	public PromoteVipRank getByKey(Long id)
	{
		return promoteVipRankDAO.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id)
	{
		return promoteVipRankDAO.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(PromoteVipRankExample example)
	{
		return promoteVipRankDAO.deleteByExample(example);
	}

	public Integer updateByObject(PromoteVipRank record)
	{
		return promoteVipRankDAO.updateByPrimaryKeySelective(record);
	}
	
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(PromoteVipRankExample example)
	{
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),promoteVipRankDAO.countByExample(example));
		p.setList(promoteVipRankDAO.selectByExampleAndPage(example));
		return p;
	}

	@Transactional(readOnly=true)
	public List<PromoteVipRank> getObjectList(PromoteVipRankExample example)
	{
		return promoteVipRankDAO.selectByExample(example);
	}

	@Transactional(readOnly=true)
	public Integer getObjectListCount(PromoteVipRankExample example)
	{
		return promoteVipRankDAO.countByExample(example);
	}

    @Override
    public BigDecimal selectTotalFee()
    {
        BigDecimal decimal = promoteVipRankDAO.selectTotalFee();
        
        if(decimal == null)
        {
            decimal = BigDecimal.ZERO;
        }
        
        return decimal;
    }
	
	
}
