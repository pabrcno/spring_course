package com.github.pabrcno.be_project.service.customers;
import java.util.UUID;

import com.github.pabrcno.be_project.domain.core.annotations.Delete;
import com.github.pabrcno.be_project.domain.core.annotations.Update;
import com.github.pabrcno.be_project.domain.core.annotations.VerifyCustomer;
import com.github.pabrcno.be_project.domain.customers.Customer;
import com.github.pabrcno.be_project.domain.customers.ICustomersDao;
import com.github.pabrcno.be_project.domain.customers.ICustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CustomersService implements ICustomersService {
    private final ICustomersDao customersDao;
  
    @Autowired
    public CustomersService(@Qualifier("fakeCustomersDao") ICustomersDao customersDao) {
        this.customersDao = customersDao;
    }

    @Override
    public Customer[] getAllCustomers() {
        return customersDao.getAllCustomers();
    }

    @VerifyCustomer
    @Override
    public void addCustomer(Customer customer ) {
        customersDao.addCustomer(customer);
    }

    @Override
    public Customer getCustomerById(UUID customerId) {
        return customersDao.getCustomerById(customerId);
    }

    @Override
    public Customer getCustomerByName(String customerName) {
        return customersDao.getCustomerByName(customerName);
    }

    @Delete
    @Override
    public void deleteCustomer(UUID customerId) {
        customersDao.deleteCustomer(customerId);
    }
    
    @Update
    @VerifyCustomer
    @Override
    public void updateCustomer( Customer customer, UUID customerId) {
        customersDao.updateCustomer(customerId, customer);
    }
}
