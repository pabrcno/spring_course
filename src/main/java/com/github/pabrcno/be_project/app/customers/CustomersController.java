package com.github.pabrcno.be_project.app.customers;

import java.util.UUID;
import com.github.pabrcno.be_project.domain.customers.Customer;
import com.github.pabrcno.be_project.domain.customers.ICustomersDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/api/v1/customers")
@RestController
public class CustomersController {
    
    private final ICustomersDao customersDao;
    
    @Autowired
    public CustomersController(ICustomersDao customersDao) {
        this.customersDao = customersDao;
    }
    @GetMapping()
    public Customer[] getAllCustomers() {
        return customersDao.getAllCustomers();
    }
    @PostMapping
    public void addCustomer(@RequestBody Customer customer ) {
        customersDao.addCustomer(customer);
    }

    @GetMapping(path= "{customerId}")
    public Customer getCustomerById(@PathVariable("CustomerId") UUID customerId) {
        return customersDao.getCustomerById(customerId);
    }
    @GetMapping(path= "{customerName}")
    public Customer getCustomerByName(@PathVariable("CustomerName") String customerName) {
        return customersDao.getCustomerByName(customerName);
    }

    @DeleteMapping(path= "{customerId}")
    public void deleteCustomer(@PathVariable("CustomerId") UUID customerId) {
        customersDao.deleteCustomer(customerId);
    }
    @PatchMapping(path= "{customerId}/updateName")
    public void updateCustomer(@PathVariable("CustomerId") UUID customerId, @RequestBody Customer customer) {
        customersDao.updateCustomer(customerId, customer);
    }

}
