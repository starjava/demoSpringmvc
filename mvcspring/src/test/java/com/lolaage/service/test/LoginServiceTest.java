package com.lolaage.service.test;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lolaage.mapper.ILoginMapper;
import com.lolaage.service.ILoginService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"classpath:spring.xml","classpath:spring-mybatis.xml"})
public class LoginServiceTest {
	@Resource
	private ILoginService loginService;
	@Resource
	private ILoginMapper logindao;
	@Test
	public void login(){
//		boolean b=loginService.Login("admin","123456");
//		assertTrue(b);
//		System.out.println("帐号密码是否正确:"+b);
	}
	/**
	 * 测试接收存储过程的单个值，并打印
	 */
	@Test
	public void test_Pro(){
		Map<String, Integer> paramMaps = new HashMap<String, Integer>();
		paramMaps.put("userId", 0);
		paramMaps.put("count", -1);
		logindao.getCount(paramMaps); 
		System.out.println("返回单个参数"+paramMaps.get("count"));
		
	}
	/**
	 * 测试接收存储过程的结果集，并打印
	 */
	@Test
	public void test_getUserInfos(){
		System.out.println("返回1个结果集,多参数且多行-"+logindao.getUserInfos());
	}
	@Test
	public void test_getUserMoreCounts(){
		Map<String, Integer> paramMaps = new HashMap<String, Integer>();
		paramMaps.put("userId", 0);
		paramMaps.put("boy_count", -1);
		paramMaps.put("girl_count", -1);
		logindao.getUserMoreCounts(paramMaps);
		System.out.println("返回多结果集：size="+paramMaps.size()+"boy_count="
		+paramMaps.get("boy_count")+" girl_count="+paramMaps.get("girl_count"));
	}
	@Test
	public void test_getUserMoreUsers(){
		List<List<?>> results=logindao.getUserMoreUsers();
		System.out.println("返回多结果集--"+results);
	}
	
}
