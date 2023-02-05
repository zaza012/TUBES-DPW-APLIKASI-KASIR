/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kasirapp.model;
import com.mycompany.kasirapp.controller.controller;
import com.mycompany.kasirapp.dbConnection.dbConfig;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author Acer SPIN
 */
public class Supermarket {
    private int idSupermarket;
    private String namaSupermarket,username,pass,confirmPass = "";
    private Cashier cashier;
    
    public Supermarket(){};
    public Supermarket(int idSupermarket, String namaSupermarket, String username, String pass){
        this.idSupermarket = idSupermarket;
        this.namaSupermarket = namaSupermarket;
        this.username = username;
        this.pass = pass;
    }
    public Supermarket(String namaSupermarket, String username, String pass, String confirmPass){
        this.namaSupermarket = namaSupermarket;
        this.username = username;
        this.pass = pass;
    }

    public void setIdSupermarket(int idSupermarket) {
        this.idSupermarket = idSupermarket;
    }

    public void setNamaSupermarket(String namaSupermarket) {
        this.namaSupermarket = namaSupermarket;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setConfirmPass(String confirmPass) {
        this.confirmPass = confirmPass;
    }
    
    public int getIdSupermarket() {
        return idSupermarket;
    }

    public String getNamaSupermarket() {
        return namaSupermarket;
    }

    public String getUsername() {
        return username;
    }

    public String getPass() {
        return pass;
    }

    public String getConfirmPass() {
        return confirmPass;
    }
    public void register(){
        controller.registSupermark(this);
    }
    public boolean login(){
        return controller.login(this);
    }
    public void add(Barang barang){
        controller.add(barang);
    }
    public void update(Barang barang){
        controller.update(barang);
    }
    public void update(Supermarket supermarket){
        controller.update(supermarket);
    }
    public void update(Cashier kasir){
        controller.update(kasir);
    }
    public void delete(Barang barang){
        controller.delete(barang);
    }
    public List<Barang> search(String keyw){
        return controller.search(keyw, this);
    }
    public void register(Cashier kasir){
        controller.registCashier(kasir);
    }
    public List<Barang> HasManyBarang(){
        return controller.getDataBarangs(this);
    }
    public Cashier belongsToCashier(){
        return controller.getKasir(this.idSupermarket);
    }
    public boolean isRegistered(Supermarket supermarket){
        return controller.getSupermarket(supermarket);
    }
    public boolean isRegistered(Cashier kasir){
        return controller.getKasir(kasir);
    }
    public List<Transaksi> hasManyTransaksi(){
        return controller.getTransaksis(this);
    }
}
