package com.github.pabrcno.be_project.service.customers;


import com.github.pabrcno.be_project.cache.CacheClient;
import com.github.pabrcno.be_project.domain.customers.Customer;

import com.github.pabrcno.be_project.domain.customers.ICustomersService;
import com.github.pabrcno.be_project.handle.exceptions.ApiRestTokenException;
import com.github.pabrcno.be_project.infrastructure.customers.CustomerRepository;
import com.github.pabrcno.be_project.security.JwtProvider;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomersService implements ICustomersService {
    private final CustomerRepository repo;
    private final JwtProvider jwtProvider;
    private final CacheClient<Customer> cache;

    @Override
    public Customer[] getAllCustomers() {
        return repo.findAll().toArray(new Customer[0]);
    }


    @Override
    public void addCustomer(Customer Customer) throws ApiRestTokenException {
        if(getCustomerByName(Customer.getName()) == null) {    
            Customer cus = repo.save(Customer);
            saveInCache(cus);
        }else{
            throw new ApiRestTokenException("Customer already exists");
        }
    }

    @Override
    public Customer getCustomerByName(String customerName) throws ApiRestTokenException {
        try {
            Customer cus = cache.recover(customerName, Customer.class);
            if (cus == null) {
                cus = repo.findByName(customerName);
                saveInCache(cus);
            }
            return cus;
        } catch (Exception e) {
            return null;
        } 
    }

    @Override
    public Customer getCustomerById(String id) throws ApiRestTokenException {
       try {
            Customer cus = cache.recover(id, Customer.class);
            if (cus == null) {
                cus = repo.findById(id).get();
                saveInCache(cus);
            }
            return cus;
        } catch (Exception e) {
            throw new ApiRestTokenException("Customer not found");
        }
        
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

    @Override
    public void updateCustomer(Customer customer) {
        repo.save(customer);
        cache.update(customer.getId(), customer);
    }


    @Override
    public Customer getCustomer(String customerName, String password) throws ApiRestTokenException {
        var customer = getCustomerByName(customerName);

        if (!(customer.getName().equals(customerName) && customer.getPassword().equals(password))) {
            throw new ApiRestTokenException("El usuario o el password es inválido");
        }
        var token = jwtProvider.getJWTToken(customerName);
        return Customer.builder().name(customerName).token(token).build();
    }
    private Customer saveInCache(Customer customer) {
        return cache.save(customer.getId().toString(), customer);
    }
}
