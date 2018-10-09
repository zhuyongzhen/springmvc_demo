package org.andy.shop.test.service;

import java.util.Date;
import java.util.List;

import org.andy.shop.entity.UserInfo;
import org.andy.shop.service.UserInfoService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

/**
 * 创建时间：2015-1-30 下午12:01:47
 * 
 * @author andy
 * @version 2.2
 */
// 引入Spring环境测试
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class TestUserInfoService {

	private static final Logger LOGGER = Logger
			.getLogger(TestUserInfoService.class);
	@Autowired
	private UserInfoService userInfoService;

	@Test
	public void testGetById() {
		//测试查询对应的用户
		UserInfo userInfo = userInfoService.getById(1);
		LOGGER.info(JSON.toJSONStringWithDateFormat(userInfo,
				"yyyy-MM-dd HH:mm:ss"));
	}

	@Test
	public void testFindAll() {
		//测试查询全部用户
		List<UserInfo> userInfos = userInfoService.findAll();
		for (UserInfo userInfo : userInfos) {
			LOGGER.info(JSON.toJSONStringWithDateFormat(userInfo,
					"yyyy-MM-dd HH:mm:ss"));
		}
	}

	@Test
	public void testSave() {
		//测试保存用户数据
		UserInfo userInfo = new UserInfo();
		userInfo.setUname("xiaohonghong");
		userInfo.setUnumber(5);
		userInfo.setuRegisterTime(new Date());
		int result = userInfoService.save(userInfo);
		LOGGER.info("result = " + result);
	}
}
