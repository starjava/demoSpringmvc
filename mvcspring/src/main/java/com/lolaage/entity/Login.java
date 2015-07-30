package com.lolaage.entity;

import java.io.Serializable;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Component
public class Login implements Serializable
{
    public Login()
    {
        
    }
    
    public Login(String username, String password, String localIp)
    {
        this.username = username;
        this.password = password;
        this.localIp = localIp;
    }
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * 用户名
     */
    @NotEmpty(message = "{message.content.empty}")
    @Pattern(regexp = "^[a-zA-z][a-zA-Z0-9_]{5,20}$", message = "{username.content.length}")
    private String username;
    
    /**
     * 密码
     */
    @NotEmpty(message = "{message.content.empty}")
    @Size(min = 6, max = 26, message = "{message.content.length}")
    private String password;
    
    /**
     * 登录IPַ
     */
    private String localIp;
    
    @NotEmpty(message = "{message.content.empty}")
    private String vcodetxt;
    
    public String getVcodetxt()
    {
        return vcodetxt;
    }
    
    public void setVcodetxt(String vcodetxt)
    {
        this.vcodetxt = vcodetxt;
    }
    
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
        return String.format("LoginVo [username=%s, password=%s,localIp=%s,vcodetxt=%s]",
            username,
            password,
            localIp,
            vcodetxt);
    }
    
}
