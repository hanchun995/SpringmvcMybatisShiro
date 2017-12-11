package com.duowan.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.duowan.pojo.User;

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception exception)
			throws Exception {

	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	/**
	 * 在进入action方法之前执行 true放行,false拦截
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// 获取请求的url
		String url = request.getRequestURI();
		// 判断url是否是公共的,公共的无需拦截(生成验证码的url不拦截)
		if (url.indexOf("loginUI") > -1 || url.indexOf("login") > -1 || url.indexOf("code") > -1) {
			return true;
		}
		// 判断用户是否已经登录,如果未登录,则进行拦截,跳转到登录页面
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("loginUser");
		if (user != null) {
			return true;
		} else {
			response.sendRedirect(request.getContextPath() + "/login");
			return false;
		}
	}

}
