package org.samrt4j.chapter2.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.samrt4j.chapter2.model.service.CustomerService;


@WebServlet("/customer_add")
public class CustomerAddServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Map<String,Object> map = new HashMap<String,Object>();
		
        String name = request.getParameter("name");
        String contact = request.getParameter("contact");
        String telephone = request.getParameter("telephone");
        String email = request.getParameter("email");
        String remark = request.getParameter("remark");
        
        map.put("name",name);
        map.put("contact",contact);
        map.put("telephone",telephone);
        map.put("email",email);
        map.put("remark", remark);
        
        CustomerService customerService = new CustomerService();
        boolean result = customerService.createCustomer(map);
        
		//request.getRequestDispatcher("customer").forward(request, response);
        response.sendRedirect("customer");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
