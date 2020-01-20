package com.eventum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eventum.dao.CustomerDAO;
import com.eventum.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	
	@Autowired
	private CustomerDAO custDAo;
	@Override
	@Transactional
	public List<Customer> getCustomers() {		
		return custDAo.getCustomers();
	}
	
	@Override
	@Transactional
	public void saveCustomer(Customer cust) {
		custDAo.saveCustomer(cust);
		
	}

	@Override
	@Transactional
	public Customer getCustomer(int id) {
		
		return custDAo.getCustomer(id);
	}

	@Override
	@Transactional
	public void deleteCustomer(int id) {
		custDAo.deleteCustomer(id);
		
	}
	
	

}
