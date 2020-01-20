package com.eventum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.eventum.entity.Customer;
import com.eventum.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	
		@Autowired
		private CustomerService custSrvc;
		
		@GetMapping("/list")
		public String listCustomers(Model model) {
			List<Customer> customers=custSrvc.getCustomers();
			model.addAttribute("customers", customers);
			
			return "list-customers";
		}
		
		@GetMapping("/showFormForAdd")
		public String showFormForAdd(Model model) {
			Customer cust=new Customer();
			model.addAttribute("customer", cust);
			return "customer-form";
		}
		
		@PostMapping("/saveCustomer")
		public String saveCustomer(@ModelAttribute("customer")Customer cust) {
			custSrvc.saveCustomer(cust);
			return "redirect:/customer/list";
			
		}
		
		@GetMapping("/showFormForUpdate")
		public String showFormForUpdate(@RequestParam("customerId") int id,Model model) {
			Customer cust= custSrvc.getCustomer(id);
			model.addAttribute("customer",cust);
			
			return "customer-form";
		}
		
		@GetMapping("/delete")
		public String delete(@RequestParam("customerId") int id,Model model) {
			custSrvc.deleteCustomer(id);
			return "redirect:/customer/list";
		}
}
