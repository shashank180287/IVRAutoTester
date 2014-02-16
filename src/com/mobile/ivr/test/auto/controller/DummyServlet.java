package com.mobile.ivr.test.auto.controller;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class DummyServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String username = req.getParameter("uname");
		String password = req.getParameter("password");
		resp.getWriter().write("Successfully login with username as "+username+" and password as "+password);
	}
}
