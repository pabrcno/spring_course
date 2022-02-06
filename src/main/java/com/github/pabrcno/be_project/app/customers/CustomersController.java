package com.github.pabrcno.be_project.app.customers;

import com.github.pabrcno.be_project.domain.customers.Customer;
import com.github.pabrcno.be_project.domain.customers.ICustomersService;
import com.github.pabrcno.be_project.handle.exceptions.ApiRestTokenException;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;


@RequestMapping("/api/v1/customers")
@RestController
@AllArgsConstructor
public class CustomersController {
    
    private final ICustomersService service;
    
    @PostMapping("login")
    public Customer login(@RequestParam("customer") String customerName, @RequestParam("password") String pwd)
            throws Exception {
        return service.getCustomer(customerName, pwd);
    }
    @GetMapping()
    public Customer[] getAllCustomers() {
        return service.getAllCustomers();
    }
    @PostMapping
    public void addCustomer(@RequestBody Customer customer ) throws ApiRestTokenException {
        service.addCustomer(customer);
    }

    @GetMapping(path= "{customerId}")
    public Customer getCustomerById(@PathVariable("customerId") String customerId) throws ApiRestTokenException {
        return service.getCustomerById(customerId);
    }
    @GetMapping(path= "{customerName}")
    public Customer getCustomerByName(@PathVariable("customerName") String customerName) throws ApiRestTokenException {
        return service.getCustomerByName(customerName);
    }

    @DeleteMapping(path= "{customerId}")
    public void deleteCustomer(@PathVariable("customerId") String customerId) throws ApiRestTokenException {
        service.deleteCustomer(customerId);
    }
    @PatchMapping(path= "{customerId}/update")
    public void updateCustomer( @RequestBody Customer customer) {
        service.updateCustomer(customer);
    }

}
