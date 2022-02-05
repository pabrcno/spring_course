package com.github.pabrcno.be_project.service.customers;


import com.github.pabrcno.be_project.domain.customers.Customer;

import com.github.pabrcno.be_project.domain.customers.ICustomersService;
import com.github.pabrcno.be_project.infrastructure.customers.CustomerRepository;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomersService implements ICustomersService {
    CustomerRepository repo;
    @Override
    public Customer[] getAllCustomers() {
        return repo.findAll().toArray(new Customer[0]);
    }


    @Override
    public void addCustomer(Customer Customer) {
        repo.save(Customer);
        
    }

    @Override
    public Customer getCustomerByName(String customerName) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Customer getCustomerById(String id) {
       return repo.findById(id).get();
    }

    @Override
    public void deleteCustomer(String id) {
        repo.delete(getCustomerById(id));
        
    }

    @Override
    public void updateCustomer(Customer customer) {
        repo.save(customer);
    }
 
}
