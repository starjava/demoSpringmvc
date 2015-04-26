package com.loalage.ihandler;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.mapping.ParameterMapping;

/**
 * 自定义结果集处理类，自定义拦截器调用
 * @author nwang 2015-04-26
 *
 */
public interface ICallResultHandler {

	/**
	 * 处理返回结果集
	 */
	public Object process(List<ParameterMapping> parameterMappings, Map<String, Object> result);
}
