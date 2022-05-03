package com.example.mypain.service;


import com.example.mypain.models.product_order;
import com.example.mypain.models.users;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Service
public class OrderChequeService
{

    public String chequeMessageGenerate(users user, product_order order)
    {
        String chequeText = "Клиент: " + user.getUsername() + "!\n" +
                "Заказан тип товара: " + order.getProductTypeName().getProducttptype() + "\n"
                + "Дата: " + order.getOrderDate() + ".\n"
                + "Компания: " + order.getCompany().getCompanyname() + ".\n"
                + "Aenpka Company Inc.";
        return chequeText;

    }

    public void saveCheque(String chequeText, Long chequeId) {

        File directory = new File("C:/Users/Goope/Desktop/mypain/checks/");
        String path = directory.getPath();

        String chequePathName = path + "/cheque" + chequeId + ".txt";
        File chequeFile = new File(chequePathName);

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(chequeFile));
            writer.write(chequeText);
            writer.flush();
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }



}