/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.uas;

/**
 *
 * @author chieg
 */
public class Mahasiswa {
    private String nama;
    private String nim;
    private String tempatLahir;
    private String tglLahir;
    private String jenisKelamin;
    private String alamat;
    private int noTelp;
    private String email;
    private int prodiId;
    private String namaProdi;

    public Mahasiswa(String nama, String nim, String tempatLahir, String tglLahir, String jenisKelamin, String alamat, int noTelp, String email, int prodiId) {
        this.nama = nama;
        this.nim = nim;
        this.tempatLahir = tempatLahir;
        this.tglLahir = tglLahir;
        this.jenisKelamin = jenisKelamin;
        this.alamat = alamat;
        this.noTelp = noTelp;
        this.email = email;
        this.prodiId = prodiId;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getTempatLahir() {
        return tempatLahir;
    }

    public void setTempatLahir(String tempatLahir) {
        this.tempatLahir = tempatLahir;
    }

    public String getTglLahir() {
        return tglLahir;
    }

    public void setTglLahir(String tglLahir) {
        this.tglLahir = tglLahir;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public int getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(int noTelp) {
        this.noTelp = noTelp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getProdiId() {
        return prodiId;
    }

    public void setProdiId(int prodiId) {
        this.prodiId = prodiId;
    }

    public String getNamaProdi() {
        return namaProdi;
    }

    public void setNamaProdi(String namaProdi) {
        this.namaProdi = namaProdi;
    }
}