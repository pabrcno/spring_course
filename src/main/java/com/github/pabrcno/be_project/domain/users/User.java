package com.github.pabrcno.be_project.domain.users;
import java.util.UUID;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.pabrcno.be_project.domain.core.Observer.IObserver;

public class User implements IObserver {
    private String username;
    private String password;
    private UUID id;
    public User( 
        @JsonProperty("name") String username,
        @JsonProperty("password") String password
    ) {
        this.username = username;
        this.password = password;
        this.id = UUID.randomUUID();
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public UUID getId() {
        return id;
    }
    @Override
    public void update(String message) {
        System.out.println("User " + this.username + " got notified of if product was available: " + message);
    }
}
