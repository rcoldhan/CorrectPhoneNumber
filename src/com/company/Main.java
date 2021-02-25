package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        //String number = " ";
        //String number = "";
        //String number = "12345678901";
        String number = " (123)45{+789}[]01 ";
        //String number = "+79686409890";
        //String number = " +[796  8{}6409)(89]0";
        //String number = " + (7)9{6}8[6]4 0 98 9 00 )";
        //String number = "89686409890";
        //String number = "123456";

        System.out.println(Arrays.toString(checkPhone(number)));
    }

    public static String[] checkPhone(String number) {
        ArrayList<String> changes = new ArrayList<>();
        String[] result = new String[2];
        boolean wrongNum = false;
        boolean wasChanged = false;

        if (number.contains(" ") || number.contains("[") || number.contains("]") || number.contains("(")
                || number.contains(")") || number.contains("}") || number.contains("{")) {
            number = number.replace(" ", "");
            number = number.replaceAll("[()\\[\\]{}]", "");
            changes.add("В номере есть пробелы и/или скобки");
            wasChanged = true;
        }

        if (number.startsWith("+7")) {
            number = number.replace("+7", "8");
            changes.add("Замена +7 на 8");
            wasChanged = true;
        }

        if (number.length() != 11) {
            changes.add("Количество символов не 11");
            wrongNum = true;
        }

        if (!wasChanged) {
            changes.add("Не было изменений");
        }

        if (wrongNum) {
            result[0] = "Введен некорректный номер";
        } else {
            result[0] = number;
        }

        result[1] = String.join("; ", changes);
        return result;
    }
}