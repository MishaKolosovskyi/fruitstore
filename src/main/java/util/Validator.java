package util;

import java.io.BufferedReader;
import java.io.IOException;

public class Validator {
    public String checkLetter(BufferedReader reader) throws IOException {
        String input = reader.readLine();
        while (!(input.equals("r") || input.equals("b") || input.equals("s"))){
            input = reader.readLine();
        }
        return input;
    }

    public String checkString(BufferedReader reader) throws IOException {
        String input = reader.readLine();
        while (input.isEmpty()){
            input = reader.readLine();
        }
        return input;
    }

    public String checkQuantity(BufferedReader reader) throws IOException {
        String input = reader.readLine();
        boolean isInteger = false;
        while (!isInteger) {
            try {
                Integer.parseInt(input);
                isInteger = true;
            } catch (NumberFormatException e) {
                input = reader.readLine();
            }
        }
        return input;
    }
}
