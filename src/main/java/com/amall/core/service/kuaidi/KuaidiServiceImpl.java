package com.amall.core.service.kuaidi;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.amall.core.bean.KuaiDiResultItem;
import com.amall.core.dao.KuaiDiResultItemMapper;

@Service
@Transactional
public class KuaidiServiceImpl implements IKuaidiService
{

	@Resource
	KuaiDiResultItemMapper kuaidiDao;

	@Override
	public List <KuaiDiResultItem> getKuaidiInfo (String kuaidiNum)
		{
			return kuaidiDao.selectByExample (kuaidiNum);
		}

	@Override
	public void delete (String kuaidiNum)
		{
			this.kuaidiDao.deleteByExample (kuaidiNum);
		}

	@Override
	public void save (KuaiDiResultItem item)
		{
			kuaidiDao.insert (item);
		}
}
