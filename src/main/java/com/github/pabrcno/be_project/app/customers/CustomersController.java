package com.github.pabrcno.be_project.app.customers;

import java.util.List;

import com.github.pabrcno.be_project.domain.customers.CustomerRequest;
import com.github.pabrcno.be_project.domain.customers.CustomerResponse;
import com.github.pabrcno.be_project.domain.customers.ICustomersService;
import com.github.pabrcno.be_project.handle.exceptions.ApiRestTokenException;



import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
    public CustomerResponse login(@RequestParam("email") String customerEmail, @RequestParam("password") String pwd)
            throws Exception {
        return service.getCustomer(customerEmail, pwd);
    }
    @GetMapping()
    public List<CustomerResponse> getAllCustomers() {
        return service.getAllCustomers();
    }

    @PostMapping("create")
    public void addCustomer(@RequestBody CustomerRequest customer ) throws ApiRestTokenException {
        service.addCustomer(customer);
    }

    @GetMapping(path= "{customerId}")
    public CustomerResponse getCustomerById(@PathVariable("customerId") String customerId) throws ApiRestTokenException {
        return service.getCustomerById(customerId);
    }
    @GetMapping(path= "{customerEmail}")
    public CustomerResponse getCustomerByEmail(@PathVariable("customerEmail") String customerEmail) throws ApiRestTokenException {
        return service.getCustomerByEmail(customerEmail);
    }

    @DeleteMapping(path= "{customerId}")
    public void deleteCustomer(@PathVariable("customerId") String customerId) throws ApiRestTokenException {
        service.deleteCustomer(customerId);
    }
}
