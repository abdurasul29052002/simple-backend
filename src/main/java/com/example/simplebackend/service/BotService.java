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

    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {
        System.out.println(update.getMessage().getChatId());
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(String.valueOf(update.getMessage().getChatId()));
        sendMessage.setChatId(String.valueOf(update.getMessage().getChatId()));
        execute(sendMessage);
    }

    @SneakyThrows
    public void sendMessage(OrderModel orderModel) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText("Yangi buyurtma bor✅\n" + "\nFoydalanuvchi ismi\uD83D\uDE4D\u200D♂️: " + orderModel.getName() + "\n" +
                "Manzil\uD83D\uDCCD: " + orderModel.getAddress() + "\n" +
                "Foydalanuvchi telefon raqami\uD83D\uDCF1: " + orderModel.getNumber() + "\n" +
                "Habar✉️: " + orderModel.getMessage());
        sendMessage.setChatId("5805024800");
        execute(sendMessage);
        sendMessage.setChatId("1324394249");
        execute(sendMessage);
    }
}
