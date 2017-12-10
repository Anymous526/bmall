package com.amall.core.service.user;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.BuZhu;
import com.amall.core.bean.BuZhuExample;
import com.amall.core.bean.FengHong;
import com.amall.core.bean.FengHongExample;
import com.amall.core.bean.Role;
import com.amall.core.bean.User;
import com.amall.core.bean.UserExample;
import com.amall.core.dao.BuZhuMapper;
import com.amall.core.dao.FengHongMapper;
import com.amall.core.dao.UserMapper;
import com.amall.core.security.support.SecurityManagerSupport;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

	@Resource
	private UserMapper  userDAO;
	
	@Resource
	private SecurityManagerSupport securityManager;
	
	@Resource
	private BuZhuMapper buZhuMapper;
	
	@Resource
	private FengHongMapper fengHongMapper;
	
	public Long add(User example) {
		return userDAO.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public User getByKey(Long id) {
		return userDAO.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		return userDAO.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(UserExample example) {
		return userDAO.deleteByExample(example);
	}

	public Integer updateByObject(User record) {
		int rs = userDAO.updateByPrimaryKeyWithBLOBs(record);
		securityManager.loadUserByUsername(record.getUsername());
		return rs;
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(UserExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),userDAO.countByExample(example));
		p.setList(userDAO.selectByExampleWithBLOBsAndPage(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<User> getObjectList(UserExample example) {
		return userDAO.selectByExampleWithBLOBs(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(UserExample example) {
		return userDAO.countByExample(example);
	}
	@Transactional(readOnly=true)
	public List<Role> findRoleByUserId(Map map) {
		return userDAO.selectRoleByUserId(map);
	}
	public int insertUserRole(Map map) {
		return userDAO.insertUserRole(map);
	}
	@Override
	public User getUserOfUserName(String username)
	{
		UserExample example = new UserExample();
		example.createCriteria().andUsernameEqualTo(username);
		List<User> user = getObjectList(example);
		
		if(user.isEmpty())
		{
			return null;
		}
		return user.get(0);
	}
	@Override
	public Integer findTotalMember(Long userId) {
		/**
		 * 查询直接推荐的总数
		 */
		UserExample userExample = new UserExample();
		userExample.clear();
		userExample.createCriteria().andDirectReferEqualTo(userId);
		/*直接推荐人列表*/
		List<User> listDirectReferUser = getObjectList(userExample);
		Integer directUserCount = listDirectReferUser.size();
		userExample.clear();
		/**
		 * 查询间接和三级推荐的总数
		 */
		Integer indirectUserCount = 0;
		Integer superUserCount = 0;
		Integer sumUserCount = 0;
		for(User directRefer : listDirectReferUser){
			userExample.createCriteria().andDirectReferEqualTo(directRefer.getId());
			List<User> listIndirectReferUser = getObjectList(userExample);
			Integer indirectTempCount = listIndirectReferUser.size();
			indirectUserCount = indirectUserCount + indirectTempCount;
			userExample.clear();
			
			for(User indirectRefer : listIndirectReferUser){
				userExample.createCriteria().andDirectReferEqualTo(indirectRefer.getId());
				Integer superTempCount = getObjectListCount(userExample);
				superUserCount = superUserCount + superTempCount;
				userExample.clear();
			}
		}
		sumUserCount = directUserCount + indirectUserCount + superUserCount;
		return sumUserCount;
	}
	
	public Integer updateUsers(User record) {
		int rs = userDAO.updateByPrimaryKeySelective(record);
		return rs;
	}

	@Transactional(readOnly=true)
	public List<BuZhu> selectBuZhu(BuZhuExample example) {
		return buZhuMapper.selectByExample(example);
	}
	@Transactional(readOnly=true)
	public List<FengHong> selectFengHong(FengHongExample example) {
		return fengHongMapper.selectByExample(example);
	}
	
}
