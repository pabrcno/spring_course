package com.github.pabrcno.be_project.domain.customers;


public interface ICustomersService {
    Customer[] getAllCustomers();
    void addCustomer(Customer Customer);
    Customer getCustomerByName(String customerName);
    Customer getCustomerById(String id);
    void deleteCustomer(String id);
    void updateCustomer( Customer customer);
}
