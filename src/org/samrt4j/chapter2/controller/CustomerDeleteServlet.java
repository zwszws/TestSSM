package org.samrt4j.chapter2.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.samrt4j.chapter2.model.service.CustomerService;

@WebServlet("/customer_delete")
public class CustomerDeleteServlet extends HttpServlet {
	private CustomerService customerService;
	
	public void init(ServletConfig config) throws ServletException {
		customerService = new CustomerService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long id = Integer.parseInt(request.getParameter("id"));
		
		boolean result = customerService.deleteCustomer(id);
		request.getRequestDispatcher("customer")
		.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
