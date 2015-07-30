package com.lolaage.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lolaage.entity.Login;
import com.lolaage.service.ILoginService;

/**
 * 
 * @ClassName: LoginController
 * @Description: TODO该类的介绍
 * @author Comsys-Administrator-2015年6月25日 上午11:37:01
 */
@RequestMapping("/loginController")
@Controller
public class LoginController
{
    
    public static Logger log = Logger.getLogger(LoginController.class);
    
    @Resource
    private ILoginService loginService;
    
    @RequestMapping("/login")
    public String login(HttpSession session, @Valid Login login, BindingResult result, ModelMap map)
    {
        String rand = (String)session.getAttribute("rand");
        rand = rand == null ? "" : rand;
        System.out.println(login.toString());
        if (result.hasErrors() || !rand.equals(login.getVcodetxt()))
        {
            return "Login/login";
        }
        if (loginService.Login(login.getUsername(), login.getPassword()))
        {
            log.info("success.." + login.getUsername() + "-password:" + login.getPassword());
            map.put("name", login.getUsername());
            map.put("pass", login.getPassword());
            return "main";
        }
        else
        {
            map.put("msg", "帐号或密码错误!!!");
            log.info("msg--帐号或密码错误!!!");
            return "Login/login";
        }
        
    }
}
