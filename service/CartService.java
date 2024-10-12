package service;

import domain.FoodBeverage;

import java.util.ArrayList;
import java.util.List;

public class CartService {
    public static List<FoodBeverage> carts = new ArrayList<FoodBeverage>();

    public List<FoodBeverage> addCart(FoodBeverage foodBeverage){
        carts.add(foodBeverage);

        return carts;
    }
}
