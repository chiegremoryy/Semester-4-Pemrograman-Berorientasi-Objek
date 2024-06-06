//Nama : Muhammad Arief Hidayatullah
//NIM : A11.2022.14788
//Date Created 1 Juni 2024

package week9;

public class BangunRuang {
    private int sisi;
    private int panjang;
    private int lebar;
    private int tinggi;
    private double radius;

    private static final double PI = Math.PI;

    public BangunRuang(int sisi) {
        this.sisi = sisi;
    }

    public BangunRuang(int panjang, int lebar, int tinggi) {
        this.panjang = panjang;
        this.lebar = lebar;
        this.tinggi = tinggi;
    }

    public BangunRuang(double radius) {
        this.radius = radius;
    }

    public BangunRuang(double radius, int tinggi) {
        this.radius = radius;
        this.tinggi = tinggi;
    }

    public int volumeKubus() {
        return sisi * sisi * sisi;
    }

    public int volumeBalok() {
        return panjang * lebar * tinggi;
    }

    public double volumeBola() {
        return (4.0 / 3.0) * PI * Math.pow(radius, 3);
    }

    public double volumeTabung() {
        return PI * Math.pow(radius, 2) * tinggi;
    }

    public int luasPermukaanKubus() {
        return 6 * (sisi * sisi);
    }

    public int luasPermukaanBalok() {
        return 2 * ((panjang * lebar) + (panjang * tinggi) + (lebar * tinggi));
    }

    public double luasPermukaanBola() {
        return 4 * PI * Math.pow(radius, 2);
    }

    public double luasPermukaanTabung() {
        return 2 * PI * radius * (radius + tinggi);
    }
}
