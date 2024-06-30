package com.customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerService {
	// Create an ArrayList of Customer type called customerList
	List<Customer> customerList = new ArrayList<Customer>();
	
	public void addCustomer(Customer customer) {
		customerList.add(customer);
	}

	public Customer getCustomerById(int id) {
		for (Customer customer : customerList) {
			// Find the id in customerList and return Customer object
			if (customer.getId() == id) {
                return customer;
            }
		}
		return null;
	}

	public List<Customer> getAllCustomers() {
		return new ArrayList<>(customerList);
	}
}