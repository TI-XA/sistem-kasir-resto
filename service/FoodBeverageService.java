import java.util.ArrayList;
import java.util.List;

public class FoodBeverageService {
    private List<FoodBeverage> foodList = new ArrayList<>();

    public void addFood(FoodBeverage food) { 
        foodList.add(food);
    }

    public List<FoodBeverage> listFood() {
        return foodList;
    }
}
