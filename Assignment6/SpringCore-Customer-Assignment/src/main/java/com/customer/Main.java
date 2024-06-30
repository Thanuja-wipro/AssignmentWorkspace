package com.customer;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		// Create reference of ApplicationContext
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		CustomerService customerService = (CustomerService) context.getBean("customerService");

		Customer customer1 = new Customer(1, "Thanuja", "thanuja@example.com", "1234567890");
        Customer customer2 = new Customer(2, "Avinash", "avinash@example.com", "0987654321");

        customerService.addCustomer(customer1);
        customerService.addCustomer(customer2);
        
		// Retrieve and print customer details
        Customer retrievedCustomer = customerService.getCustomerById(1);
        if (retrievedCustomer != null) {
            System.out.println("Retrieved Customer: " + retrievedCustomer.getName() + " (" + retrievedCustomer.getEmail() + ")");
        } else {
            System.out.println("Customer not found");
        }
		// List all customers in the system
		List<Customer> allCustomers = customerService.getAllCustomers();
		System.out.println("All Customers:");
		// Display all customer details
		for (Customer customer : allCustomers) {
            System.out.println(customer);
        }
	}
}