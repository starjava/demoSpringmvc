package com.lolaage.ihandler.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.mapping.ParameterMapping;

import com.loalage.ihandler.ICallResultHandler;
/**
 * 自定义结果集处理类，自定义拦截器调用
 * @author nwang 2015-04-26
 *
 */
public class CallResultHandler implements ICallResultHandler {

	@Override
	public Object process(List<ParameterMapping> parameterMappings,
			Map<String, Object> result) {
		// TODO Auto-generated method stub
		return null;
	}

}
