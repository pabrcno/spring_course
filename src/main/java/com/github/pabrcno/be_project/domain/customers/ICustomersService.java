package com.github.pabrcno.be_project.domain.customers;

import java.util.UUID;

public interface ICustomersService {
    Customer[] getAllCustomers();
    void addCustomer(Customer Customer);
    Customer getCustomerByName(String customerName);
    Customer getCustomerById(UUID id);
    void deleteCustomer(UUID id);
    void updateCustomer( Customer customer, UUID id);
}
