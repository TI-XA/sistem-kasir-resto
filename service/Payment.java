package service;

import java.math.BigDecimal;

/**
<<<<<<< HEAD
 * KELAS
 */
=======
 * Class Payment - implementasi konsep encapsulation untuk mengelola data pembayaran
 */

>>>>>>> 714350c947ceff0fe78d11d3d6a1c7e2627d3d4d
public class Payment {
    // Encapsulation: Variabel private untuk menyembunyikan data internal
    private BigDecimal uangPembayaran;
    private BigDecimal uangKembalian;

/**
     * Getter method untuk mengakses uang pembayaran
     * Implementasi encapsulation dengan menyediakan akses terkontrol ke variabel private
     * @return nilai uang pembayaran
     */
    public BigDecimal getPembayaran() {
        return uangPembayaran;
    }

/**
     * Setter method untuk mengatur uang pembayaran
     * Implementasi encapsulation dengan menyediakan akses terkontrol ke variabel private
     * @param uangPembayaran nilai pembayaran yang akan diset
     */
    public void setPembayaran(BigDecimal uangPembayaran) {
        this.uangPembayaran = uangPembayaran;
    }

    /**
     * Getter method untuk mengakses uang kembalian
     * Implementasi encapsulation dengan menyediakan akses terkontrol ke variabel private
     * @return nilai uang kembalian
     */
    public BigDecimal getKembalian() {
        return uangKembalian;
    }

    /**
     * Setter method untuk mengatur uang kembalian
     * Implementasi encapsulation dengan menyediakan akses terkontrol ke variabel private
     * @param uangKembalian nilai kembalian yang akan diset
     */
    public void setKembalian(BigDecimal uangKembalian) {
        this.uangKembalian = uangKembalian;
    }

}
