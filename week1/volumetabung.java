/*
Created by Chie
10 Maret
@2024
*/

public class volumetabung { //deklarasi class
    public static void main(String[] args) {
        System.out.println("Program Java Menghitung Volume Tabung by Chie's Code"); //judul program
        System.out.println("Diketahui : ");
        System.out.println("Diameter Alas Tabung : 5");
        System.out.println("Tinggi Tabung : 10");
        System.out.println();
        
        double r = 2.5; //deklarasi nilai diameter alas tabung
        int tinggi = 10; //deklarasi nilai tinggi tabung
        float phi = 3.14f; //deklarasi nilai phi

        double luasalas = phi * r;
        System.out.println("Luas Alas Tabung :" + luasalas); //tampil hasil 1
        System.out.println();

        double volumetabung = luasalas * tinggi;
        System.out.println("Volume Tabung :" + volumetabung); //tampil hasil 2
    }
}
