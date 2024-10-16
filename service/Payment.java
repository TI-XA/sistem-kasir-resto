package service;

import java.math.BigDecimal;

public class Payment {
    private BigDecimal uangPembayaran;
    private BigDecimal uangKembalian;


    public BigDecimal getPembayaran() {
        return uangPembayaran;
    }

    public void setPembayaran(BigDecimal uangPembayaran) {
        this.uangPembayaran = uangPembayaran;
    }

    public BigDecimal getKembalian() {
        return uangKembalian;
    }

    public void setKembalian(BigDecimal uangKembalian) {
        this.uangKembalian = uangKembalian;
    }

}
