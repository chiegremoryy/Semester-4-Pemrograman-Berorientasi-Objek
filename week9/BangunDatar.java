//Nama : Muhammad Arief Hidayatullah
//NIM : A11.2022.14788
//Date Created 1 Juni 2024

package week9;

public class BangunDatar {
    private int panjang;
    private int lebar;
    private int diameter;
    private int sisi;
    private static final double PI = Math.PI;

    public BangunDatar(int sisi) {
        this.sisi = sisi;
    }

    public BangunDatar(int panjang, int lebar) {
        this.panjang = panjang;
        this.lebar = lebar;
    }
    
    public int luas(int a) {
        return a * a;
    }

    public int luas(int a, int b) {
        return a * b;
    }

    public double luas(double a, double b) {
        return (a * b) / 2;
    }

    public double luas(double a) {
        return PI * a * a;
    }

    public int getPanjang() {
        return panjang;
    }

    public int getLebar() {
        return lebar;
    }

    public int getDiameter() {
        return diameter;
    }

    public int getSisi() {
        return sisi;
    }
}
