import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class Checkout {
    private Scanner scanner;
    private CartService cartService;

    public Checkout(Scanner scanner, CartService cartService) {
        this.scanner = scanner;
        this.cartService = cartService;
    }

    public void checkout() {
        List<FoodBeverage> carts = cartService.getCarts();
        
        BigDecimal totalHarga = BigDecimal.ZERO;
        for (FoodBeverage food : carts) {
            totalHarga = totalHarga.add(food.getPrice().multiply(BigDecimal.valueOf(food.getQty())));
        }

        System.out.println("Total harga belanjaan: " + totalHarga);

        System.out.print("Masukkan uang pembayaran: ");
        BigDecimal uangPembayaran = scanner.nextBigDecimal();

        if (uangPembayaran.compareTo(totalHarga) < 0) {
            System.out.println("Uang pembayaran tidak cukup!");
        } else {
            BigDecimal kembalian = uangPembayaran.subtract(totalHarga);
            System.out.println("Uang kembalian: " + kembalian);
        }

        System.out.println("Tekan enter untuk kembali ke menu utama...");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
