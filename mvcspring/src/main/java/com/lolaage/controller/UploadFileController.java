package com.lolaage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UploadFileController
{
    
    @RequestMapping("/upload")
    public String Upload(String fileName, String file, ModelMap modelMap)
    {
        System.out.println(fileName + "--->" + file);
        modelMap.put("success", "上传成功!!");
        return "main";
    }
    // pages/upload.html
}
