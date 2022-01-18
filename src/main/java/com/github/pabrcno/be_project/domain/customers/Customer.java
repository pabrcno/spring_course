package com.github.pabrcno.be_project.domain.customers;
import java.util.UUID;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.pabrcno.be_project.domain.core.Observer.IObserver;

public class Customer implements IObserver {
    private String name;
    private String password;
    private UUID id;
    public Customer( 
        @JsonProperty("name") String name,
        @JsonProperty("password") String password
    ) {
        this.name = name;
        this.password = password;
        this.id = UUID.randomUUID();
    }
    public String getName() {
        return name;
    }
    public String getPassword() {
        return password;
    }
    public UUID getId() {
        return id;
    }
    @Override
    public void update(String message) {
        System.out.println("customer " + this.name + " got notified of if product was available: " + message);
    }
    //setters
    public void setName(String name) {
        this.name = name;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
