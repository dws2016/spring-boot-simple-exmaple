package com.joytiger.cihui.base;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

/**
 * 全局异常处理
 * @author dws
 * @date 2016-11-4
 *
 */
@ControllerAdvice
public class GlobalDefaultExceptionHandler {
	
	private static JSONObject result = new JSONObject();
	
	Logger logger = LoggerFactory.getLogger(GlobalDefaultExceptionHandler.class);

	@ExceptionHandler(value=Exception.class)
	@ResponseBody
	public String defaultErrorHandler(HttpServletRequest req,Exception e){
		e.printStackTrace();
		logger.error("全局异常:"+e.getMessage());
		result.put("errorInfo", e.getMessage());
		return result.toJSONString();
	}
	
	@ExceptionHandler(value=JSONException.class)
	@ResponseBody
	public String jsonErrorHandler(HttpServletRequest req,JSONException e){
		logger.error("json异常:",e);
		result.put("errorInfo", "json解析失败,请检查格式!");
		return result.toJSONString();
	}
}
