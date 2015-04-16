package com.lolaage.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;

import com.lolaage.service.ILoginService;
@RequestMapping("/loginController")
@Controller
public class LoginController {

	@Resource
	private ILoginService loginService;
	@RequestMapping("/login")
	public String Login(String username,String password,ModelMap map){
		if(loginService.Login(username,password)){
			System.out.println("success.."+username+"-password:"+password);
			map.put("u", username);
			map.put("p", password);
			return "/pages/main";	
		}
		else{
			map.put("msg", "帐号或密码错误!!!");
			System.out.println("back login");
			return "/pages/Login/login";
		}
//		

	}
	
}
