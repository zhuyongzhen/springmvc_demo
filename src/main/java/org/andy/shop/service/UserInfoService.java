package org.andy.shop.service;

import java.util.List;
import org.andy.shop.entity.UserInfo;

/**
 * 创建时间：2015-1-30 上午11:31:34
 * 
 * @author andy
 * @version 2.2
 * 
 * UserInfoService 接口
 */

public interface UserInfoService {

	// 通过Id查询UserInfo
	UserInfo getById(Integer id);

	// 查询全部的UserInfo
	List<UserInfo> findAll();

	// 添加UserInfo
	Integer save(UserInfo userInfo);

}
