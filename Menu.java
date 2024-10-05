import domain.FoodBeverage;
import domain.FoodBeverage;
import service.FoodBeverageService;

import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    FoodBeverageService foodService = new FoodBeverageService();

    public void getMenu() {
        System.out.println("[=] SISTEM KASIR RESTO V2[=]");
        System.out.println("");
        System.out.println("[1] Add Food & Beverage");
        System.out.println("[2] List Food & Beverage");
        System.out.println("[3] Keranjang Belanja");
        System.out.println("[4] Pembayaran");
        System.out.println("");
        System.out.print("[+] Pilih menu => ");
        this.handleMenu(scanner.nextInt());
    }

    public void handleMenu(Integer option) {
        switch (option) {
            case 1:
                this.addFoodMenu();
                break;
            case 2:
                this.listFoodMenu();
                break;

        }
    }

    public void addFoodMenu(){
        System.out.println("[=] ADD FOOD [=]");
        FoodBeverage food = new FoodBeverage();
        System.out.print("masukan nama  : ");
        food.setName(scanner.next());

        System.out.print("Apakah ini minuman (Y/N) ? ");
        food.setIsdrink(scanner.next().equals("Y"));
        foodService.addFood(food);
        this.getMenu();
    }

    public void listFoodMenu(){
        System.out.println("[=] LIST FOOD [=]");
        for (FoodBeverage food : foodService.listFood()){
            System.out.println("NAMA MAKANAN = " + food.getName());
            System.out.println("JENIS = " + (food.getIsdrink() ? "MINUMAN" : "MAKANAN"));

            System.out.println("==");
        }

        this.getMenu();
    }
}
