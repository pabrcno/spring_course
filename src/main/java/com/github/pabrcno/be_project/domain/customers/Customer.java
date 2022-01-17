package com.github.pabrcno.be_project.domain.customers;
import java.util.UUID;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.pabrcno.be_project.domain.core.Observer.IObserver;

public class Customer implements IObserver {
    private String customerName;
    private String password;
    private UUID id;
    public Customer( 
        @JsonProperty("name") String customerName,
        @JsonProperty("password") String password
    ) {
        this.customerName = customerName;
        this.password = password;
        this.id = UUID.randomUUID();
    }
    public String getCustomerName() {
        return customerName;
    }
    public String getPassword() {
        return password;
    }
    public UUID getId() {
        return id;
    }
    @Override
    public void update(String message) {
        System.out.println("customer " + this.customerName + " got notified of if product was available: " + message);
    }
    //setters
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
