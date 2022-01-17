package com.github.pabrcno.be_project.infrastructure.customers;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.github.pabrcno.be_project.domain.core.FirstApplicationException;
import com.github.pabrcno.be_project.domain.customers.ICustomersDao;
import com.github.pabrcno.be_project.domain.customers.Customer;

import org.springframework.stereotype.Repository;

@Repository("fakeCustomersDao")
public class FakeCustomerDao implements ICustomersDao {
    
    private static List<Customer> customers = new ArrayList<Customer>();

    @Override
    public Customer[] getAllCustomers() {
        return customers.toArray(new Customer[customers.size()]);
    }

    @Override
    public void addCustomer(Customer customer) {
                if (customer == null) {
                throw new FirstApplicationException("customer is null");
            }
    
            if (customer.getCustomerName() == null || customer.getCustomerName().isEmpty()) {
                throw new FirstApplicationException("customer name is null");
            }
    
            if (customer.getPassword() == null || customer.getPassword().isEmpty()) {
                throw new FirstApplicationException("customer password is null");
            }
            if( customers.stream().filter(u -> u.getCustomerName().equals(customer.getCustomerName())).count() > 0 ){
                throw new FirstApplicationException("customer already exists");
            }
                customers.add(customer);
        }

    @Override
    public Customer getCustomerByName(String customerName) {
        return customers.stream().filter(u -> u.getCustomerName().equals(customerName)).findFirst().orElse(null);
    }

    @Override
    public Customer getCustomerById(UUID id) {
        return customers.stream().filter(u -> u.getId().equals(id)).findFirst().orElse(null);
    }   
}
    

