/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kasirapp.component;

import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author Acer SPIN
 */
public class frame {
    public static void center(JFrame jFrame){
        int screenW = Toolkit.getDefaultToolkit().getScreenSize().width;        
        int screenH = Toolkit.getDefaultToolkit().getScreenSize().height;
        int xCenter = (screenW - jFrame.getWidth()) / 2;
        int yCenter = (screenH - jFrame.getHeight()) / 2;
        jFrame.setLocation(xCenter, yCenter);
    }
}
