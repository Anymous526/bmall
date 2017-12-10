package com.amall.core.service.system;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.Accessory;
import com.amall.core.bean.SysConfig;
import com.amall.core.bean.SysConfigExample;
import com.amall.core.bean.SysConfigWithBLOBs;
import com.amall.core.dao.SysConfigMapper;

@Service
@Transactional
public class SysConfigService implements ISysConfigService {

	@Resource
	private SysConfigMapper sysConfigDAO;
	
	@Transactional(readOnly=true)
	public SysConfigWithBLOBs getSysConfig() {
		SysConfigExample configExample = new SysConfigExample();
		List<SysConfigWithBLOBs> configs = this.sysConfigDAO.selectByExampleWithBLOBs(configExample);
		if ((configs != null) && (configs.size() > 0)) {
			SysConfigWithBLOBs sc = (SysConfigWithBLOBs) configs.get(0);
			if (sc.getUploadfilepath() == null) {
				sc.setUploadfilepath("upload");
			}
			if (sc.getSyslanguage() == null) {
				sc.setSyslanguage("zh_cn");
			}
			if ((sc.getWebsitename() == null)
					|| (sc.getWebsitename().equals(""))) {
				sc.setWebsitename("amall");
			}
			if ((sc.getClosereason() == null)
					|| (sc.getClosereason().equals(""))) {
				sc.setClosereason("系统维护中...");
			}
			if ((sc.getTitle() == null) || (sc.getTitle().equals(""))) {
				sc.setTitle("天使多用户商城系统");
			}
			if ((sc.getImagesavetype() == null)
					|| (sc.getImagesavetype().equals(""))) {
				sc.setImagesavetype("sidImg");
			}
			if (sc.getImagefilesize() == 0) {
				sc.setImagefilesize(1024);
			}
			if (sc.getSmallwidth() == 0) {
				sc.setSmallwidth(160);
			}
			if (sc.getSmallheight() == 0) {
				sc.setSmallheight(160);
			}
			if (sc.getMiddlewidth() == 0) {
				sc.setMiddlewidth(300);
			}
			if (sc.getMiddleheight() == 0) {
				sc.setMiddleheight(300);
			}
			if (sc.getBigheight() == 0) {
				sc.setBigheight(1024);
			}
			if (sc.getBigwidth() == 0) {
				sc.setBigwidth(1024);
			}
			if ((sc.getImagesuffix() == null)
					|| (sc.getImagesuffix().equals(""))) {
				sc.setImagesuffix("gif|jpg|jpeg|bmp|png|tbi");
			}
			if (sc.getStoreimageId() == null) {
				Accessory storeImage = new Accessory();
				storeImage.setPath("resources/style/common/images");
				storeImage.setName("store.jpg");
				sc.setStoreimageId(storeImage.getId());
			}
			if (sc.getGoodsimageId() == null) {
				Accessory goodsImage = new Accessory();
				goodsImage.setPath("resources/style/common/images");
				goodsImage.setName("good.jpg");
				sc.setGoodsimageId(goodsImage.getId());
			}
			if (sc.getMembericonId() == null) {
				Accessory memberIcon = new Accessory();
				memberIcon.setPath("resources/style/common/images");
				memberIcon.setName("member.jpg");
				sc.setMembericonId(memberIcon.getId());
			}
			if ((sc.getSecuritycodetype() == null)
					|| (sc.getSecuritycodetype().equals(""))) {
				sc.setSecuritycodetype("normal");
			}
			if ((sc.getWebsitecss() == null) || (sc.getWebsitecss().equals(""))) {
				sc.setWebsitecss("default");
			}
			return sc;
		}
		SysConfigWithBLOBs sc = new SysConfigWithBLOBs();
		sc.setUploadfilepath("upload");
		sc.setWebsitename("天使");
		sc.setSyslanguage("zh_cn");
		sc.setTitle("amall多用户商城系统");
		sc.setSecuritycodetype("normal");
		sc.setEmailenable(true);
		sc.setClosereason("系统维护中...");
		sc.setImagesavetype("sidImg");
		sc.setImagefilesize(1024);
		sc.setSmallwidth(160);
		sc.setSmallheight(160);
		sc.setMiddleheight(300);
		sc.setMiddlewidth(300);
		sc.setBigheight(1024);
		sc.setBigwidth(1024);
		sc.setImagesuffix("gif|jpg|jpeg|bmp|png|tbi");
		sc.setComplaintTime(30);
		sc.setWebsitecss("default");
		
		Accessory goodsImage = new Accessory();
		goodsImage.setPath("resources/style/common/images");
		goodsImage.setName("good.jpg");
		sc.setGoodsimageId(goodsImage.getId());
		Accessory storeImage = new Accessory();
		storeImage.setPath("resources/style/common/images");
		storeImage.setName("store.jpg");
		sc.setStoreimageId(storeImage.getId());
		Accessory memberIcon = new Accessory();
		memberIcon.setPath("resources/style/common/images");
		memberIcon.setName("member.jpg");
		sc.setMembericonId(memberIcon.getId());
		return sc;
	}


	public Long add(SysConfigWithBLOBs bloBs ) {
		return sysConfigDAO.insertSelective(bloBs);
	}

	public SysConfig getByKey(Long id) {
		return sysConfigDAO.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		return 0;
	}

	public Integer updateByObject(SysConfigWithBLOBs record) {
		return sysConfigDAO.updateByPrimaryKeySelective(record);
	}
	public Integer deleteByExample(SysConfigExample example) {
		return 0;
	}

	public List<SysConfigWithBLOBs> getObjectList(SysConfigExample example) {
		List<SysConfigWithBLOBs> selectByExampleWithBLOBs = sysConfigDAO.selectByExampleWithBLOBs(example);
		return selectByExampleWithBLOBs;
	}

}
