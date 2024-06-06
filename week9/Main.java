//Nama : Muhammad Arief Hidayatullah
//NIM : A11.2022.14788
//Date Created 1 Juni 2024

package week9;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Pilih Bangun Ruang1");
        System.out.println("1. Kubus");
        System.out.println("2. Balok");
        System.out.println("3. Bola");
        System.out.println("4. Tabung");
        System.out.print("Masukkan Pilihan: ");
        int pilihan = scanner.nextInt();

        switch (pilihan) {
            case 1:
                System.out.print("Masukkan Sisi Kubus: ");
                int sisi = scanner.nextInt();
                BangunRuang kubus = new BangunRuang(sisi);
                System.out.println("Volume Kubus: " + kubus.volumeKubus() + " cm3");
                System.out.println("Luas Permukaan Kubus: " + kubus.luasPermukaanKubus() + " cm2");
                break;

            case 2:
                System.out.print("Masukkan Panjang Balok : ");
                int panjang = scanner.nextInt();
                System.out.print("Masukkan Lebar Balok: ");
                int lebar = scanner.nextInt();
                System.out.print("Masukkan Tinggi Balok: ");
                int tinggiBalok = scanner.nextInt();
                BangunRuang balok = new BangunRuang(panjang, lebar, tinggiBalok);
                System.out.println("Volume Balok: " + balok.volumeBalok() + " cm3");
                System.out.println("Luas Permukaan Balok: " + balok.luasPermukaanBalok() + " cm2");
                break;

            case 3:
                System.out.print("Masukkan Jari-Jari Bola: ");
                double radiusBola = scanner.nextDouble();
                BangunRuang bola = new BangunRuang(radiusBola);
                System.out.println("Volume Bola: " + bola.volumeBola() + " cm3");
                System.out.println("Luas Permukaan Bola: " + bola.luasPermukaanBola() + " cm2");
                break;

            case 4:
                System.out.print("Masukkan Jari-Jari Tabung: ");
                double radiusTabung = scanner.nextDouble();
                System.out.print("Masukkan Tinggi Tabung: ");
                int tinggiTabung = scanner.nextInt();
                BangunRuang tabung = new BangunRuang(radiusTabung, tinggiTabung);
                System.out.println("Volume Tabung: " + tabung.volumeTabung() + " cm3");
                System.out.println("Luas Permukaan Tabung: " + tabung.luasPermukaanTabung() + " cm2");
                break;

            default:
                System.out.println("Pilihan tidak valid");
        }
        scanner.close();
    }
}
