/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.uas;

import com.mycompany.uas.Mahasiswa;
import com.mycompany.uas.Sekolah;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chieg
 */
public class MahasiswaService {
    public void createMahasiswa(Mahasiswa mahasiswa, Sekolah sekolah) {
        String sqlMahasiswa = "INSERT INTO Mahasiswa(nama, nim, tempat_lahir, tgl_lahir, jenis_kelamin, alamat, no_telp, email, prodi_id) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        String sqlSekolah = "INSERT INTO sekolah(asal_sekolah, tahun_lulus, nilai, nim) VALUES(?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement pstmtMahasiswa = null;
        PreparedStatement pstmtSekolah = null;

        try {
            conn = Koneksi.getConnection();
            conn.setAutoCommit(false);

            pstmtMahasiswa = conn.prepareStatement(sqlMahasiswa);
            pstmtMahasiswa.setString(1, mahasiswa.getNama());
            pstmtMahasiswa.setString(2, mahasiswa.getNim());
            pstmtMahasiswa.setString(3, mahasiswa.getTempatLahir());
            pstmtMahasiswa.setString(4, mahasiswa.getTglLahir());
            pstmtMahasiswa.setString(5, mahasiswa.getJenisKelamin());
            pstmtMahasiswa.setString(6, mahasiswa.getAlamat());
            pstmtMahasiswa.setInt(7, mahasiswa.getNoTelp());
            pstmtMahasiswa.setString(8, mahasiswa.getEmail());
            pstmtMahasiswa.setInt(9, mahasiswa.getProdiId());
            pstmtMahasiswa.executeUpdate();

            pstmtSekolah = conn.prepareStatement(sqlSekolah);
            pstmtSekolah.setString(1, sekolah.getAsalSekolah());
            pstmtSekolah.setInt(2, sekolah.getTahunLulus());
            pstmtSekolah.setDouble(3, sekolah.getNilaiRataRata());
            pstmtSekolah.setString(4, mahasiswa.getNim());
            pstmtSekolah.executeUpdate();

            conn.commit();

        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            if (pstmtMahasiswa != null) {
                try {
                    pstmtMahasiswa.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pstmtSekolah != null) {
                try {
                    pstmtSekolah.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.setAutoCommit(true);
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public List<Mahasiswa> readMahasiswas() {
        String sql = "SELECT m.*, p.nama_prodi FROM mahasiswa m JOIN prodi p ON m.prodi_id = p.prodi_id";
        List<Mahasiswa> mahasiswas = new ArrayList<>();

        try (Connection conn = Koneksi.getConnection()) {
            if (conn == null) {
                System.out.println("Koneksi ke database gagal.");
                return mahasiswas;
            }

            try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
                while (rs.next()) {
                    String nama = rs.getString("nama");
                    String nim = rs.getString("nim");
                    String tempatLahir = rs.getString("tempat_lahir");
                    String tglLahir = rs.getString("tgl_lahir");
                    String jenisKelamin = rs.getString("jenis_kelamin");
                    String alamat = rs.getString("alamat");
                    int noTelp = rs.getInt("no_telp");
                    String email = rs.getString("email");
                    int prodiId = rs.getInt("prodi_id");
                    String namaProdi = rs.getString("nama_prodi");

                    Mahasiswa mahasiswa = new Mahasiswa(nama, nim, tempatLahir, tglLahir, jenisKelamin, alamat, noTelp, email, prodiId);
                    mahasiswa.setNamaProdi(namaProdi);
                    mahasiswas.add(mahasiswa);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return mahasiswas;
    }

    public void updateMahasiswa(String originalNim, Mahasiswa updatedMahasiswa) {
        String sql = "UPDATE Mahasiswa SET nama = ?, tempat_lahir = ?, tgl_lahir = ?, jenis_kelamin = ?, alamat = ?, email = ? WHERE nim = ?";

        try (Connection conn = Koneksi.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, updatedMahasiswa.getNama());
            pstmt.setString(2, updatedMahasiswa.getTempatLahir());
            pstmt.setString(3, updatedMahasiswa.getTglLahir());
            pstmt.setString(4, updatedMahasiswa.getJenisKelamin());
            pstmt.setString(5, updatedMahasiswa.getAlamat());
            pstmt.setString(6, updatedMahasiswa.getEmail());
            pstmt.setString(7, originalNim);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   public void deleteMahasiswa(String nim) {
        deleteFromSekolah(nim);
        String sql = "DELETE FROM Mahasiswa WHERE nim = ?";

        try (Connection conn = Koneksi.getConnection(); 
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, nim);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void deleteFromSekolah(String nim) {
        String sql = "DELETE FROM Sekolah WHERE nim = ?";

        try (Connection conn = Koneksi.getConnection(); 
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, nim);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     public Mahasiswa getMahasiswaByNIM(String nim) {
        String sql = "SELECT m.*, p.nama_prodi FROM mahasiswa m JOIN prodi p ON m.prodi_id = p.prodi_id WHERE m.nim = ?";
        Mahasiswa mahasiswa = null;

        try (Connection conn = Koneksi.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nim);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String nama = rs.getString("nama");
                    String tempatLahir = rs.getString("tempat_lahir");
                    String tglLahir = rs.getString("tgl_lahir");
                    String jenisKelamin = rs.getString("jenis_kelamin");
                    String alamat = rs.getString("alamat");
                    int noTelp = rs.getInt("no_telp");
                    String email = rs.getString("email");
                    int prodiId = rs.getInt("prodi_id");
                    String namaProdi = rs.getString("nama_prodi");

                    mahasiswa = new Mahasiswa(nama, nim, tempatLahir, tglLahir, jenisKelamin, alamat, noTelp, email, prodiId);
                    mahasiswa.setNamaProdi(namaProdi);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mahasiswa;
    }
}
