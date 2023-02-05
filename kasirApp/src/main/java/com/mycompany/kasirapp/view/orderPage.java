/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.kasirapp.view;

import com.mycompany.kasirapp.authentication.Auth;
import com.mycompany.kasirapp.controller.controller;
import com.mycompany.kasirapp.model.Cashier;
import com.mycompany.kasirapp.model.Supermarket;
import com.mycompany.kasirapp.model.Barang;
import com.mycompany.kasirapp.model.Transaksi;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
/**
 *
 * @author Acer SPIN
 */
public class orderPage extends javax.swing.JPanel {
    private JPanel goodsPage,index,settingsPage;
    cashierHistoryPage cashierHistoryPage;
    private ResultSet resultData;
    /**
     * Creates new form orderPage
     */
    public orderPage() {
        initComponents();
        this.setSize(1280, 832);
        tableDaftarBarang.getTableHeader().setBackground(Color.red);
        notif.setVisible(false);
    }

    public void setGoodsPage(JPanel goodsPage) {
        this.goodsPage = goodsPage;
    }

    public void setHistoryPage(cashierHistoryPage cashierHistoryPage) {
        this.cashierHistoryPage = cashierHistoryPage;
    }

    public void setSettingsPage(JPanel settingsPage) {
        this.settingsPage = settingsPage;
    }
    public void setIndex(JPanel index) {
        this.index = index;
    }
    public void fillTableBarang(List<Barang> barangs){
        Supermarket supermarket = Auth.supermarket;
        Object data[][] = new Object[0][0];
  
        data = new Object[barangs.size()][5];
        for(int i = 0; i < barangs.size(); i++){
            data[i][0] = barangs.get(i).getIdBarang();
            data[i][1] = barangs.get(i).getNamaBarang();
            data[i][2] = barangs.get(i).getStok();
            data[i][3] = barangs.get(i).getHargaBarang();
            data[i][4] = barangs.get(i).getDiscount();
        }
        String judul[] = {"Id Barang","Nama Barang", "Stok", "Harga Barang", "Discount"};
//        JTable a = new JTable(data,judul);
        tableDaftarBarang.setModel(new DefaultTableModel(data, judul));
        jScrollPane5.setViewportView(tableDaftarBarang);
    }
     public void addToCart(Barang barang){
          DefaultTableModel tableModel = (DefaultTableModel) tableShop.getModel();
          tableModel.addRow(new Object[]{barang.getIdBarang(),barang.getNamaBarang(), inputQuantity.getValue(), barang.getHargaBarang(),barang.getDiscount()});
    }
    public boolean validasiInput(){
        boolean inputId = (inputQuantity.getValue()+"").trim().equals("0");
        if(inputId == true){
            JOptionPane.showMessageDialog(null,"Quantity tidak boleh 0");
        }
        return !inputId;
    }
    public int countTotalQuantity(){
        int totalQuantity = 0;
        for(int i = 0; i < tableShop.getRowCount(); i++){
            totalQuantity += Integer.parseInt(tableShop.getValueAt(i, 2)+"");
        }
        return totalQuantity;
    }
    public void clearCart(){
        DefaultTableModel model = (DefaultTableModel) tableShop.getModel();
        model.setRowCount(0);
    }
    public void clearTransaksi(){
        subTotal.setText("Rp.0");
        discount.setText("Rp.0");
        inputNominalBayar.setText("0");
        total.setText("Rp.0");
        kembalian.setText("Rp.0");
    }
    private int countSubTotal(){
        int subtotal = 0;
        for(int i = 0; i < tableShop.getRowCount(); i++){
            subtotal += Integer.parseInt(tableShop.getValueAt(i, 3)+"") * (Integer.parseInt(tableShop.getValueAt(i, 2)+""));
        }
        return subtotal;
    }
    private int countDiscount(){
       int totalDisc = 0;
       double discountSatuan = 0;
       int hargaBarang = 0;
       int quantity = 0;
       int discount = 0;
       for(int i = 0; i < tableShop.getRowCount(); i++){
            hargaBarang = Integer.parseInt(tableShop.getValueAt(i, 3)+"");
            quantity = (Integer.parseInt(tableShop.getValueAt(i, 2)+""));
            discount = Integer.parseInt(tableShop.getValueAt(i, 4)+"");
            discountSatuan = (double) discount / 100 * hargaBarang * quantity;    
            totalDisc = (int) Math.round(totalDisc + discountSatuan);
        }
       System.out.println("");
       return totalDisc;
    }
    private int countPayAmount(){
        int payAmount = 0;
        try {
            int inputNominalBarang = Integer.parseInt(inputNominalBayar.getText());
            payAmount = inputNominalBarang;
        } catch (Exception e) {
            String nominalBayar = inputNominalBayar.getText();
            if(nominalBayar.length() != 0){
                inputNominalBayar.setText(nominalBayar.substring(0, nominalBayar.length() - 1));
                JOptionPane.showMessageDialog(null,"Nominal bayar hanya boleh angka");
            }   
        }
        return payAmount;
    }
    private int countTotal(int subtotal, int discount){
        return subtotal - discount;
    }
    private int countReturn(int total, int nominalBayar){
        return total - nominalBayar;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        notif = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        yesbtn = new javax.swing.JButton();
        nobtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        registerLabel = new javax.swing.JLabel();
        registerLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        subTotal = new javax.swing.JLabel();
        subTotalLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        discount = new javax.swing.JLabel();
        discountLabel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        nominalBayarLabel = new javax.swing.JLabel();
        inputNominalBayar = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        total = new javax.swing.JLabel();
        totalLabel = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        kembalian = new javax.swing.JLabel();
        kembalianLabel = new javax.swing.JLabel();
        proceedBtn = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        orderBtn = new javax.swing.JButton();
        historyBtn = new javax.swing.JButton();
        logoutBtn = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableDaftarBarang = new javax.swing.JTable();
        inputIdBarang = new javax.swing.JSpinner();
        labelCariBarang = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        labelQuantity = new javax.swing.JLabel();
        labelNamaBarang = new javax.swing.JLabel();
        inputCariBarang = new javax.swing.JTextField();
        searchBtn = new javax.swing.JButton();
        addChartBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableShop = new javax.swing.JTable();
        registerLabel2 = new javax.swing.JLabel();
        registerLabel3 = new javax.swing.JLabel();
        inputQuantity = new javax.swing.JSpinner();

        setBackground(new java.awt.Color(245, 245, 245));

        notif.setBackground(new java.awt.Color(255, 255, 255));
        notif.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Apakah anda ingin keluar?");

        yesbtn.setBackground(new java.awt.Color(33, 146, 255));
        yesbtn.setForeground(new java.awt.Color(255, 255, 255));
        yesbtn.setText("YA");
        yesbtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        yesbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yesbtnActionPerformed(evt);
            }
        });

        nobtn.setText("No");
        nobtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nobtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nobtnActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Acer SPIN\\OneDrive\\Dokumen\\NetBeansProjects\\kasirApp\\src\\main\\java\\com\\mycompany\\kasirapp\\icons\\danger.png")); // NOI18N

        javax.swing.GroupLayout notifLayout = new javax.swing.GroupLayout(notif);
        notif.setLayout(notifLayout);
        notifLayout.setHorizontalGroup(
            notifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(notifLayout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, notifLayout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(38, 38, 38))
            .addGroup(notifLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(yesbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(nobtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        notifLayout.setVerticalGroup(
            notifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(notifLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(notifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(yesbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nobtn, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        registerLabel.setFont(new java.awt.Font("Poppins", 0, 24)); // NOI18N
        registerLabel.setText("Barang");

        registerLabel1.setFont(new java.awt.Font("Poppins", 1, 24)); // NOI18N
        registerLabel1.setForeground(new java.awt.Color(33, 146, 255));
        registerLabel1.setText("Daftar");

        jPanel1.setBackground(new java.awt.Color(245, 245, 245));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setPreferredSize(new java.awt.Dimension(331, 37));

        subTotal.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        subTotal.setForeground(new java.awt.Color(0, 128, 0));
        subTotal.setText("Rp0");

        subTotalLabel.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        subTotalLabel.setText("Sub Total");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(subTotalLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 260, Short.MAX_VALUE)
                .addComponent(subTotal)
                .addGap(58, 58, 58))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(subTotal)
                    .addComponent(subTotalLabel))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setPreferredSize(new java.awt.Dimension(331, 37));

        discount.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        discount.setForeground(new java.awt.Color(255, 0, 0));
        discount.setText("Rp0");

        discountLabel.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        discountLabel.setText("Discount");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(discountLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 262, Short.MAX_VALUE)
                .addComponent(discount)
                .addGap(59, 59, 59))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(discount)
                    .addComponent(discountLabel))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(245, 245, 245));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setPreferredSize(new java.awt.Dimension(331, 37));

        nominalBayarLabel.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        nominalBayarLabel.setText("Nominal Bayar");

        inputNominalBayar.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        inputNominalBayar.setForeground(new java.awt.Color(204, 204, 204));
        inputNominalBayar.setText("0");
        inputNominalBayar.setToolTipText("");
        inputNominalBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputNominalBayarActionPerformed(evt);
            }
        });
        inputNominalBayar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                inputNominalBayarKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                inputNominalBayarKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(nominalBayarLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 220, Short.MAX_VALUE)
                .addComponent(inputNominalBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nominalBayarLabel)
                    .addComponent(inputNominalBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setPreferredSize(new java.awt.Dimension(331, 37));

        total.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        total.setForeground(new java.awt.Color(0, 128, 0));
        total.setText("Rp0");

        totalLabel.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        totalLabel.setText("Total");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(totalLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 287, Short.MAX_VALUE)
                .addComponent(total)
                .addGap(61, 61, 61))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(total)
                    .addComponent(totalLabel))
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(245, 245, 245));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel5.setPreferredSize(new java.awt.Dimension(331, 37));

        kembalian.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        kembalian.setForeground(new java.awt.Color(255, 0, 0));
        kembalian.setText("Rp0");

        kembalianLabel.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        kembalianLabel.setText("Kembalian");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(kembalianLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 251, Short.MAX_VALUE)
                .addComponent(kembalian)
                .addGap(58, 58, 58))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kembalian)
                    .addComponent(kembalianLabel))
                .addContainerGap())
        );

        proceedBtn.setBackground(new java.awt.Color(33, 146, 255));
        proceedBtn.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        proceedBtn.setForeground(new java.awt.Color(255, 255, 255));
        proceedBtn.setText("Proceed");
        proceedBtn.setBorder(null);
        proceedBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        proceedBtn.setMaximumSize(new java.awt.Dimension(331, 23));
        proceedBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proceedBtnActionPerformed(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(33, 146, 255));

        orderBtn.setIcon(new javax.swing.ImageIcon("C:\\Users\\Acer SPIN\\OneDrive\\Dokumen\\NetBeansProjects\\kasirApp\\src\\main\\java\\com\\mycompany\\kasirapp\\icons\\goods-fill.png")); // NOI18N
        orderBtn.setContentAreaFilled(false);
        orderBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        orderBtn.setMargin(new java.awt.Insets(30, 15, 0, 15));
        orderBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderBtnActionPerformed(evt);
            }
        });

        historyBtn.setIcon(new javax.swing.ImageIcon("C:\\Users\\Acer SPIN\\OneDrive\\Dokumen\\NetBeansProjects\\kasirApp\\src\\main\\java\\com\\mycompany\\kasirapp\\icons\\history.png")); // NOI18N
        historyBtn.setContentAreaFilled(false);
        historyBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        historyBtn.setMargin(new java.awt.Insets(30, 15, 0, 15));
        historyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                historyBtnActionPerformed(evt);
            }
        });

        logoutBtn.setIcon(new javax.swing.ImageIcon("C:\\Users\\Acer SPIN\\OneDrive\\Dokumen\\NetBeansProjects\\kasirApp\\src\\main\\java\\com\\mycompany\\kasirapp\\icons\\logout.png")); // NOI18N
        logoutBtn.setContentAreaFilled(false);
        logoutBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logoutBtn.setMargin(new java.awt.Insets(30, 15, 0, 15));
        logoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(orderBtn)
                    .addComponent(historyBtn)
                    .addComponent(logoutBtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(orderBtn)
                .addGap(6, 6, 6)
                .addComponent(historyBtn)
                .addGap(6, 6, 6)
                .addComponent(logoutBtn)
                .addGap(0, 601, Short.MAX_VALUE))
        );

        tableDaftarBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id Barang", "Nama Barang", "Stock", "Harga Barang", "Discount"
            }
        ));
        tableDaftarBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableDaftarBarangMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tableDaftarBarang);

        inputIdBarang.setBorder(null);
        inputIdBarang.setPreferredSize(new java.awt.Dimension(80, 22));

        labelCariBarang.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        labelCariBarang.setText("Cari Barang");

        jPanel7.setLayout(new java.awt.GridBagLayout());

        labelQuantity.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        labelQuantity.setText("Quantity");

        labelNamaBarang.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        labelNamaBarang.setText("Id Barang");

        inputCariBarang.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        inputCariBarang.setPreferredSize(new java.awt.Dimension(222, 20));
        inputCariBarang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                inputCariBarangKeyReleased(evt);
            }
        });

        searchBtn.setIcon(new javax.swing.ImageIcon("C:\\Users\\Acer SPIN\\OneDrive\\Dokumen\\NetBeansProjects\\kasirApp\\src\\main\\java\\com\\mycompany\\kasirapp\\icons\\search-sm.png")); // NOI18N
        searchBtn.setBorder(null);
        searchBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        addChartBtn.setBackground(new java.awt.Color(245, 245, 245));
        addChartBtn.setIcon(new javax.swing.ImageIcon("C:\\Users\\Acer SPIN\\OneDrive\\Dokumen\\NetBeansProjects\\kasirApp\\src\\main\\java\\com\\mycompany\\kasirapp\\icons\\add.png")); // NOI18N
        addChartBtn.setBorder(null);
        addChartBtn.setContentAreaFilled(false);
        addChartBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addChartBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addChartBtnActionPerformed(evt);
            }
        });

        tableShop.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idBarang", "Nama Barang", "Quantity", "Harga Barang", "Discount"
            }
        ));
        jScrollPane1.setViewportView(tableShop);

        registerLabel2.setFont(new java.awt.Font("Poppins", 1, 24)); // NOI18N
        registerLabel2.setForeground(new java.awt.Color(33, 146, 255));
        registerLabel2.setText("Shopping");

        registerLabel3.setFont(new java.awt.Font("Poppins", 0, 24)); // NOI18N
        registerLabel3.setText("Cart");

        inputQuantity.setBorder(null);
        inputQuantity.setPreferredSize(new java.awt.Dimension(80, 22));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(100, 100, 100)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(registerLabel1)
                        .addGap(6, 6, 6)
                        .addComponent(registerLabel)
                        .addGap(454, 454, 454)
                        .addComponent(registerLabel2)
                        .addGap(6, 6, 6)
                        .addComponent(registerLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelCariBarang)
                            .addComponent(inputCariBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(196, 196, 196)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(notif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(207, 207, 207)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(222, 222, 222)
                        .addComponent(searchBtn))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelNamaBarang)
                            .addComponent(inputIdBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(546, 546, 546)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelQuantity)
                        .addGap(561, 561, 561)
                        .addComponent(proceedBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(inputQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addChartBtn)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(registerLabel1)
                    .addComponent(registerLabel)
                    .addComponent(registerLabel2)
                    .addComponent(registerLabel3))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(339, 339, 339)
                        .addComponent(labelCariBarang)
                        .addGap(6, 6, 6)
                        .addComponent(inputCariBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(273, 273, 273)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(154, 154, 154)
                                .addComponent(notif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(230, 230, 230)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(368, 368, 368)
                        .addComponent(searchBtn))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(labelNamaBarang)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputIdBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(labelQuantity))
                    .addComponent(proceedBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(inputQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(addChartBtn))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void proceedBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proceedBtnActionPerformed
        if(tableShop.getRowCount() == 0){
            JOptionPane.showMessageDialog(null,"Keranjang Kosong");
        }else{
            Transaksi transaksi = new Transaksi();
            Cashier kasir = Auth.cashier;
            transaksi.setIdKasir(kasir.getIdKasir());
            transaksi.setIdSupermarket(kasir.getIdKasir());
            transaksi.setQuantity(countTotalQuantity());
            transaksi.setTotal(countTotal(countSubTotal(), countDiscount()));
            
            for(int i = 0; i < tableShop.getRowCount(); i++){
                int quantity = Integer.parseInt(tableShop.getValueAt(i, 2)+"");
                Barang barang = kasir.getBarang(Integer.parseInt(tableShop.getValueAt(i, 0)+""));
                barang.setStok(barang.getStok() - quantity);
                kasir.update(barang);
            }
            kasir.add(transaksi);
            clearCart();
            fillTableBarang(kasir.HasManyBarang());
            clearTransaksi();
        }    
    }//GEN-LAST:event_proceedBtnActionPerformed

    private void orderBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderBtnActionPerformed

    }//GEN-LAST:event_orderBtnActionPerformed

    private void historyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historyBtnActionPerformed
        this.setVisible(false);
        cashierHistoryPage.setVisible(true);
        cashierHistoryPage.fillTableHistory();
    }//GEN-LAST:event_historyBtnActionPerformed

    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtnActionPerformed
        notif.setVisible(true);
    }//GEN-LAST:event_logoutBtnActionPerformed

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchBtnActionPerformed

    private void addChartBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addChartBtnActionPerformed
        Supermarket supermarket = Auth.cashier.belongsToSupermarket();
        int idBarang = Integer.parseInt(inputIdBarang.getValue()+"");
        Cashier kasir = Auth.cashier;
        Barang barang = kasir.getBarang(idBarang);

        if(barang != null){
            if(validasiInput() == true){
                addToCart(barang);
                int inputSubtotal = countSubTotal();
                int inputDiscount = countDiscount();
                int inputTotal = countTotal(inputSubtotal, inputDiscount);
                subTotal.setText("Rp." + inputSubtotal);
                discount.setText("Rp." + inputDiscount);
                total.setText("Rp." + inputTotal);
                JOptionPane.showMessageDialog(null,"Berhasil ditambahkan"); 
            }
        }else{
            JOptionPane.showMessageDialog(null,"Id barang tidak ditemukan"); 
        }

//        System.out.println("subtotal : " + countSubTotal());
//        System.out.println("discount : " + countDiscount());
    }//GEN-LAST:event_addChartBtnActionPerformed

    private void yesbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yesbtnActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        this.index.setVisible(true);
        this.notif.setVisible(false);
    }//GEN-LAST:event_yesbtnActionPerformed

    private void nobtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nobtnActionPerformed
        // TODO add your handling code here:
        this.notif.setVisible(false);
        this.setVisible(true);
    }//GEN-LAST:event_nobtnActionPerformed

    private void tableDaftarBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDaftarBarangMouseClicked

        int row = tableDaftarBarang.getSelectedRow();
        List<String> columsList = new ArrayList<String>();
        for (int i = 0; i < tableDaftarBarang.getColumnCount(); i++) {
            columsList.add(tableDaftarBarang.getValueAt(row, i) + "");
        }
        inputIdBarang.setValue(Integer.valueOf(columsList.get(0)));
    }//GEN-LAST:event_tableDaftarBarangMouseClicked

    private void inputNominalBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputNominalBayarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputNominalBayarActionPerformed

    private void inputNominalBayarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputNominalBayarKeyPressed
//        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
//            System.out.println("enter");
//        }    
//        System.out.println(evt.getKeyCaode());
    }//GEN-LAST:event_inputNominalBayarKeyPressed

    private void inputNominalBayarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputNominalBayarKeyReleased
        kembalian.setText("Rp." + (countTotal(countSubTotal(), countDiscount()) - countPayAmount()));
        System.out.println(countPayAmount());
    }//GEN-LAST:event_inputNominalBayarKeyReleased

    private void inputCariBarangKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputCariBarangKeyReleased
        Supermarket supermarket = Auth.cashier.belongsToSupermarket();
        String keyw = inputCariBarang.getText();
        fillTableBarang(supermarket.search(keyw));
    }//GEN-LAST:event_inputCariBarangKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addChartBtn;
    private javax.swing.JLabel discount;
    private javax.swing.JLabel discountLabel;
    private javax.swing.JButton historyBtn;
    private javax.swing.JTextField inputCariBarang;
    private javax.swing.JSpinner inputIdBarang;
    private javax.swing.JTextField inputNominalBayar;
    private javax.swing.JSpinner inputQuantity;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel kembalian;
    private javax.swing.JLabel kembalianLabel;
    private javax.swing.JLabel labelCariBarang;
    private javax.swing.JLabel labelNamaBarang;
    private javax.swing.JLabel labelQuantity;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JButton nobtn;
    private javax.swing.JLabel nominalBayarLabel;
    private javax.swing.JPanel notif;
    private javax.swing.JButton orderBtn;
    private javax.swing.JButton proceedBtn;
    private javax.swing.JLabel registerLabel;
    private javax.swing.JLabel registerLabel1;
    private javax.swing.JLabel registerLabel2;
    private javax.swing.JLabel registerLabel3;
    private javax.swing.JButton searchBtn;
    private javax.swing.JLabel subTotal;
    private javax.swing.JLabel subTotalLabel;
    private javax.swing.JTable tableDaftarBarang;
    private javax.swing.JTable tableShop;
    private javax.swing.JLabel total;
    private javax.swing.JLabel totalLabel;
    private javax.swing.JButton yesbtn;
    // End of variables declaration//GEN-END:variables
}
