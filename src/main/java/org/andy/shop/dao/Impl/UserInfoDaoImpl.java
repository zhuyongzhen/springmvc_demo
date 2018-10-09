package org.andy.shop.dao.Impl;

import java.util.List;

import org.andy.shop.dao.UserInfoDao;
import org.andy.shop.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * 创建时间：2015-1-30 上午11:25:30
 * 
 * @author andy
 * @version 2.2
 * 
 * UserInfoDao实现类
 */
@Repository("userInfoDao")
public class UserInfoDaoImpl implements UserInfoDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public UserInfo getById(Integer id) {

		String sql = "SELECT * FROM user_info WHERE id = ?";

		UserInfo userInfo = jdbcTemplate.queryForObject(sql, new UserInfo(),
				new Object[] { id });

		return userInfo;
	}

	public List<UserInfo> findAll() {
		String sql = "SELECT * FROM user_info";
		List<UserInfo> userInfos = jdbcTemplate.query(sql, new UserInfo());
		return userInfos;
	}

	public Integer save(UserInfo entity) {
		
		String sql = "INSERT INTO user_info(uname, unumber, uregister_time) VALUES(:uname, :unumber, :uregister_time)";
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("uname", entity.getUname());
		paramSource.addValue("unumber", entity.getUnumber());
		paramSource.addValue("uregister_time", entity.getuRegisterTime());
		int result = namedParameterJdbcTemplate.update(sql, paramSource);
		
		return result;
	}

}
