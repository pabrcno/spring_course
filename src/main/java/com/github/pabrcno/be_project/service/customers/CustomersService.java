package com.github.pabrcno.be_project.service.customers;


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

    @Override
    public Customer[] getAllCustomers() {
        return repo.findAll().toArray(new Customer[0]);
    }


    @Override
    public void addCustomer(Customer Customer) {
        repo.save(Customer);
        
    }

    @Override
    public Customer getCustomerByName(String customerName) {
        return repo.findByName(customerName);
    }

    @Override
    public Customer getCustomerById(String id) {
       return repo.findById(id).get();
    }

    @Override
    public void deleteCustomer(String id) {
        repo.delete(getCustomerById(id));
        
    }

    @Override
    public void updateCustomer(Customer customer) {
        repo.save(customer);
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
 
}
