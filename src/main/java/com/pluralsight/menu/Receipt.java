package com.pluralsight.menu;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Receipt {
    public static void transaction(String transactionData) {
        try {
            String directory = "src/main/resources";

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss");
            String fileName = LocalDateTime.now().format(formatter) + ".txt";

            File file = new File(directory, fileName);
            BufferedWriter  bw = new BufferedWriter (new FileWriter(file, true));
            bw.write(transactionData);
            bw.close();
            System.out.println("Transaction saved to: " + fileName);
        } catch (IOException e) {
            System.out.println("Error opening file" + e.getMessage());
        }
    }


    public static String buildReceipt(Order order) {
        StringBuilder sb = new StringBuilder("==========Receipt===========\n");
        sb.append("\n");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss");
        String date = LocalDateTime.now().format(formatter);
        sb.append("Date: ").append(date).append("\n");
        sb.append("\n");
        sb.append("Items: ").append("\n");
        for(MenuItem item : order.getItems()) {
            sb.append(item.getName()).append("\t");
            sb.append(String.format("%.2f", item.getPrice())).append("\n");
            if(item instanceof CustomPizza) {
                CustomPizza customPizza = (CustomPizza) item;
                if(customPizza.isStuffedCrust()){
                    sb.append(" --- Stuffed Crust\n");
                }
            }
        }
        sb.append("\n");
        sb.append("Total: ").append(String.format("%.2f", order.calculateTotalPrice()));
        sb.append("\n");
        sb.append("Thank you for visiting us today!\n");
        return sb.toString();
    }
}
