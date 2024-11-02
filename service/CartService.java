package service;

import domain.FoodBeverage;

import java.util.ArrayList;
import java.util.List;

/**
 * INHERITANCE!
 */
public class CartService extends Payment {
    public static List<FoodBeverage> carts = new ArrayList<>();

    public void addCart(FoodBeverage foodBeverage) { 
        carts.add(foodBeverage);
    }

    public List<FoodBeverage> getCarts() {
        return carts;
    }

    public void clearCarts() {
        carts.clear();
    }
}
