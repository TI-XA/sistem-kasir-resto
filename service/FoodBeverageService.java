package service;

import domain.FoodBeverage;

import java.util.ArrayList;
import java.util.List;

/**
 * Class FoodBeverageService - mengelola daftar makanan dan minuman
 */
public class FoodBeverageService { 
    // Encapsulation: variabel private untuk menyimpan daftar makanan
    private List<FoodBeverage> foodList = new ArrayList<>();

    /**
     * Method untuk menambahkan makanan ke dalam daftar
     * @param food objek FoodBeverage yang akan ditambahkan
     */
    public void addFood(FoodBeverage food) { 
        foodList.add(food);
    }

     /**
     * Method untuk mendapatkan seluruh daftar makanan
     * @return List dari objek FoodBeverage
     */
    public List<FoodBeverage> listFood() {
        return foodList;
    }
}
