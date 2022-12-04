package com.example.simplebackend.service;

import com.example.simplebackend.payload.OrderModel;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public class BotService extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        return "navbatchi24bot";
    }

    @Override
    public String getBotToken() {
        return "2134498671:AAGJbhzsOTkiSJFowCXJQAW-MVfvu1YVT3M";
    }

    @Override
    public void onUpdateReceived(Update update) {
        System.out.println(update.getMessage().getChatId());
    }

    @SneakyThrows
    public void sendMessage(OrderModel orderModel){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText("Yangi buyurtma bor\n"+"\nFoydalanuvchi ismi: "+orderModel.getName()+"\n" +
                "Foydalanuvchi telefon raqami: "+ orderModel.getNumber()+ "\n" +
                "Habar: "+ orderModel.getMessage());
        sendMessage.setChatId("813621165");
        execute(sendMessage);
    }
}
