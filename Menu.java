import domain.FoodBeverage;
import domain.FoodBeverage;
import service.CartService;
import service.FoodBeverageService;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    FoodBeverageService foodService = new FoodBeverageService();
    CartService cartService = new CartService();

    public void getMenu() {
        System.out.println("[=] SISTEM KASIR RESTO V2 [=]");
        System.out.println();
        System.out.println("[1] Add Food & Beverage");
        System.out.println("[2] List Food & Beverage");
        System.out.println("[3] Keranjang Belanja");
        System.out.println("[4] Pembayaran");
        System.out.println();
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
                case 3:
                this.addCartMenu();
                break;

        }
    }

    public void addFoodMenu(){
        System.out.println("[=] ADD FOOD [=]");
        FoodBeverage food = new FoodBeverage();

        System.out.print("Masukan nama  : ");
        food.setName(scanner.next());

        System.out.print("Apakah ini minuman (Y/N) ? ");
        food.setIsdrink(scanner.next().equals("Y") ? true : false);

        System.out.print("Jumlah Stok : ");
        food.setQty(scanner.nextInt());

        System.out.print("Harga : ");
        food.setPrice(scanner.nextBigDecimal());

        foodService.addFood(food);
        this.getMenu();
    }

    public void listFoodMenu(){
        System.out.println("[=] LIST FOOD [=]");
        for (FoodBeverage food : foodService.listFood()){
            System.out.println("NAMA = " + food.getName());
            System.out.println("JUMLAH = " + food.getQty());
            System.out.println("HARGA = " + food.getPrice());
            System.out.println("JENIS = " + (food.getIsdrink() ? "MINUMAN" : "MAKANAN"));

            System.out.println("==");
        }

        try {
            System.out.println("Press any key to continue...");
            System.in.read();
        } catch (IOException e) {

        }

        this.getMenu();
    }

    public void addCartMenu(){
        Integer index = 0;
        for (FoodBeverage food : foodService.listFood()){
            System.out.println("NO."+ ++index);
            System.out.println("NAMA = " + food.getName());
            System.out.println("JUMLAH = " + food.getQty());
            System.out.println("HARGA = " + food.getPrice());
            System.out.println("JENIS = " + (food.getIsdrink() ? "MINUMAN" : "MAKANAN"));

            System.out.println("==");
        }

        System.out.print("Pilih makanan/minuman = ");
        FoodBeverage foodBeverage = FoodBeverageService.foodList.get((scanner.nextInt() - 1 ));
        FoodBeverage cartFoodBeverage = new FoodBeverage();
        cartFoodBeverage.setName(foodBeverage.getName());
        cartFoodBeverage.setIsdrink(foodBeverage.getIsdrink());
        System.out.print("Jumlah di order = ");
        cartFoodBeverage.setQty(scanner.nextInt());

        if(cartFoodBeverage.getQty() > foodBeverage.getQty()){
            System.out.println("Permintaan melebihi stok!");
            this.addCartMenu();
        }

        //todo: pengurangan stok



        cartFoodBeverage.setPrice(foodBeverage.getPrice().multiply(new BigDecimal(cartFoodBeverage.getQty())));
        cartService.addCart(cartFoodBeverage);

        for (FoodBeverage food : CartService.carts){
            System.out.println("NAMA = " + food.getName());
            System.out.println("JUMLAH = " + food.getQty());
            System.out.println("HARGA = " + food.getPrice());
            System.out.println("JENIS = " + (food.getIsdrink() ? "MINUMAN" : "MAKANAN"));
            System.out.println("==");
        }

    }
}
