package com.github.pabrcno.be_project.app.customers;

import java.util.UUID;
import com.github.pabrcno.be_project.domain.customers.Customer;
import com.github.pabrcno.be_project.domain.customers.ICustomersService;

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
    
    private final ICustomersService customersService;
    
    @Autowired
    public CustomersController(ICustomersService customersService) {
        this.customersService = customersService;
    }
    @GetMapping()
    public Customer[] getAllCustomers() {
        return customersService.getAllCustomers();
    }
    @PostMapping
    public void addCustomer(@RequestBody Customer customer ) {
        customersService.addCustomer(customer);
    }

    @GetMapping(path= "{customerId}")
    public Customer getCustomerById(@PathVariable("customerId") UUID customerId) {
        return customersService.getCustomerById(customerId);
    }
    @GetMapping(path= "{customerName}")
    public Customer getCustomerByName(@PathVariable("customerName") String customerName) {
        return customersService.getCustomerByName(customerName);
    }

    @DeleteMapping(path= "{customerId}")
    public void deleteCustomer(@PathVariable("customerId") UUID customerId) {
        customersService.deleteCustomer(customerId);
    }
    @PatchMapping(path= "{customerId}/update")
    public void updateCustomer(@PathVariable("customerId") UUID customerId, @RequestBody Customer customer) {
        customersService.updateCustomer(customer,customerId);
    }

}
