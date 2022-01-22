package com.github.pabrcno.be_project.domain.customers;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor

public class Customer{
    private String name;
    private String password;
    private UUID id;
    
}
