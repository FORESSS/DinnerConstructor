package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

public class DinnerConstructor {
    public static void generateDishCombo(int numberOfCombos, ArrayList<String> listOfTypes) {
        if (checkType(listOfTypes)) {
            System.out.println("Варианты: ");

            ArrayList<ArrayList<String>> listOfCombos = new ArrayList<>();
            for (int i = 0; i < numberOfCombos; i++) {
                listOfCombos.add(new ArrayList<>());

                for (String type : listOfTypes) {
                    for (Map.Entry<String, ArrayList<String>> pair : DinnerConstructorData.dishes.entrySet()) {
                        String key = pair.getKey();
                        ArrayList<String> value = pair.getValue();

                        if (type.equals(key)) {
                            int random = new Random().nextInt(pair.getValue().size());
                            listOfCombos.get(i).add(value.get(random));
                        }
                    }
                }
            }
            for (ArrayList<String> combo : listOfCombos) {
                System.out.println("Комбо №" + (listOfCombos.indexOf(combo) + 1));
                System.out.println(combo + "\n");
            }
        } else {
            System.out.println("Ошибка! Пожалуйста, введите ещё раз!\n");
        }
    }

    public static boolean checkType(ArrayList<String> listOfTypes) {
        for (String type : listOfTypes) {
            if (DinnerConstructorData.dishes.containsKey(type)) {
                return true;
            }
        }
        return false;
    }

    public int checkInput(String input) {
        String value = "0";
        char[] inputArray = input.toCharArray();
        boolean isDigit = true;
        for (char ch : inputArray) {
            if (!Character.isDigit(ch)) {
                isDigit = false;
            }
        }
        if (isDigit && Long.parseLong(input) < Integer.MAX_VALUE) {
            value = input;
        }
        return Integer.parseInt(value);
    }
}