package util;

import service.FileService;
import service.impl.FileServiceImpl;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHandler {

    public void getDataFromUser() {
        FileService fileService = new FileServiceImpl();
        Validator validator = new Validator();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Press key: \n" +
                    "s - supply, means you are receiving fruits from suppliers \n" +
                    "b - buy, means someone bought a fruit \n" +
                    "r - return, means someone who have bought fruits now returns it to you");
            String letter = validator.checkLetter(reader);
            System.out.println("Enter a fruit name:");
            String fruitName = validator.checkString(reader);
            System.out.println("Enter a quantity:");
            String quantity = validator.checkQuantity(reader);
            System.out.println("Enter a date");
            String date = reader.readLine();
            fileService.write(new String[]{letter, fruitName, quantity, date}, "x.csv");
        } catch (IOException e) {
            System.out.println("getDataFromUser " + e + " " + ConsoleHandler.class);
        }
    }
}
