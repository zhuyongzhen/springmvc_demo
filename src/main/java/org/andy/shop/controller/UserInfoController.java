package org.andy.shop.controller;

import java.util.ArrayList;
import java.util.List;

import org.andy.shop.entity.UserInfo;
import org.andy.shop.service.UserInfoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 创建时间：2015-2-1 下午9:40:03
 * 
 * @author andy
 * @version 2.2
 * 
 * userInfo的控制层
 */
@Controller
@RequestMapping("/user")
public class UserInfoController {

	private static final Logger LOGGER = Logger
			.getLogger(UserInfoController.class);
	@Autowired
	private UserInfoService userInfoService;

	@RequestMapping("/showInfo/{userId}")
	public String showUserInfo(ModelMap modelMap, @PathVariable int userId) {
		LOGGER.info("查看用户：" + userId);
//		UserInfo userInfo = userInfoService.getById(1);
//		modelMap.addAttribute("userInfo", userInfo);
		return "/user/showInfo";
	}

	@RequestMapping("/showInfos")
	public @ResponseBody List<UserInfo> showUserInfos() {
		LOGGER.info("json返回全部用户的信息");
//		List<UserInfo> userInfos = userInfoService.findAll();
		List<UserInfo> userInfos = new ArrayList<UserInfo>();
		return userInfos;
	}
}
