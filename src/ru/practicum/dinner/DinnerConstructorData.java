package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;

public class DinnerConstructorData {
    static HashMap<String, ArrayList<String>> dishes = new HashMap<>();

    public void addNewDish(String dishType, String dishName) {
        if (dishes.containsKey(dishType)) {
            ArrayList<String> listOfDishes = dishes.get(dishType);
            if (!listOfDishes.contains(dishName)) {
                System.out.println("Сохранено!\n");
                listOfDishes.add(dishName);
            } else {
                System.out.println("Такое блюдо уже есть в списке!\n");
            }
        } else {
            ArrayList<String> listOfDishes = new ArrayList<>();
            System.out.println("Сохранено!\n");
            listOfDishes.add(dishName);
            dishes.put(dishType, listOfDishes);
        }
    }
}