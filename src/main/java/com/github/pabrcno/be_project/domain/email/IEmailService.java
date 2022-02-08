package com.github.pabrcno.be_project.domain.email;

import com.github.pabrcno.be_project.domain.order.Order;

public interface IEmailService {
    public void sendOrderConfirmationEmail(String email, Order order);
}
