/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.uas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author chieg
 */
public class SekolahService {
    public void createSekolah(Sekolah sekolah) {
        String sql = "INSERT INTO sekolah(asal_sekolah, tahun_lulus, nilai, nim_mhs) VALUES(?, ?, ?, ?)";

        try (Connection conn = Koneksi.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, sekolah.getAsalSekolah());
            pstmt.setInt(2, sekolah.getTahunLulus());
            pstmt.setDouble(3, sekolah.getNilaiRataRata());
            pstmt.setString(4, sekolah.getNim());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
