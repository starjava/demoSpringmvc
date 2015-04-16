package com.lolaage.service.test;


import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

import com.lolaage.service.ILoginService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"classpath:spring.xml","classpath:spring-mybatis.xml"})
public class LoginServiceTest {
	@Resource
	private ILoginService loginService;
	@Test
	public void login(){
		boolean b=loginService.Login("admin","123456");
		assertTrue(b);
		System.out.println("帐号密码是否正确:"+b);
	}
}
