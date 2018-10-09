package org.andy.shop.service.Impl;

import java.util.List;

import org.andy.shop.dao.UserInfoDao;
import org.andy.shop.entity.UserInfo;
import org.andy.shop.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 创建时间：2015-1-30 上午11:40:19
 * 
 * @author andy
 * @version 2.2 实现接口
 */

@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	private UserInfoDao userInfoDao;

	public UserInfo getById(Integer id) {
		return userInfoDao.getById(id);
	}

	public List<UserInfo> findAll() {
		return userInfoDao.findAll();
	}

	public Integer save(UserInfo userInfo) {
		return userInfoDao.save(userInfo);
	}

}
