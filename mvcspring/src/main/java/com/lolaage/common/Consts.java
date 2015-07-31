package com.lolaage.common;

/**
 * 系统常量
 * 
 * @author Administrator
 *
 */
public interface Consts
{
    
    /**
     * http://blog.csdn.net/hambition/article/details/22578729 http://blog.csdn.net/hambition/article/details/22578939
     * 举例
     */
    /**
     * MybatisCallInterceptor 开始下标
     */
    public static final int MAPPED_STATEMENT_INDEX = 0;
    
    /**
     * MybatisCallInterceptor 参数下标
     */
    public static final int PARAMETER_INDEX = 1;
    
    /**
     * MybatisCallInterceptor 行号
     */
    public static final int ROWBOUNDS_INDEX = 2;
    
    /**
     * MybatisCallInterceptor 返回结果下标
     */
    public static final int RESULT_HANDLER_INDEX = 3;
    
    /**
     * boolean 失败，false
     */
    public static final boolean FAILURE = false;
    
    /**
     * boolean 成功,true
     */
    public static final boolean SUCCESS = true;
    
}
