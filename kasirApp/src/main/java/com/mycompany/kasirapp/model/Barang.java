/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kasirapp.model;

import com.mycompany.kasirapp.controller.controller;

/**
 *
 * @author Acer SPIN
 */
public class Barang {
    int idBarang,idSupermarket,idKasir,hargaBarang,stok;
    String namaBarang;
    int discount;
    private static Supermarket supermarket;
    
    public Barang(){};
    public Barang(int idBarang, int idSupermarket, int hargaBarang, int stok, String namaBarang, int discount) {
        this.idBarang = idBarang;
        this.idSupermarket = idSupermarket;
        this.hargaBarang = hargaBarang;
        this.stok = stok;
        this.namaBarang = namaBarang;
        this.discount = discount;
    }

    public void setIdKasir(int idKasir) {
        this.idKasir = idKasir;
    }
    public void setIdSupermarket(int idSupermarket) {
        this.idSupermarket = idSupermarket;
    }
    public void setIdBarang(int idBarang) {
        this.idBarang = idBarang;
    }
    public void setStok(int stok) {
        this.stok = stok;
    }
    public void setHargaBarang(int hargaBarang) {
        this.hargaBarang = hargaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
    
    public int getIdBarang() {
        return idBarang;
    }

    public int getHargaBarang() {
        return hargaBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public int getDiscount() {
        return discount;
    }
    public int getStok() {
        return stok;
    }

    public int getIdKasir() {
        return idKasir;
    }
    
    public int getIdSupermarket() {
        return idSupermarket;
    }
    
    public static void setSupermarket(Supermarket supermarket) {
        Barang.supermarket = supermarket;
    }

    public static Supermarket getSupermarket() {
        return supermarket;
    }
    public Supermarket belongsToSupermarket(){
        return controller.getSupermarket(this.idSupermarket);
    }
    public Cashier belongsToCashier(){
        return controller.getKasir(this.getIdKasir());
    }
    
}
