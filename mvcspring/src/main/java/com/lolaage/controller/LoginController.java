package com.lolaage.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lolaage.service.ILoginService;

@RequestMapping("/loginController")
@Controller
public class LoginController
{
    public static Logger log = Logger.getLogger(LoginController.class);
    
    @Resource
    private ILoginService loginService;
    
    @RequestMapping("/login")
    public String Login(String username, String password, ModelMap map)
    {
        System.out.println("test cache--" + loginService.getStudent());
        if (loginService.Login(username, password))
        {
            log.info("success.." + username + "-password:" + password);
            log.debug("debug msg");
            log.error("error msg");
            map.put("u", username);
            map.put("p", password);
            return "/pages/main";
        }
        else
        {
            map.put("msg", "帐号或密码错误!!!");
            log.info("msg--帐号或密码错误!!!");
            return "/pages/Login/login";
        }
        
    }
    
}
