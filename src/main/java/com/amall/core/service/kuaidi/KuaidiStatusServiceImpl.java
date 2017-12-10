package com.amall.core.service.kuaidi;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.KuaiDiStatus;
import com.amall.core.dao.KuaiDiStatusMapper;
@Service
@Transactional
public class KuaidiStatusServiceImpl implements IKuaidiStatusService{
	@Resource
	KuaiDiStatusMapper kuaidiStatusDao;
	
	@Override
	public void saveKuaiDiStatus(KuaiDiStatus kuaiDiStatus) {
		kuaidiStatusDao.insertKuaiDiStatus(kuaiDiStatus);
		
	}

	@Override
	public void updateKuaiDiStauts(KuaiDiStatus kuaidiStatus) {
		kuaidiStatusDao.updateKuaiDiStatus(kuaidiStatus);
		
	}

	@Override
	public KuaiDiStatus getKuaiDiStatus(String kuaidiNum) {
		return kuaidiStatusDao.selectKuaiDiStatus(kuaidiNum);
	}

}
