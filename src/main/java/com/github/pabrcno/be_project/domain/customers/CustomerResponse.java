package com.github.pabrcno.be_project.domain.customers;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerResponse {
    private String username;
    private String email;
    private String token;
    public CustomerResponse from(Customer c) {
        return CustomerResponse.builder()
                .username(c.getUsername())
                .email(c.getEmail())
                .token(c.getToken())
                .build();
    }
}
