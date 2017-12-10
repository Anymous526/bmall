package com.amall.core.service.user;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.User;
import com.amall.core.bean.UserConfig;
import com.amall.core.bean.UserConfigExample;
import com.amall.core.dao.UserConfigMapper;
import com.amall.core.dao.UserMapper;
import com.amall.core.security.support.SecurityUserHolder;
import com.amall.core.web.page.Pagination;

/**
 * 
 * <p>
 * Title: UserConfigServiceImpl
 * </p>
 * <p>
 * Description: 用户信息管理service
 * </p>
 * <p>
 * Company: www.hg-sem.com
 * </p>
 * 
 * @author ljx
 * @date 2015-4-28下午1:47:50
 * @version 1.0
 */
@Service
@Transactional
public class UserConfigServiceImpl implements IUserConfigService {

	@Resource
	private UserConfigMapper userConfigDao;

	@Resource
	private UserMapper userDAO;

	/**
	 * <p>
	 * Title: getUserConfig
	 * </p>
	 * <p>
	 * Description: 获得当前用户信息
	 * </p>
	 * 
	 * @return UserConfig
	 */
	public UserConfig getUserConfig() {
		// User u = SecurityUserHolder.getCurrentUser();
		// UserConfig config = null;
		// if (u != null) {
		// User user = (User) this.userDAO.selectByPrimaryKey(u.getId());
		// // if (user != null)
		// // config = user.getConfig();
		// } else {
		// config = new UserConfig();
		// }
		// return config;
		return new UserConfig();
	}

	public Long add(UserConfig example) {
		return userConfigDao.insertSelective(example);
	}

	public UserConfig getByKey(Long id) {
		return userConfigDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		return userConfigDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(UserConfigExample example) {
		return userConfigDao.deleteByExample(example);
	}

	public Integer updateByObject(UserConfig record) {
		return userConfigDao.updateByPrimaryKeySelective(record);
	}

	public Pagination getObjectListWithPage(UserConfigExample example) {
		Pagination p = new Pagination(example.getPageNo(),
				example.getPageSize(), userConfigDao.countByExample(example));
		p.setList(userConfigDao.selectByExampleWithPage(example));
		return p;
	}

	public List<UserConfig> getObjectList(UserConfigExample example) {
		return userConfigDao.selectByExample(example);
	}

	public Integer getObjectListCount(UserConfigExample example) {
		return userConfigDao.countByExample(example);
	}

}
