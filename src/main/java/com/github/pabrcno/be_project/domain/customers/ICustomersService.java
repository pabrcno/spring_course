package com.github.pabrcno.be_project.domain.customers;

import com.github.pabrcno.be_project.handle.exceptions.ApiRestTokenException;

public interface ICustomersService {
    Customer getCustomer(String customerName, String password) throws ApiRestTokenException;
    Customer[] getAllCustomers();
    void addCustomer(Customer Customer) throws ApiRestTokenException;
    Customer getCustomerByName(String customerName) throws ApiRestTokenException;
    Customer getCustomerById(String id) throws ApiRestTokenException;
    void deleteCustomer(String id) throws ApiRestTokenException;
    void updateCustomer( Customer customer);
}
