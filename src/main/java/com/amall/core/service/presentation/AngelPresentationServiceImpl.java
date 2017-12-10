package com.amall.core.service.presentation;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.AngelPresentation;
import com.amall.core.bean.AngelPresentationExample;
import com.amall.core.dao.AngelPresentationMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class AngelPresentationServiceImpl implements IAngelPresentationService {

	@Resource 
	private AngelPresentationMapper angelPresentationDao;

	public Long add(AngelPresentation example) {
		
		return angelPresentationDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public AngelPresentation getByKey(Long id) {
		
		return angelPresentationDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		
		return angelPresentationDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(AngelPresentationExample example) {
		
		return angelPresentationDao.deleteByExample(example);
	}

	public Integer updateByObject(AngelPresentation record) {
		
		return angelPresentationDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(AngelPresentationExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),angelPresentationDao.countByExample(example));
		p.setList(angelPresentationDao.selectByExampleWithPage(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<AngelPresentation> getObjectList(AngelPresentationExample example) {
		
		return angelPresentationDao.selectByExample(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(AngelPresentationExample example) {
		
		return angelPresentationDao.countByExample(example);
	}
	@Override
	public List<AngelPresentation> getObjectListOfGetUserId(Long getUserId)
	{
		AngelPresentationExample example = new AngelPresentationExample();
		example.createCriteria().andGetUserIdEqualTo(getUserId);
		
		return angelPresentationDao.selectByExample(example);
	}
	@Override
	public List<AngelPresentation> getObjectListOfGiveUserId(Long giveUserId)
	{
		AngelPresentationExample example = new AngelPresentationExample();
		example.createCriteria().andGiveUserIdEqualTo(giveUserId);
		
		return angelPresentationDao.selectByExample(example);
	}

}
