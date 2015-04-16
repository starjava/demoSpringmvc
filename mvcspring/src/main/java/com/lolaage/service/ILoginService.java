package com.lolaage.service;

import org.apache.ibatis.annotations.Param;

public interface ILoginService {

	/**
	 * 验证是否登录成功
	 * @param username 用户名
	 * @param password 密码
	 * @return 验证帐号和密码是否正确
	 */
	public boolean Login(@Param("uname")String username,@Param("password")String password);
}
