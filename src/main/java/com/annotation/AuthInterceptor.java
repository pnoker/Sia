package com.annotation;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.Sia.controller.MainController;
import com.Sia.model.Users;
import com.Sia.service.UserService;

public class AuthInterceptor extends HandlerInterceptorAdapter {
	static final Logger logger = LogManager.getLogger(AuthInterceptor.class);// 日志
	@Autowired
	private UserService userService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		if (handler.getClass().isAssignableFrom(HandlerMethod.class)) {
			AuthPassport authPassport = ((HandlerMethod) handler).getMethodAnnotation(AuthPassport.class);
			// 没有声明需要权限,或者声明不验证权限
			if (authPassport == null || authPassport.validate() == false)
				return true;
			else {
				HttpSession session = request.getSession();
				boolean isPermit = false;
				int id = 0, authorId = 0;
				try {
					id = (int) session.getAttribute("userId");
					String userName = (String) session.getAttribute("userName");
					logger.info("用户ID为：" + id);
					Users user = userService.selectByPrimaryKey(id);
					if (user.getUsername().equals(userName)) {
						isPermit = true;
					} else {
						logger.info("用户名不匹配，跳转登录页面进行登录！");
					}
				} catch (Exception e) {
					logger.info("用户ID为空，跳转登录页面进行登录！");
				}
				if (isPermit) {
					return true;
				} else {
					String path = request.getContextPath();
					PrintWriter out = response.getWriter();
					out.println("<html>");
					out.println("<script>");
					out.println("alert('用户没有登录或者权限不够，请重新登录！');");
					out.println("window.open ('" + path + "','_top')");
					out.println("</script>");
					out.println("</html>");
				}
			}
		}
		return true;
	}
}