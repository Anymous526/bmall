package com.amall.core.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.Document;
import com.amall.core.bean.DocumentExample;
import com.amall.core.dao.DocumentMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class DocumentServiceImpl implements IDocumentService {
	@Resource
	private DocumentMapper documentDao;

	public Long add(Document example) {
		return documentDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public Document getByKey(Long id) {
		return documentDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		return documentDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(DocumentExample example) {
		return documentDao.deleteByExample(example);
	}

	public Integer updateByObject(Document record) {
		return documentDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(DocumentExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),documentDao.countByExample(example));
		p.setList(documentDao.selectByExampleWithBLOBsAndPage(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<Document> getObjectList(DocumentExample example) {
		return documentDao.selectByExampleWithBLOBs(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(DocumentExample example) {
		return documentDao.countByExample(example);
	}

	
	
}
