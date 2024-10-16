package domain;

import java.math.BigDecimal;


public class FoodBeverage {
    private String name;
    private boolean isdrink;
    private int qty;
    private BigDecimal price;


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean getIsdrink() {
        return isdrink;
    }

    public void setIsdrink(boolean isdrink) {
        this.isdrink = isdrink;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
