package com.github.pabrcno.be_project.domain.customers;

import java.util.List;

import com.github.pabrcno.be_project.handle.exceptions.ApiRestTokenException;

public interface ICustomersService {
    CustomerResponse getCustomer(String customerEmail, String password) throws ApiRestTokenException;
    List<CustomerResponse> getAllCustomers();
    CustomerResponse addCustomer(CustomerRequest request) throws ApiRestTokenException;
    CustomerResponse getCustomerByEmail(String customerEmail) throws ApiRestTokenException;
    CustomerResponse getCustomerById(String id) throws ApiRestTokenException;
    void deleteCustomer(String id) throws ApiRestTokenException;
}
