package com.company;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        //String number = "";
        //String number = "+79686409890";
        //String number = " +[796  8{}6409)(89]0";
        String number = " + (7)9{6}8[6]4 0 98 9 00 )";
        //String number = "89686409890";
        //String number = "123456";

        System.out.println(Arrays.toString(check_phone(number)));
    }

    public static String[] check_phone(String number) {
        ArrayList<String> changes = new ArrayList<String>(); //создаем динамический массив для хранения списка изменений
        String[] result = new String[2]; //метод вернет массив строк
        boolean wrong_num = false;
        boolean was_changed = false;

        /* проверим содержит ли номер пробелы и скобки и удалим их*/
        if (number.contains(" ") || number.contains("[") || number.contains("]") || number.contains("(")
                || number.contains(")") || number.contains("}") || number.contains("{")) {
            number = number.replace(" ", "");
            number = number.replaceAll("[()\\[\\]{}]", "");
            changes.add("В номере есть пробелы и/или скобки");
            was_changed = true;
        }

        /* проверим начинается ли измененный номер на +7 и заменим на 8 */
        if (number.startsWith("+7")) {
            number = number.replace("+7", "8");
            changes.add("Замена +7 на 8");
            was_changed = true;
        }

        /* проверяем количество символов, для пустой строки вместо номера не будем выводить данное "изменение" */
        if (number.length() != 11 && number.length() > 0) {
            changes.add("Количество символов не 11");
            wrong_num = true;
        }

        /* проверка на пустую строку и проверка первого символа*/
        if (number.isEmpty() || number.charAt(0) != '8')
            wrong_num = true;

        if (!was_changed)
            changes.add("Не было изменений");

        if (wrong_num)
            result[0] = "Введен некорректный номер";
        else
            result[0] = number;

        result[1] = String.join("; ", changes); //соединяем список изменений и разделяем их через ";"
        return result;
    }
}