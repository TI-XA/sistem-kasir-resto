package domain;

import java.math.BigDecimal;

/**
 * Class FoodBeverage - representasi makanan atau minuman
 * Mendemonstrasikan penggunaan encapsulation dalam OOP
 */
public class FoodBeverage {
    // Encapsulation: Variabel instance private
    private String name;
    private boolean isdrink;
    private int qty;
    private BigDecimal price;

    // Getter dan Setter methods untuk encapsulation

 /**
     * Setter untuk nama makanan/minuman
     * @param name nama makanan/minuman
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter untuk nama makanan/minuman
     * @return nama makanan/minuman
     */
    public String getName() {
        return name;
    }

     /**
     * Getter untuk status minuman
     * @return true jika minuman, false jika makanan
     */
    public boolean getIsdrink() {
        return isdrink;
    }

    /**
     * Setter untuk status minuman
     * @param isdrink true jika minuman, false jika makanan
     */
    public void setIsdrink(boolean isdrink) {
        this.isdrink = isdrink;
    }

    /**
     * Getter untuk jumlah
     * @return jumlah makanan/minuman
     */
    public int getQty() {
        return qty;
    }

     /**
     * Setter untuk jumlah
     * @param qty jumlah makanan/minuman
     */
    public void setQty(int qty) {
        this.qty = qty;
    }

    /**
     * Getter untuk harga
     * @return harga makanan/minuman
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Setter untuk harga
     * @param price harga makanan/minuman
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
