package com.hwig.admin.common;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession(false);
		if (session != null) {
			Object obj = session.getAttribute("user");
			if (obj != null) {
				return true;
			}

			request.setAttribute("loginMsg", "fail");
			/*
			 * response.sendRedirect(request.getContextPath() + "/loginForm");
			 * sendRedirect�뒗 request, response�쓽 紐⑤뱺 attribute瑜� 吏��슫�떎
			 */
			RequestDispatcher rd = request.getRequestDispatcher("/loginForm");
			rd.forward(request, response);
			return false;
		}

		return true;
	}

}