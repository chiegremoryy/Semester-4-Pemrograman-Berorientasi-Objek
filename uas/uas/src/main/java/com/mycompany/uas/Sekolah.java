/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.uas;

/**
 *
 * @author chieg
 */
public class Sekolah {
    private String asalSekolah;
    private int tahunLulus;
    private double nilaiRataRata;
    private String nim;

    // Constructors
    public Sekolah(String asalSekolah, int tahunLulus, double nilaiRataRata, String Nim) {
        this.asalSekolah = asalSekolah;
        this.tahunLulus = tahunLulus;
        this.nilaiRataRata = nilaiRataRata;
        this.nim = nim;
    }
    
    public String getAsalSekolah() {
        return asalSekolah;
    }

    public void setAsalSekolah(String asalSekolah) {
        this.asalSekolah = asalSekolah;
    }

    public int getTahunLulus() {
        return tahunLulus;
    }

    public void setTahunLulus(int tahunLulus) {
        this.tahunLulus = tahunLulus;
    }

    public double getNilaiRataRata() {
        return nilaiRataRata;
    }

    public void setNilaiRataRata(double nilaiRataRata) {
        this.nilaiRataRata = nilaiRataRata;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }
}
