package com.lolaage.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.lolaage.mapper.ILoginMapper;
import com.lolaage.service.ILoginService;

@Service
public class LoginService implements ILoginService
{
    
    @Resource
    private ILoginMapper logindao;
    
    /**
     * 验证是否登录成功
     * 
     * @param username 用户名
     * @param password 密码
     * @return 验证帐号和密码是否正确
     */
    @Override
    public boolean Login(String username, String password)
    {
        PageHelper.startPage(1, 10);
        // return null == logindao.Login(username, password) ? false : true;
        return true;
    }
    
    @Override
    public List<Map<String, Object>> getStudent()
    {
        
        return logindao.getStudent();
    }
    
}
