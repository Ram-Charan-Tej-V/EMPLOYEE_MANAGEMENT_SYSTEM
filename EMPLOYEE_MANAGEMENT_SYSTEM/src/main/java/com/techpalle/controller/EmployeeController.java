package com.techpalle.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.techpalle.dao.DataAccess;
import com.techpalle.model.Employee;

@Controller
public class EmployeeController 
{
	@RequestMapping("delete")
	public ModelAndView deleteEmployee(int id) {
		ModelAndView mv = new ModelAndView();
		
		// Step 1: call the delete method present in DataAccess layer
		DataAccess da = new DataAccess();
		da.delete(id);
		
		// Step 2: redirect user to display.jsp with remaining rows leftout in table
		ArrayList<Employee> al = da.getAllEmployees();
		
		mv.addObject("lst", al);
		mv.setViewName("display.jsp");
		return mv;
		
	}
	@RequestMapping("update")
	public ModelAndView updateEmployee(HttpServletRequest request)
	{
		ModelAndView mv = new ModelAndView();
		// Step 1: Read the data from register.jsp page
		int i = Integer.parseInt(request.getParameter("tbId"));
		String n = request.getParameter("tbName");
		String e = request.getParameter("tbEmail");
		String p = request.getParameter("tbPass");
		long m = Long.parseLong(request.getParameter("tbMobile"));
		
		Employee em = new Employee(i,n,e,p,m);
		
		// Step 2: Update the value in DB
		DataAccess da = new DataAccess();
		da.update(em);
		
		// Step 3: Redirect user to display.jsp with updated values
		ArrayList<Employee> al = da.getAllEmployees();
		
		mv.addObject("lst", al);
		mv.setViewName("display.jsp");
		return mv;
		
	}
	
	
	@RequestMapping("edit")
	public ModelAndView displayEditForm(int id)
	{
		ModelAndView mv = new ModelAndView();
		// Step 1: Retrieve the old data from DB
		DataAccess da = new DataAccess();
		
		Employee empl = da.getEmployeeById(id);
		
		mv.addObject("employee", empl);
		
		// Step 2: Redirect user to edit [register.jsp]
		// to display the old data in controls
		mv.setViewName("register.jsp");
		return mv;
	}
	
	@RequestMapping(value ="CRUD", params = "Show")
	public ModelAndView showAllStudents() {
		ModelAndView mv = new ModelAndView();
		
		DataAccess da = new DataAccess();
		ArrayList<Employee> al = da.getAllEmployees();
		
		mv.addObject("lst", al);
		mv.setViewName("display.jsp");
		return mv;
	}
	
	@RequestMapping(value ="CRUD", params = "Register")
	public ModelAndView goToRegisterPage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("register.jsp");
		return mv;
	}
	@RequestMapping("reg")
	public ModelAndView insertEmployee(HttpServletRequest request)
	{
		String n = request.getParameter("tbName");
		String e = request.getParameter("tbEmail");
		String p = request.getParameter("tbPass");
		long m = Long.parseLong(request.getParameter("tbMobile"));
		
		Employee em = new Employee(n,e,p,m);
		
		DataAccess da = new DataAccess();
		da.insert(em);
		
		ModelAndView mv = new ModelAndView();
	//	mv.addObject("res", "inserted");
		mv.setViewName("register.jsp");
		return mv;
	}
}
