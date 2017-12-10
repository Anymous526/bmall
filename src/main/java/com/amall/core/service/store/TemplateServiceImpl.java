package com.amall.core.service.store;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.Template;
import com.amall.core.bean.TemplateExample;
import com.amall.core.dao.TemplateMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class TemplateServiceImpl implements ITemplateService {

	@Resource 
	private TemplateMapper  templateDao;

	public Long add(Template example) {
		return templateDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public Template getByKey(Long id) {
		return templateDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		return templateDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(TemplateExample example) {
		return templateDao.deleteByExample(example);
	}

	public Integer updateByObject(Template record) {
		return templateDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(TemplateExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),templateDao.countByExample(example));
		p.setList(templateDao.selectByExampleWithBLOBsAndPage(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<Template> getObjectList(TemplateExample example) {
		return templateDao.selectByExampleWithBLOBs(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(TemplateExample example) {
		return templateDao.countByExample(example);
	}


}
