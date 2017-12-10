package com.amall.core.service.kuaidi;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.KuaiTakeLog;
import com.amall.core.dao.KuaiTakeLogMapper;
@Service
@Transactional
public class IKuaidiServiceImpl implements IKuaidiTakeLogService {

	@Resource
	KuaiTakeLogMapper logDao;
	@Override
	public void save(KuaiTakeLog log) {
		logDao.insert(log);
	}

}
