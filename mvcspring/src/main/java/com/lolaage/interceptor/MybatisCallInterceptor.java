package com.lolaage.interceptor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.mapping.ParameterMode;
import org.apache.ibatis.mapping.StatementType;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.log4j.Logger;

import com.loalage.ihandler.ICallResultHandler;
import com.lolaage.common.Consts;
import com.lolaage.ihandler.impl.CallResultHandler;

/**
 * 拦截调用存储过程时返回结果集和传入参数的问题 暂时没使用
 * 
 * @author nwang 2015-04-26
 *
 */
@Intercepts({@Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class,
    RowBounds.class, ResultHandler.class})})
public class MybatisCallInterceptor implements Interceptor
{
    
    public ICallResultHandler callResultHandler = new CallResultHandler();
    
    /**
     * 记录日志信息
     */
    public static Logger log = Logger.getLogger(MybatisCallInterceptor.class);
    
    /**
     * 用于处理代理类的执行,对传入的参数进行拦截,并处理
     */
    @Override
    public Object intercept(Invocation invocation)
        throws Throwable
    {
        // final Executor executor = (Executor) invocation.getTarget();
        // 获取参数
        final Object[] queryArgs = invocation.getArgs();
        
        final MappedStatement ms = (MappedStatement)queryArgs[Consts.MAPPED_STATEMENT_INDEX];
        final Object parameter = queryArgs[Consts.PARAMETER_INDEX];
        
        if (!ms.getStatementType().equals(StatementType.CALLABLE))
        {
            return invocation.proceed();
        }
        
        BoundSql boundSql = ms.getBoundSql(parameter);
        List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();
        
        Map<String, Object> parameterMap = new HashMap<String, Object>();
        if (parameter instanceof Map)
        {
            parameterMap = (Map)parameter;
        }
        else
        {
            for (ParameterMapping parameterMapping : parameterMappings)
            {
                if (parameterMapping.getMode().equals(ParameterMode.IN)
                    || parameterMapping.getMode().equals(ParameterMode.INOUT))
                {
                    parameterMap.put(parameterMapping.getProperty(), parameter);
                }
            }
        }
        
        for (ParameterMapping parameterMapping : parameterMappings)
        {
            if (parameterMapping.getMode().equals(ParameterMode.OUT))
            {
                parameterMap.put(parameterMapping.getProperty(), null);
            }
        }
        
        queryArgs[Consts.PARAMETER_INDEX] = parameterMap;
        
        invocation.proceed();
        
        return callResultHandler.process(parameterMappings, parameterMap);
    }
    
    /**
     * 用于某些处理器(Handler)的构建过程
     */
    @Override
    public Object plugin(Object target)
    {
        return Plugin.wrap(target, this);
    }
    
    /**
     * 用于拦截器属性的设置
     */
    @Override
    public void setProperties(Properties properties)
    {
        
    }
    
}
