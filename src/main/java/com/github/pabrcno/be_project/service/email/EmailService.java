package com.github.pabrcno.be_project.service.email;

import com.github.pabrcno.be_project.domain.email.IEmailService;
import com.github.pabrcno.be_project.domain.order.Order;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmailService implements IEmailService {

    final private JavaMailSender emailSender;

    public void sendOrderConfirmationEmail(String email, Order order) {
        String orderInfo = order.getProducts().stream()
                .map(op -> String.format("Product: %s \nDescription: %s \nPrice: %s \nQuantity: %s",
                    op.getProductName(),
                    op.getProductDescription(),
                    op.getProductPrice(),
                    op.getQuantity()))
                .reduce((s1, s2) -> s1 + "\n" + s2 )
                .orElse("");
        orderInfo +=  "\n" +String.format("Status: %s" , order.getStatus()) +"\n"+ String.format("Deliver Address: %s" , order.getDeliverAddress());
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("coderhousebackendproject@gmail.com");
        message.setTo(email);
        message.setSubject("Order confirmation");
        message.setText(String.format("Order confirmation\n%s", orderInfo));
        emailSender.send(message);
        //PASSWORD Dc75nUKXLkTRs4X
    }
}
