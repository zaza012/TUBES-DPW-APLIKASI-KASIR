/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kasirapp.model;

import com.mycompany.kasirapp.controller.controller;
import java.util.List;

/**
 *
 * @author Acer SPIN
 */
public class Cashier {
    private int idKasir, idSupermark;
    private String username, password = "";
    
    public Cashier(){};
    public Cashier(int idSupermark, String username, String password){
        this.idSupermark = idSupermark;
        this.username = username;
        this.password = password;
    }
    public Cashier(int idKasir, int idSupermark, String username, String password){
        this.idKasir = idKasir;
        this.idSupermark = idSupermark;
        this.username = username;
        this.password = password;
    }

    public void setIdKasir(int idKasir) {
        this.idKasir = idKasir;
    }

    public void setIdSupermark(int idSupermark) {
        this.idSupermark = idSupermark;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdKasir() {
        return idKasir;
    }

    public int getIdSupermark() {
        return idSupermark;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    public boolean login(){
        return controller.login(this);
    }
    public void update(Barang barang){
        controller.update(barang);
    }
    public Barang getBarang(int idBarang){
        return controller.getDataBarang(idBarang, this); 
    }
    public List<Barang> HasManyBarang(){
        return controller.getDataBarangs(this.belongsToSupermarket());
    }
    public Supermarket belongsToSupermarket(){
        return controller.getSupermarket(this.idSupermark);
    }
    public void add(Transaksi transaksi){
        controller.add(transaksi);
    }
    public List<Transaksi> hasManyTransaksi(){
        return controller.getTransaksis(this);
    }

}
