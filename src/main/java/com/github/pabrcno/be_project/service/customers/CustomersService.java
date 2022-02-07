package com.github.pabrcno.be_project.service.customers;


import java.util.ArrayList;
import java.util.List;

import com.github.pabrcno.be_project.cache.CacheClient;
import com.github.pabrcno.be_project.domain.customers.Customer;
import com.github.pabrcno.be_project.domain.customers.CustomerRequest;
import com.github.pabrcno.be_project.domain.customers.CustomerResponse;
import com.github.pabrcno.be_project.domain.customers.ICustomersService;
import com.github.pabrcno.be_project.handle.exceptions.ApiRestTokenException;
import com.github.pabrcno.be_project.infrastructure.customers.CustomerRepository;
import com.github.pabrcno.be_project.security.JwtProvider;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomersService implements ICustomersService {
    private final CustomerRepository repo;
    private final JwtProvider jwtProvider;
    private final CacheClient<Customer> cache;
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<CustomerResponse> getAllCustomers() {
        List<CustomerResponse> res = new ArrayList<>(); 
        repo.findAll().forEach(c -> res.add(new CustomerResponse().from(c)));
        return res;
    }


    
    @Override
    public void deleteCustomer(String id) throws ApiRestTokenException {
        try {
            repo.deleteById(id);
            cache.delete(id);
        } catch (Exception e) {
            throw new ApiRestTokenException("Customer not found");
        }
        
    }

    private Customer saveInCache(Customer customer) {
        return cache.save(customer.getId().toString(), customer);
    }



    @Override
    public CustomerResponse getCustomer(String customerEmail, String password) throws ApiRestTokenException {
        Customer customer = repo.findByEmail(customerEmail);
       
        if (!(customer.getEmail().equals(customerEmail) && passwordEncoder.matches(password, customer.getPassword()))) {
            throw new ApiRestTokenException("El usuario o el password es inválido");
        }
        var token = jwtProvider.getJWTToken(customerEmail);
        return CustomerResponse.builder().username(customer.getEmail()).email(customerEmail).token(token).build();
    }



    @Override
    public CustomerResponse addCustomer(CustomerRequest request) throws ApiRestTokenException {
        if(getCustomerByEmail(request.getEmail()) != null) {
            throw new ApiRestTokenException("Customer already exists");
        }
        
        Customer customer = new Customer().from(request);
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        Customer saved = repo.save(customer);
        return new CustomerResponse().from(saveInCache(saved));
    }



    @Override
    public CustomerResponse getCustomerByEmail(String customerEmail)  {
        Customer customer = repo.findByEmail(customerEmail);
        if (customer == null) {
            return null;
        }
        return new CustomerResponse().from(saveInCache(customer));
    }



    @Override
    public CustomerResponse getCustomerById(String id) throws ApiRestTokenException {
        Customer customer = repo.findById(id).orElse(null);
        if (customer == null) {
            throw new ApiRestTokenException("Customer not found");
        }
        return new CustomerResponse().from(saveInCache(customer));
    }

}
