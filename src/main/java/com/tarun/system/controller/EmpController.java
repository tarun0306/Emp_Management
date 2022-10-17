package com.tarun.system.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.tarun.system.entity.Employee;
import com.tarun.system.service.EmpService;

@Controller
public class EmpController {
	@Autowired
	private EmpService service;
	
	 

	@GetMapping("/")
	public String home(Model m) {
		return findPaginate(0,m);
	}
	
	@GetMapping("/addemp")
	public String add_emp() {
		return "add_emp";
	}
	@PostMapping("/register")
	public String empRegister(@ModelAttribute Employee e,HttpSession session) {
		service.addEmp(e);
		session.setAttribute("msg ","Employee added successfully..");
		return "redirect:/";
	}
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id ,Model m) {
		Employee e = service.getEmpById(id);
		m.addAttribute("emp",e);
		return "edit";
	}
	@PostMapping("/update")
	public String updateEmp(@ModelAttribute Employee e, HttpSession session) {
		service.addEmp(e);
		session.setAttribute("msg", "Emp Data Updated Sucessfully..");
		return "redirect:/";
	}
	@GetMapping("/delete/{id}")
	public String deleteEmp(@PathVariable int id, HttpSession session) {
		service.deleteEmp(id);
		session.setAttribute("msg", "Emp Data Deleted Sucessfully..");
		return "redirect:/";
	}
	@GetMapping("/page/{pageno}")
	public String findPaginate(@PathVariable int pageno,Model m ) {
		Page<Employee> emplist = service.getEMpByPaginate(pageno, 2);
		m.addAttribute("emp",emplist);
		m.addAttribute("emp", emplist);
		m.addAttribute("currentPage",pageno);
		m.addAttribute("totalPages", emplist.getTotalPages());
		m.addAttribute("totalItem", emplist.getTotalElements());
		return "index";
	}
}
