package service;

import domain.FoodBeverage;

import java.util.ArrayList;
import java.util.List;

public class FoodBeverageService {
    public static List<FoodBeverage> foodList = new ArrayList<>();

    public FoodBeverage addFood(FoodBeverage food){
        foodList.add(food);

        return food;
    }

    public List<FoodBeverage> listFood(){
       return  foodList;
    }
}
