package domain;

import java.math.BigDecimal;

public class FoodBeverage {
    private String name;
    private Integer qty;
    private BigDecimal price;
    private Boolean isdrink;

    public Boolean getIsdrink() {
        return isdrink;
    }

    public void setIsdrink(Boolean isdrink) {
        this.isdrink = isdrink;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
