package com.lolaage.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;


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
	/**
	 * 返回多结果集(1行)
	 * @param paramMap
	 * @return
	 */
	public void getUserMoreCounts(@Param("paramMap")Map<String,Integer>paramMap);
	/**
	 * 返回多结果集(多行)
	 * @param paramMap
	 * @return
	 */
	public List<List<?>> getUserMoreUsers();
	
}
