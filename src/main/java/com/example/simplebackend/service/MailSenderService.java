package com.example.simplebackend.service;

import com.example.simplebackend.payload.OrderModel;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailSenderService {

    private final String email = "starfit.shop24@gmail.com";
    private final JavaMailSender javaMailSender;

    public void sendMessage(OrderModel orderModel){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setText("Yangi buyurtma bor\n"+"\nFoydalanuvchi ismi: "+orderModel.getName()+"\n" +
                "Foydalanuvchi telefon raqami: "+ orderModel.getNumber()+ "\n" +
                "Habar: "+ orderModel.getMessage());
        simpleMailMessage.setTo(email);
        simpleMailMessage.setSubject("Yangi buyurtma bor");
        simpleMailMessage.setFrom("Tizim");
        javaMailSender.send(simpleMailMessage);
    }
}
