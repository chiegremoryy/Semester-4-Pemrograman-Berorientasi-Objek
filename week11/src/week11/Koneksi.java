package week11;

import java.sql.*;
import java.util.Scanner;

public class Koneksi {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://127.0.0.1/PBOJava";
    static final String USER = "root";
    static final String PASS = "";
    
    static Connection conn;
    static Statement stmt;
    static ResultSet rs;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        
        do {
            System.out.println("Menu:");
            System.out.println("1. Insert Data");
            System.out.println("2. Update Data");
            System.out.println("3. Delete Data");
            System.out.println("4. Show Data");
            System.out.println("5. Exit");
            System.out.print("Masukkan Pilihan: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // konsumsi newline
            
            switch(choice) {
                case 1:
                    insertData(scanner);
                    break;
                case 2:
                    updateData(scanner);
                    break;
                case 3:
                    deleteData(scanner);
                    break;
                case 4:
                    showData();
                    break;
                case 5:
                    System.out.println("Sayonara Chie >\\<");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while(choice != 5);
        
        scanner.close();
    }

    public static void insertData(Scanner scanner) {
        System.out.print("Masukkan nama tabel (buku/penulis): ");
        String table = scanner.nextLine();
        
        if (table.equalsIgnoreCase("buku")) {
            System.out.print("Masukkan judul buku: ");
            String judulBuku = scanner.nextLine();
            System.out.print("Masukkan tahun terbit: ");
            int tahunTerbit = scanner.nextInt();
            System.out.print("Masukkan stok: ");
            byte stok = scanner.nextByte();
            System.out.print("Masukkan id penulis: ");
            int penulisId = scanner.nextInt();
            scanner.nextLine(); // konsumsi newline
            
            try {
                Class.forName(JDBC_DRIVER);
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                String sql = "INSERT INTO buku (judul_buku, tahun_terbit, stok, penulis) VALUES (?,?,?,?)";
                PreparedStatement ps = conn.prepareStatement(sql);
                
                ps.setString(1, judulBuku);
                ps.setInt(2, tahunTerbit);
                ps.setByte(3, stok);
                ps.setInt(4, penulisId);
                
                ps.execute();
                
                ps.close();
                conn.close();
                System.out.println("Data buku berhasil dimasukkan.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (table.equalsIgnoreCase("penulis")) {
            System.out.print("Masukkan nama penulis: ");
            String namaPenulis = scanner.nextLine();
            
            try {
                Class.forName(JDBC_DRIVER);
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                String sql = "INSERT INTO penulis (nama_penulis) VALUES (?)";
                PreparedStatement ps = conn.prepareStatement(sql);
                
                ps.setString(1, namaPenulis);
                
                ps.execute();
                
                ps.close();
                conn.close();
                System.out.println("Data penulis berhasil dimasukkan.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Nama tabel tidak valid.");
        }
    }

    public static void updateData(Scanner scanner) {
        System.out.print("Masukkan nama tabel (buku/penulis): ");
        String table = scanner.nextLine();
        
        if (table.equalsIgnoreCase("buku")) {
            System.out.print("Masukkan id buku: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // konsumsi newline
            System.out.print("Masukkan judul buku baru: ");
            String judulBuku = scanner.nextLine();
            System.out.print("Masukkan tahun terbit baru: ");
            int tahunTerbit = scanner.nextInt();
            System.out.print("Masukkan stok baru: ");
            byte stok = scanner.nextByte();
            System.out.print("Masukkan id penulis baru: ");
            int penulisId = scanner.nextInt();
            scanner.nextLine(); // konsumsi newline
            
            try {
                Class.forName(JDBC_DRIVER);
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                String sql = "UPDATE buku SET judul_buku = ?, tahun_terbit = ?, stok = ?, penulis = ? WHERE id = ?";
                PreparedStatement ps = conn.prepareStatement(sql);
                
                ps.setString(1, judulBuku);
                ps.setInt(2, tahunTerbit);
                ps.setByte(3, stok);
                ps.setInt(4, penulisId);
                ps.setInt(5, id);
                
                ps.executeUpdate();
                
                ps.close();
                conn.close();
                System.out.println("Data buku berhasil diperbarui.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (table.equalsIgnoreCase("penulis")) {
            System.out.print("Masukkan id penulis: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // konsumsi newline
            System.out.print("Masukkan nama penulis baru: ");
            String namaPenulis = scanner.nextLine();
            
            try {
                Class.forName(JDBC_DRIVER);
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                String sql = "UPDATE penulis SET nama_penulis = ? WHERE id = ?";
                PreparedStatement ps = conn.prepareStatement(sql);
                
                ps.setString(1, namaPenulis);
                ps.setInt(2, id);
                
                ps.executeUpdate();
                
                ps.close();
                conn.close();
                System.out.println("Data penulis berhasil diperbarui.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Nama tabel tidak valid.");
        }
    }

    public static void deleteData(Scanner scanner) {
        System.out.print("Masukkan nama tabel (buku/penulis): ");
        String table = scanner.nextLine();
        
        if (table.equalsIgnoreCase("buku")) {
            System.out.print("Masukkan id buku: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // konsumsi newline
            
            try {
                Class.forName(JDBC_DRIVER);
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                String sql = "DELETE FROM buku WHERE id = ?";
                PreparedStatement ps = conn.prepareStatement(sql);
                
                ps.setInt(1, id);
                
                ps.executeUpdate();
                
                ps.close();
                conn.close();
                System.out.println("Data buku berhasil dihapus.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (table.equalsIgnoreCase("penulis")) {
            System.out.print("Masukkan id penulis: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // konsumsi newline
            
            try {
                Class.forName(JDBC_DRIVER);
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                String sql = "DELETE FROM penulis WHERE id = ?";
                PreparedStatement ps = conn.prepareStatement(sql);
                
                ps.setInt(1, id);
                
                ps.executeUpdate();
                
                ps.close();
                conn.close();
                System.out.println("Data penulis berhasil dihapus.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Nama tabel tidak valid.");
        }
    }

    public static void showData() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan nama tabel (buku/penulis): ");
        String table = scanner.nextLine();
        
        if (table.equalsIgnoreCase("buku")) {
            try {
                Class.forName(JDBC_DRIVER);
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                stmt = conn.createStatement();
                
                rs = stmt.executeQuery("SELECT * FROM buku");
                int i = 1;
                while (rs.next()) {
                    System.out.println("Data Buku ke-" + i);
                    System.out.println("ID Buku: " + rs.getInt("id"));
                    System.out.println("Judul Buku: " + rs.getString("judul_buku"));
                    System.out.println("Tahun Terbit: " + rs.getInt("tahun_terbit"));
                    System.out.println("Stok: " + rs.getByte("stok"));
                    System.out.println("ID Penulis: " + rs.getInt("penulis"));
                    i++;
                }
                stmt.close();
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (table.equalsIgnoreCase("penulis")) {
            try {
                Class.forName(JDBC_DRIVER);
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                stmt = conn.createStatement();
                
                rs = stmt.executeQuery("SELECT * FROM penulis");
                int i = 1;
                while (rs.next()) {
                    System.out.println("Data Penulis ke-" + i);
                    System.out.println("ID Penulis: " + rs.getInt("id"));
                    System.out.println("Nama Penulis: " + rs.getString("nama_penulis"));
                    i++;
                }
                stmt.close();
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Nama tabel tidak valid.");
        }
    }
}
