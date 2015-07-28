package com.lolaage.entity;

import java.io.Serializable;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Component("loginInfoVO")
public class Login implements Serializable
{
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * 用户名
     */
    @Pattern(regexp = "^[a-zA-Z0-9_]{5,20}$", message = "{username.length}")
    private String username;
    
    /**
     * 密码
     */
    @NotEmpty(message = "{password.null}")
    @Size(min = 6, max = 26, message = "{password.length}")
    private String password;
    
    /**
     * 登录IPַ
     */
    private String localIp;
    
    public String getUsername()
    {
        return username;
    }
    
    public void setUsername(String username)
    {
        this.username = username;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    public String getLocalIp()
    {
        return localIp;
    }
    
    public void setLocalIp(String localIp)
    {
        this.localIp = localIp;
    }
    
    public String toString()
    {
        return String.format("LoginVo [username=%s, password=%s,localIp=%s]", username, password, localIp);
    }
    
}
