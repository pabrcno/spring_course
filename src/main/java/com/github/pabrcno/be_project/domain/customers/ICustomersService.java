package com.github.pabrcno.be_project.domain.customers;

import com.github.pabrcno.be_project.handle.exceptions.ApiRestTokenException;

public interface ICustomersService {
    Customer getCustomer(String customerName, String password) throws ApiRestTokenException;
    Customer[] getAllCustomers();
    void addCustomer(Customer Customer);
    Customer getCustomerByName(String customerName);
    Customer getCustomerById(String id);
    void deleteCustomer(String id);
    void updateCustomer( Customer customer);
}
