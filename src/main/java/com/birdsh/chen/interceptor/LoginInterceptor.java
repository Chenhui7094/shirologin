package com.birdsh.chen.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.alibaba.fastjson.JSONObject;
import com.birdsh.chen.entity.RespCodeConstant;
import com.birdsh.chen.entity.User;

import lombok.extern.slf4j.Slf4j;

/**
 * 处理请求的拦截器
 * 
 * @author chenhuihui
 *
 */
@Slf4j
public class LoginInterceptor extends HandlerInterceptorAdapter {

	/**
	 * 预处理回调方法，实现处理器的预处理（如登录检查）。 第三个参数为响应的处理器，即controller。
	 * 返回true，表示继续流程，调用下一个拦截器或者处理器。 返回false，表示流程中断，通过response产生响应。
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO 验证用户是否登陆---------session不可行
		User user = (User) request.getSession().getAttribute("User");
		if (user.getId() == null) {
			log.info("用户未登录");
			response.setContentType("application/json;charset=UTF-8");
			response.getWriter().print(JSONObject.toJSONString(RespCodeConstant.Error));
			return false;
		}
		return true;

	}

}
