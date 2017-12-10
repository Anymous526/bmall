package com.amall.core.service.image;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.Accessory;
import com.amall.core.bean.AccessoryExample;
import com.amall.core.dao.AccessoryMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class AccessoryServiceImpl implements IAccessoryService {

	@Resource
	private AccessoryMapper accessoryDAO;

	public Long add(Accessory example) {
		return accessoryDAO.insertSelective(example);
	}

	public Accessory getByKey(Long id) {
		return accessoryDAO.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		return accessoryDAO.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(AccessoryExample example) {
		return accessoryDAO.deleteByExample(example);
	}

	public Integer updateByObject(Accessory record) {
		return accessoryDAO.updateByPrimaryKeySelective(record);
	}

	public Pagination getObjectListWithPage(AccessoryExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),accessoryDAO.countByExample(example));
		p.setList(accessoryDAO.selectByExampleWithPage(example));
		return p;
	}

	public List<Accessory> getObjectList(AccessoryExample example) {
		return accessoryDAO.selectByExample(example);
	}
	
	public List<Accessory> getObjectListWithBLOBs(AccessoryExample example) {
		return accessoryDAO.selectByExampleWithBLOBs(example);
	}

	public Integer getObjectListCount(AccessoryExample example) {
		return accessoryDAO.countByExample(example);
	}

	/**
	 * 通过goods_id获取商品图片集合
	 */
	public List<Accessory> getAccListOfGoodsByPhotoId(Long id) {
		return accessoryDAO.getAccListOfGoodsByPhotoId(id);
	}


}
