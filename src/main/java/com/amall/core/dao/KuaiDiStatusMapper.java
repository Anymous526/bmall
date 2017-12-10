package com.amall.core.dao;

import com.amall.core.bean.KuaiDiStatus;

public interface KuaiDiStatusMapper {

	KuaiDiStatus selectKuaiDiStatus(String kuaidiNum);
	
	void updateKuaiDiStatus(KuaiDiStatus kuaiDiStatus);
	
	void insertKuaiDiStatus(KuaiDiStatus kuaiDiStatus);
}
