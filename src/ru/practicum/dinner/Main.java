package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static DinnerConstructorData data = new DinnerConstructorData();
    static DinnerConstructor constructor = new DinnerConstructor();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Вас приветствует конструктор обеда AUTODINNER-3000!\n");
        while (true) {
            switch (printMenu()) {
                case "1" -> printMenuInputNewDish();
                case "2" -> printMenuInputDishCombo();
                case "3" -> {
                    System.out.println("Программа завершена");
                    return;
                }
                default -> System.out.println("Такой команды нет!\n");
            }
        }
    }

    private static String printMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход");
        return scanner.next();
    }

    private static void printMenuInputNewDish() {
        System.out.println("Введите тип блюда:");
        String dishType = scanner.next();
        System.out.println("Введите название блюда:");
        String dishName = scanner.next();
        data.addNewDish(dishType, dishName);
    }

    private static void printMenuInputDishCombo() {
        System.out.println("Начинаем конструировать обед...");
        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        int numberOfCombos = constructor.checkInput(scanner.next());
        scanner.nextLine();
        if (numberOfCombos < 1) {
            System.out.println("Пожалуйста, введите число больше 0!\n");
            return;
        }
        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку");
        ArrayList<String> listOfTypes = new ArrayList<>();
        while (true) {
            String xxx = scanner.nextLine();
            listOfTypes.add(xxx);
            if (xxx.isEmpty()) {
                break;
            }
        }
        listOfTypes.remove(listOfTypes.size() - 1);
        DinnerConstructor.generateDishCombo(numberOfCombos, listOfTypes);
    }
}