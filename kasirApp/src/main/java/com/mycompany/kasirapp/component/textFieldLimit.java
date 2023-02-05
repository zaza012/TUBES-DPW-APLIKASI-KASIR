/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kasirapp.component;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
/**
 *
 * @author Acer SPIN
 */
public class textFieldLimit extends PlainDocument{
    int limit;
    
    public textFieldLimit(int limit){
        super();
        this.limit = limit;
    }
    
    @Override
    public void insertString( int offset, String  str, AttributeSet attr ) throws BadLocationException {
    if (str == null) return;
        System.out.println(str.length());
    if ((getLength() + str.length()) <= limit) {
      super.insertString(offset, str, attr);
    }
  }
}
