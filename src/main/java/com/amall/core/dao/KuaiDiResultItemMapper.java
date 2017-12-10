package com.amall.core.dao;

import com.amall.core.bean.KuaiDiResultItem;
import com.amall.core.bean.KuaiDiStatus;
import java.util.List;

public interface KuaiDiResultItemMapper
{

	int deleteByExample (String kuaidiNum);

	int insert (KuaiDiResultItem record);

	List <KuaiDiResultItem> selectByExample (String kuaidiNum);

	int insertKuaiDiStatus (KuaiDiStatus kuaiDiStatus);

	int updateKuaiDiStatus (KuaiDiStatus kuaiDiStatus);
}