package com.example.simplebackend.controller;

import com.example.simplebackend.payload.ApiResponse;
import com.example.simplebackend.payload.OrderModel;
import com.example.simplebackend.service.BotService;
import com.example.simplebackend.service.MailSenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.simplebackend.SimpleBackendApplication.botService;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final MailSenderService senderService;

    @PostMapping
    public ApiResponse addOrder(@RequestBody OrderModel orderModel){
        botService.sendMessage(orderModel);
        senderService.sendMessage(orderModel);
        return new ApiResponse("Habar jo`natildi",true);
    }
}
