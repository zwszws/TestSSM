package org.samrt4j.chapter2.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.samrt4j.chapter2.model.Customer;
import org.samrt4j.chapter2.model.service.CustomerService;

@WebServlet("/customer_show")
public class CustomerShowServlet extends HttpServlet {
	private CustomerService customerService;

	public void init(ServletConfig config) throws ServletException {
		customerService = new CustomerService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		
		List<Customer> customerList = customerService.getCustomerList(name);
		request.setAttribute("customerList", customerList);
		request.getRequestDispatcher("/WEB-INF/view/customer_show.jsp")
				.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
