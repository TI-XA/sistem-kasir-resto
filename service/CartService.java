package service;

import domain.FoodBeverage;

import java.util.ArrayList;
import java.util.List;

/**
<<<<<<< HEAD
 * INHERITANCE!
 */
public class CartService extends Payment {
=======
 * Class CartService - mengelola keranjang belanja
 */
public class CartService {
    // Static member: daftar item dalam keranjang yang dibagikan di seluruh instance
>>>>>>> 714350c947ceff0fe78d11d3d6a1c7e2627d3d4d
    public static List<FoodBeverage> carts = new ArrayList<>();

    /**
     * Method untuk menambahkan item ke keranjang
     * @param foodBeverage objek FoodBeverage yang akan ditambahkan ke keranjang
     */
    public void addCart(FoodBeverage foodBeverage) { 
        carts.add(foodBeverage);
    }

    /**
     * Method untuk mendapatkan seluruh isi keranjang
     * @return List dari objek FoodBeverage dalam keranjang
     */
    public List<FoodBeverage> getCarts() {
        return carts;
    }

    /**
     * Method untuk mengosongkan keranjang
     */
    public void clearCarts() {
        carts.clear();
    }
}
