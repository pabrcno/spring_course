package com.github.pabrcno.be_project.service.customers;
import java.util.UUID;
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

    public Customer[] getAllCustomers() {
        return customersDao.getAllCustomers();
    }

    public void addCustomer(Customer customer ) {
        customersDao.addCustomer(customer);
    }


    public Customer getCustomerById(UUID customerId) {
        return customersDao.getCustomerById(customerId);
    }

    public Customer getCustomerByName(String customerName) {
        return customersDao.getCustomerByName(customerName);
    }

    
    public void deleteCustomer(UUID customerId) {
        customersDao.deleteCustomer(customerId);
    }
    
    public void updateCustomer( UUID customerId,Customer customer) {
        customersDao.updateCustomer(customerId, customer);
    }
}
