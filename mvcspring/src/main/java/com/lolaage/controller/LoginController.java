package com.lolaage.controller;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    public String login(@Valid @ModelAttribute Login loginVo, BindingResult result, ModelMap map)
    {
        System.out.println(loginVo.toString());
        if (result.hasErrors())
        {
            return "pages/Login/login";
        }
        if (loginService.Login(loginVo.getUsername(), loginVo.getPassword()))
        {
            log.info("success.." + loginVo.getUsername() + "-password:" + loginVo.getPassword());
            log.debug("debug msg");
            log.error("error msg");
            map.put("name", loginVo.getUsername());
            map.put("pass", loginVo.getPassword());
            return "pages/main";
        }
        else
        {
            map.put("msg", "帐号或密码错误!!!");
            log.info("msg--帐号或密码错误!!!");
            return "pages/Login/login";
        }
        
    }
    
}
