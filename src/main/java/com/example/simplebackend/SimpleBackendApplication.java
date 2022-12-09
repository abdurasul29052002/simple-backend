package com.example.simplebackend;

import com.example.simplebackend.service.BotService;
import lombok.SneakyThrows;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.Properties;

@SpringBootApplication
public class SimpleBackendApplication {

    public static BotService botService = new BotService();
    @SneakyThrows
    public static void main(String[] args) {
        SpringApplication.run(SimpleBackendApplication.class, args);
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        botService.clearWebhook();
        telegramBotsApi.registerBot(botService);
    }

    @Bean
    public JavaMailSender javaMailSender(){
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setPort(587);
        javaMailSender.setHost("smtp.gmail.com");
        javaMailSender.setUsername("abdurasulabduraimov22@gmail.com");
        javaMailSender.setPassword("hjlqspqnguehvbbh");
        Properties properties = javaMailSender.getJavaMailProperties();
        properties.setProperty("mail.transport.protocol","smtp");
        properties.setProperty("mail.smtp.auth","true");
        properties.setProperty("mail.smtp.starttls.enable","true");
        properties.setProperty("mail.smtp.starttls.required","true");
        properties.setProperty("mail.debug","true");
        return javaMailSender;
    }
}
