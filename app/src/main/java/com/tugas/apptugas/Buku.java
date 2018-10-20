package com.tugas.apptugas;

import android.content.res.ColorStateList;

public class Buku {
    long id;
    String judul,isbn,tahun,penerbit,kategori,jumlah,warna, kualitas,rangkuman;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTahun() {
        return tahun;
    }

    public void setTahun(String tahun) {
        this.tahun = tahun;
    }

    public String getPenerbit() {
        return penerbit;
    }

    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getJumlah() {
        return jumlah;
    }

    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
    }

    public String getWarna() {
        return warna;
    }

    public void setWarna(String warna) {
        this.warna = warna;
    }

    public float getKualitas() {
        return Float.parseFloat(kualitas);
    }

    public void setKualitas(String kualitas) {
        this.kualitas = kualitas;
    }

    public String getRangkuman() {
        return rangkuman;
    }

    public void setRangkuman(String rangkuman) {
        this.rangkuman = rangkuman;
    }
}
