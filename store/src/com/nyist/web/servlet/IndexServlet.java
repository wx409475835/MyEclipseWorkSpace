package com.nyist.web.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 和 首页相关的
 * @author LHG
 *
 */
public class IndexServlet extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String index(HttpServletRequest request, HttpServletResponse response){
		return "/jsp/index.jsp";
	}
}