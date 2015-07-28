package com.lolaage.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class IssueMessageBO
{
    @NotNull(message = "{message.content.empty}")
    // 将验证消息写在classpath下message.properties
    @Size(min = 2, max = 140, message = "{message.content.length}")
    private String content;// 发布内容
    
    public String getContent()
    {
        return content;
    }
    
    public void setContent(String content)
    {
        this.content = content;
    }
    
    public String getQiniuImgInfo()
    {
        return qiniuImgInfo;
    }
    
    public void setQiniuImgInfo(String qiniuImgInfo)
    {
        this.qiniuImgInfo = qiniuImgInfo;
    }
    
    public String getSchoolIds()
    {
        return schoolIds;
    }
    
    public void setSchoolIds(String schoolIds)
    {
        this.schoolIds = schoolIds;
    }
    
    public int getPublisherType()
    {
        return publisherType;
    }
    
    public void setPublisherType(int publisherType)
    {
        this.publisherType = publisherType;
    }
    
    public boolean isHasTop()
    {
        return hasTop;
    }
    
    public void setHasTop(boolean hasTop)
    {
        this.hasTop = hasTop;
    }
    
    public int getTopDay()
    {
        return topDay;
    }
    
    public void setTopDay(int topDay)
    {
        this.topDay = topDay;
    }
    
    private String qiniuImgInfo;// 七牛图片信息
    
    @NotNull(message = "{message.schoolIds.empty}")
    private String schoolIds;// 学校
    
    private int publisherType;// 发布者类型
    
    private boolean hasTop;// 是否置顶
    
    private int topDay; // 置顶的天数
    
}
