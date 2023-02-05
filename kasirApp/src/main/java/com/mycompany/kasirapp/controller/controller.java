/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kasirapp.controller;

import com.mycompany.kasirapp.KasirApp;
import com.mycompany.kasirapp.authentication.Auth;
import com.mycompany.kasirapp.dbConnection.dbConfig;
import com.mycompany.kasirapp.model.Cashier;
import com.mycompany.kasirapp.model.Supermarket;
import com.mycompany.kasirapp.model.Barang;
import com.mycompany.kasirapp.model.Transaksi;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Acer SPIN
 */
public class controller {
    private static Connection connect;
    private static Statement statement;
    private static ResultSet resultData;
    
    public static void registSupermark(Supermarket supermarket){
        boolean data = true;
        connect = dbConfig.connection();
        try {
            String query = "INSERT INTO supermarket VALUES(null," + "'" +  supermarket.getNamaSupermarket() + "'" + "," + "'" + supermarket.getUsername() + "'" + "," + "'" + supermarket.getPass() + "'" + ")";
            statement = connect.createStatement();
            data = statement.execute(query);
            JOptionPane.showMessageDialog(null, "Succes");
            statement.close();
            connect.close();
        } catch (Exception e) {
            e.printStackTrace();
//            JOptionPane.showMessageDialog(null,"");
        }
    }
    public static void registCashier(Cashier c){
        boolean data = true;
        connect = dbConfig.connection();
        try {
            String query = "INSERT INTO kasir values (null," + "'" + c.getUsername() + "'" + "," + "'" + c.getPassword() + "'" + "," + Auth.supermarket.getIdSupermarket() + ")";
            statement = connect.createStatement();
            data = statement.execute(query);
            JOptionPane.showMessageDialog(null, "Succes");
            statement.close();
            connect.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static boolean login(Supermarket supermarket){
        connect = dbConfig.connection();
        boolean isPassMatch = false;
        try {
            Supermarket supermarketAuth = null;
            String query = "select* from supermarket where username = " + "'" + supermarket.getUsername() + "'" + " && " + "password = " + "'" + supermarket.getPass() + "'";
            statement = connect.createStatement();
            resultData = statement.executeQuery(query);
            while(resultData.next()){
                supermarketAuth = new Supermarket();
                supermarketAuth.setIdSupermarket(resultData.getInt("id_supermarket"));
                supermarketAuth.setNamaSupermarket(resultData.getString("nama_supermarket"));
                supermarketAuth.setUsername(resultData.getString("username"));
                supermarketAuth.setPass(resultData.getString("password"));
                isPassMatch = true;
            }
            
            Auth.supermarket = supermarketAuth;
            statement.close();
            connect.close();
        } catch (Exception e) {
        }
        return isPassMatch;
    }
        public static boolean login(Cashier kasir){
        boolean isPassMatch = false;
        connect = dbConfig.connection();
        Cashier kasirAuth = null;
        try {
            String query = "select* from kasir where username = " + "'" + kasir.getUsername() + "'" + " && " + "password = " + "'" + kasir.getPassword() + "'";
            statement = connect.createStatement();
            resultData = statement.executeQuery(query);
            while(resultData.next()){
                kasirAuth = new Cashier();
                kasirAuth.setIdKasir(resultData.getInt("id_kasir"));
                kasirAuth.setIdSupermark(resultData.getInt("id_supermarket"));
                kasirAuth.setUsername(resultData.getString("username"));
                kasirAuth.setPassword(resultData.getString("password"));
                isPassMatch = true;
            }
            Auth.cashier = kasirAuth;
            statement.close();
            connect.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isPassMatch;
    }
    
   
    public static List<Barang> getDataBarangs(Supermarket supermarket){
        connect = dbConfig.connection();
        List<Barang> barangs = new ArrayList<Barang>();
        try {
            String query = "select* from barang where id_supermarket =" + supermarket.getIdSupermarket();
            statement = connect.createStatement();
            resultData = statement.executeQuery(query);
            while(resultData.next()){
                Barang barang = new Barang();
                barang.setIdBarang(resultData.getInt("id_barang"));
                barang.setNamaBarang(resultData.getString("nama_barang"));
                barang.setStok(resultData.getInt("stok"));
                barang.setHargaBarang(resultData.getInt("harga_barang"));
                barang.setDiscount(resultData.getInt("discount"));
                barangs.add(barang);  
            }
//            statement.close();
//            connect.close();        
        } catch (Exception e) {
            e.getStackTrace();
            JOptionPane.showMessageDialog(null, "Data gagal diambil");
        }
        return barangs;
    }
    public static Barang getDataBarang(int idBarang, Cashier kasir){
        Barang barang = null;
        connect = dbConfig.connection();
        try {
            String query = "select* from barang where id_supermarket =" + kasir.belongsToSupermarket().getIdSupermarket() + " && " + "id_barang =" + idBarang;
            statement = connect.createStatement();
            resultData = statement.executeQuery(query);
            if(resultData.next() == true){
                barang = new Barang();
                barang.setIdBarang(resultData.getInt("id_barang"));
                barang.setIdSupermarket(resultData.getInt("id_supermarket"));
                barang.setNamaBarang(resultData.getString("nama_barang"));
                barang.setHargaBarang(resultData.getInt("harga_barang"));
                barang.setDiscount(resultData.getInt("discount"));
                barang.setStok(resultData.getInt("stok"));
            }
        } catch (Exception e) {
            e.getStackTrace();
            JOptionPane.showMessageDialog(null, "Data gagal diambil");
        }
        return barang;
    }
     public static void add(Barang b){
        boolean data = true;
        connect = dbConfig.connection();
        try {
            String query = "INSERT INTO barang VALUES(null," + b.getIdSupermarket() + "," + b.getIdKasir() + "," + "'" +  b.getNamaBarang()+ "'" + "," + b.getStok() + "," + b.getHargaBarang() + "," + b.getDiscount()+ ")";
            statement = connect.createStatement();
            data = statement.execute(query);
            JOptionPane.showMessageDialog(null, "Barang berhasil ditambahkan");
            statement.close();
            connect.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     public static void add(Transaksi transaksi){
        boolean data = true;
        connect = dbConfig.connection();
        try {
            String query = "INSERT INTO transaksi VALUES(null," + transaksi.getIdKasir()+ "," + transaksi.getIdSupermarket() + "," + "curdate()" + "," + transaksi.getQuantity() + "," + transaksi.getTotal() + ")";
            statement = connect.createStatement();
            statement.execute(query);
            JOptionPane.showMessageDialog(null, "Transaksi Succes");
            statement.close();
            connect.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void update(Barang b){
        boolean data = true;
        connect = dbConfig.connection();
        try {
            String query = "UPDATE barang SET nama_barang = " + "'" + b.getNamaBarang()+ "'" + "," + "stok = " + b.getStok() + "," + "harga_barang = " + b.getHargaBarang() + "," + "discount = " + b.getDiscount() +  " WHERE id_barang = " + b.getIdBarang();
//            System.out.println(query);
            statement = connect.createStatement();
            data = statement.execute(query);
            statement.close();
            connect.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void update(Supermarket supermarket){
        boolean data = true;
        connect = dbConfig.connection();
        try {
            String query = "UPDATE supermarket SET nama_supermarket = " + "'" + supermarket.getNamaSupermarket()+ "'" + "," + "password =" + "'" + supermarket.getPass()+ "'" +  " WHERE id_supermarket = " + supermarket.getIdSupermarket();
            statement = connect.createStatement();
            data = statement.execute(query);
            JOptionPane.showMessageDialog(null, "Update Succes");
            statement.close();
            connect.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void update(Cashier kasir){
        boolean data = true;
        connect = dbConfig.connection();
        try {
            String query = "UPDATE kasir SET password = " + "'" + kasir.getPassword()+ "'" +  " WHERE id_supermarket = " + kasir.getIdKasir();
            statement = connect.createStatement();
            data = statement.execute(query);
            JOptionPane.showMessageDialog(null, "Update Succes");
            statement.close();
            connect.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void delete(Barang b){
        boolean data = true;
        connect = dbConfig.connection();
        try {
            String query = "DELETE FROM barang where id_barang = " + b.getIdBarang();
//            System.out.println(query);
            statement = connect.createStatement();
            data = statement.execute(query);
            JOptionPane.showMessageDialog(null, "Delete Succes");
            statement.close();
            connect.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        public static List<Barang> search(String keyw, Supermarket supermarket){
        connect = dbConfig.connection();
        List<Barang> barangs = new ArrayList<Barang>();
        try {
            String condition = "'%" + keyw + "%'";
            String query = "SELECT* FROM barang "
                    + "where id_supermarket=" + supermarket.getIdSupermarket() + " AND "
                    + "nama_barang LIKE" + condition;
//                    + "stok LIKE" + condition + " OR "
//                    + "harga_barang LIKE" + condition + " OR "
//                    + "id_barang LIKE" + condition + " OR "
//                    + "discount LIKE" + condition;
            statement = connect.createStatement();
            resultData = statement.executeQuery(query);
            
            while (resultData.next()) {
                Barang barang = new Barang();
                barang.setIdBarang(resultData.getInt("id_barang"));
                barang.setNamaBarang(resultData.getString("nama_barang"));
                barang.setStok(resultData.getInt("stok"));
                barang.setHargaBarang(resultData.getInt("harga_barang"));
                barang.setDiscount(resultData.getInt("discount"));
                barangs.add(barang);       
            }
//            statement.close();
//            connect.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Gagal mengambil data");
        }
        return barangs;
    }
    public static Supermarket getSupermarket(int idSupermarket){
        connect = dbConfig.connection();
        Supermarket supermarket = new Supermarket();
        try {
            String query = "select* from supermarket where id_supermarket =" + idSupermarket;
            statement = connect.createStatement();
            resultData = statement.executeQuery(query);
            if(resultData.next() == true){
                supermarket.setIdSupermarket(resultData.getInt("id_supermarket"));
                supermarket.setNamaSupermarket(resultData.getString("nama_supermarket"));
                supermarket.setUsername(resultData.getString("username"));
                supermarket.setPass(resultData.getString("password"));
            }
        } catch (Exception e) {
            e.getStackTrace();
            JOptionPane.showMessageDialog(null, "Data gagal diambil");
        }
        return supermarket;
    }
    public static boolean getSupermarket(Supermarket supermarket){
        connect = dbConfig.connection();
        boolean isRegistered = false;
        try {
            String query = "select* from supermarket where username =" + "'" + supermarket.getUsername() + "'";
            statement = connect.createStatement();
            resultData = statement.executeQuery(query);
            if(resultData.next() == true){
                isRegistered = true;
            }
        } catch (Exception e) {
            e.getStackTrace();
            JOptionPane.showMessageDialog(null, "Data gagal diambil");
        }
        return isRegistered;
    }
    public static Cashier getKasir(int idSupermarket){
        connect = dbConfig.connection();
        Cashier kasir = null;
        try {
            String query = "select* from kasir where id_supermarket =" + idSupermarket;
            statement = connect.createStatement();
            resultData = statement.executeQuery(query);
            if(resultData.next() == true){
                kasir = new Cashier();
                kasir.setIdKasir(resultData.getInt("id_kasir"));
                kasir.setIdSupermark(resultData.getInt("id_supermarket"));
                kasir.setUsername(resultData.getString("username"));
                kasir.setPassword(resultData.getString("password"));
            }
        } catch (Exception e) {
            e.getStackTrace();
            JOptionPane.showMessageDialog(null, "Data gagal diambil");
        }
        return kasir;
    }
    public static boolean getKasir(Cashier kasir){
        connect = dbConfig.connection();
        boolean isRegistered = false;
        try {
            String query = "select* from kasir where username =" + "'" + kasir.getUsername() + "'";
            statement = connect.createStatement();
            resultData = statement.executeQuery(query);
            if(resultData.next() == true){
                isRegistered = true;
            }
        } catch (Exception e) {
            e.getStackTrace();
            JOptionPane.showMessageDialog(null, "Data gagal diambil");
        }
        return isRegistered;
    }
    public static List<Transaksi> getTransaksis(Cashier kasir){
        connect = dbConfig.connection();
        List<Transaksi> transaksis = new ArrayList<Transaksi>();
        try {
            String query = "select* from transaksi where id_kasir =" + kasir.getIdKasir();
            statement = connect.createStatement();
            resultData = statement.executeQuery(query);
            while(resultData.next()){
                Transaksi transaksi = new Transaksi();
                transaksi.setIdTransaksi(resultData.getInt("id_transaksi"));
                transaksi.setIdSupermarket(resultData.getInt("id_supermarket"));
                transaksi.setIdKasir(resultData.getInt("id_kasir"));
                transaksi.setDate(resultData.getString("tanggal"));
                transaksi.setQuantity(resultData.getInt("quantity"));
                transaksi.setTotal(resultData.getInt("total"));
                transaksis.add(transaksi);
            }
//            statement.close();
//            connect.close();        
        } catch (Exception e) {
            e.getStackTrace();
            JOptionPane.showMessageDialog(null, "Data gagal diambil");
        }
        return transaksis;
    }
    public static List<Transaksi> getTransaksis(Supermarket supermarket){
        connect = dbConfig.connection();
        List<Transaksi> transaksis = new ArrayList<Transaksi>();
        try {
            String query = "select* from transaksi where id_supermarket =" + supermarket.getIdSupermarket();
            statement = connect.createStatement();
            resultData = statement.executeQuery(query);
            while(resultData.next()){
                Transaksi transaksi = new Transaksi();
                transaksi.setIdTransaksi(resultData.getInt("id_transaksi"));
                transaksi.setIdSupermarket(resultData.getInt("id_supermarket"));
                transaksi.setIdKasir(resultData.getInt("id_kasir"));
                transaksi.setDate(resultData.getString("tanggal"));
                transaksi.setQuantity(resultData.getInt("quantity"));
                transaksi.setTotal(resultData.getInt("total"));
                transaksis.add(transaksi);
            }
//            statement.close();
//            connect.close();        
        } catch (Exception e) {
            e.getStackTrace();
            JOptionPane.showMessageDialog(null, "Data gagal diambil");
        }
        return transaksis;
    }
}
