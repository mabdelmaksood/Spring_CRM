package com.eventum.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eventum.entity.Customer;
@Repository
public class CustomerDAOimpl implements CustomerDAO {
	
	
	//need to inject sess factory
	@Autowired
	private SessionFactory sessfac;
	
	@Override
	public List<Customer> getCustomers() {
		Session sess= sessfac.getCurrentSession();
		Query<Customer> query= sess.createQuery("from Customer order by lastName", Customer.class);
		List<Customer> customers =query.getResultList();
		return customers;
	}

	@Override
	public void saveCustomer(Customer cust) {
		Session sess= sessfac.getCurrentSession();
		sess.saveOrUpdate( cust);
		
	}

	@Override
	public Customer getCustomer(int id) {
		Session sess= sessfac.getCurrentSession();
		
		return sess.get(Customer.class, id);
	}

	@Override
	public void deleteCustomer(int id) {
		Session sess= sessfac.getCurrentSession();
		sess.delete(this.getCustomer(id));
		
	}
	

}
