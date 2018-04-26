package com.me.database.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

import org.springframework.web.bind.annotation.ModelAttribute;

import com.me.database.dao.AdminDAO;
import com.me.database.dao.UserDAO;
import com.me.database.pojo.Admin;
import com.me.database.pojo.Genre;
import com.me.database.pojo.User;

@WebFilter(filterName="filterOne", urlPatterns = {"/login.htm"})
public class FilterOne implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse res=(HttpServletResponse)response;
		HttpSession session=req.getSession();
			String username=req.getParameter("userName");
			String password=req.getParameter("password");
			
			UserDAO userdao=new UserDAO();
			List<User> users=new ArrayList<User>();
			users=userdao.GetUsers();
			int flag=0;
			for(User A:users){
				if(A.getUserName().equals(username))flag=1;
			}
			
			AdminDAO admindao=new AdminDAO();
			List<Admin> admins=admindao.Getadmins();
			
			for(Admin B:admins)
			{	
				if(B.getAdminName().equals(username))flag=1;
			}
			
			if(flag==0){
				session.setAttribute("cannot", "No such Username exists!!");
			}
			else{
				session.setAttribute("cannot", "fine");
				
			}
			
		chain.doFilter(request, response);
	}
	@Override
	public void destroy() {
	}
} 