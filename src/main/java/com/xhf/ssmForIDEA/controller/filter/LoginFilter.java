package com.xhf.ssmForIDEA.controller.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xhf.ssmForIDEA.pojo.User;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/LoginFilter")
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		 	
		
			HttpServletRequest req = (HttpServletRequest) request;
	        HttpServletResponse res = (HttpServletResponse)response;
	        // 有几个路径不需要判断,将它们排除   例如我的是"/login.do"
	        String[] paths = new String[] { "/toLogin","/toRegister","/Register","/login.do","/toIndex" };
	        String sp = req.getServletPath();
	        for (String path : paths) {
	            // 当前路径是这几个之一
	            if (path.equals(sp)) {
	                // 让请求继续执行,无需判断是否登录
	                chain.doFilter(request, response);
	                return;
	            }
	        }
	        // 判断用户是否登录
	        HttpSession session = req.getSession();
	        User user = (User) session.getAttribute("user");
	        if (user == null) {
	            // 未登录,重定向到登录页面
	            req.getRequestDispatcher("/toLogin.do").forward(req, res);
	        } else {
	            // 已登录,请求继续执行
	            chain.doFilter(req, res);
	        }

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
