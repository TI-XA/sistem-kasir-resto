import domain.FoodBeverage;
import service.CartService;
import service.FoodBeverageService;
import service.Payment;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public  class Menu {
    Scanner scanner = new Scanner(System.in);
    FoodBeverageService foodService = new FoodBeverageService();
    CartService cartService = new CartService();
    Payment payment = new Payment();

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
            case 4:
                this.paymentMenu();
                //checkout.checkout(); 
                break;
            default:
                System.out.println("Pilihan tidak valid. Coba lagi."); 
                this.getMenu();
        }
    }

    public void addFoodMenu() {
        System.out.println("[=] ADD FOOD [=]");
        FoodBeverage food = new FoodBeverage();

        System.out.print("Masukan nama  : ");
        food.setName(scanner.next()+scanner.nextLine());

        System.out.print("Apakah ini minuman (Y/N) ? ");
        food.setIsdrink(scanner.next().equalsIgnoreCase("Y")); 

        System.out.print("Jumlah Stok : ");
        food.setQty(scanner.nextInt());

        System.out.print("Harga : ");
        food.setPrice(scanner.nextBigDecimal());

        foodService.addFood(food);
        this.getMenu();
    }

    public void listFoodMenu() {
        System.out.println("[=] LIST FOOD [=]");
        for (FoodBeverage food : foodService.listFood()) {
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
            e.printStackTrace();  
        }

        this.getMenu();
    }

    public void addCartMenu() {

        Integer index = 0;
        for (FoodBeverage food : foodService.listFood()) {
            System.out.println("NO." + ++index);
            System.out.println("NAMA = " + food.getName());
            System.out.println("JUMLAH = " + food.getQty());
            System.out.println("HARGA = " + food.getPrice());
            System.out.println("JENIS = " + (food.getIsdrink() ? "MINUMAN" : "MAKANAN"));
            System.out.println("==");
        }


        System.out.print("Pilih makanan/minuman = ");
        int pilihan = scanner.nextInt();		
        if (pilihan < 1 || pilihan > foodService.listFood().size()) {
            System.out.println("Pilihan tidak valid.");  
            return;  
        }
        
        FoodBeverage foodBeverage = foodService.listFood().get(pilihan - 1);
        FoodBeverage cartFoodBeverage = new FoodBeverage();
        cartFoodBeverage.setName(foodBeverage.getName());
        cartFoodBeverage.setIsdrink(foodBeverage.getIsdrink()); 

   
        System.out.print("Jumlah di order = ");
        int jumlahPesan = scanner.nextInt();

     
        if (jumlahPesan > foodBeverage.getQty()) {
            System.out.println("Permintaan melebihi stok!");
            return; 
        }


        cartFoodBeverage.setPrice(foodBeverage.getPrice().multiply(new BigDecimal(cartFoodBeverage.getQty())));


        int newStock = foodBeverage.getQty() - jumlahPesan;
        foodBeverage.setQty(newStock);

     
        BigDecimal totalHarga = foodBeverage.getPrice().multiply(BigDecimal.valueOf(jumlahPesan));
        cartFoodBeverage.setQty(jumlahPesan);
        cartFoodBeverage.setPrice(totalHarga);



        cartService.addCart(cartFoodBeverage);


        System.out.println("[=] KERANJANG BELANJA [=]");
        for (FoodBeverage food : CartService.carts) {
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
            e.printStackTrace();
        }


        this.getMenu();
    }

    public void paymentMenu(){
        System.out.println("[=] PAYMENT [=]");
        List<FoodBeverage> carts = cartService.getCarts();
        
        BigDecimal totalHarga = BigDecimal.ZERO;
        for (FoodBeverage food : carts) {
            totalHarga = totalHarga.add(food.getPrice());
            System.out.println("NAMA = " + food.getName());
            System.out.println("JUMLAH = " + food.getQty());
        }

        System.out.println("Total harga belanjaan: " + totalHarga);

        System.out.print("Masukkan uang pembayaran: ");
        payment.setPembayaran(scanner.nextBigDecimal());;

        if (payment.getPembayaran().compareTo(totalHarga) < 0) {
            System.out.println("Uang pembayaran tidak cukup!");
            this.paymentMenu();
        } else {
            payment.setKembalian(payment.getPembayaran().subtract(totalHarga));
            System.out.println("Uang kembalian: " + payment.getKembalian());
        }

        System.out.println("Press enter to complete the payment...");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }


        this.getMenu();
    }
}
