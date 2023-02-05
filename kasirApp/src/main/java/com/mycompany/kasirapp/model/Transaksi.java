/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kasirapp.model;

/**
 *
 * @author Acer SPIN
 */
public class Transaksi {
    int idTransaksi, idKasir, idSupermarket,quantity,total;
    String date;

    public void setIdTransaksi(int idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public void setIdKasir(int idKasir) {
        this.idKasir = idKasir;
    }

    public void setIdSupermarket(int idSupermarket) {
        this.idSupermarket = idSupermarket;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getIdTransaksi() {
        return idTransaksi;
    }

    public int getIdKasir() {
        return idKasir;
    }

    public int getIdSupermarket() {
        return idSupermarket;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getTotal() {
        return total;
    }

    public String getDate() {
        return date;
    }
    public Supermarket belongsToSupermarket(){
        return null;
    }
    public Cashier belongsToKasir(){
        return null;
    }
    
    
}
