package com.github.pabrcno.be_project.domain.customers;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequest {
    private String username;
    private String password;
    private String email;
}
