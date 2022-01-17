package com.github.pabrcno.be_project.domain.customers;

import java.util.UUID;

public interface ICustomersDao {
    Customer[] getAllCustomers();
    void addCustomer(Customer Customer);
    Customer getCustomerByName(String customerName);
    Customer getCustomerById(UUID id);
}
