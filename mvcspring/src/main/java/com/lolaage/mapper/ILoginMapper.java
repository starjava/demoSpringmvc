package com.lolaage.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;


public interface ILoginMapper {

	/**
	 * 验证是否登录成功
	 * @param username 用户名
	 * @param password 密码
	 * @return 验证帐号和密码是否正确
	 */
	public Boolean Login(@Param("uname")String username,@Param("password")String password);
	
	public void getCount(@Param("paramMap")Map<String, Integer> paramMap);
	public void PRO_DEMO1(Map<String, Integer> paramMaps);
	public List<Map> getUserInfos();
}
