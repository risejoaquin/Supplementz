/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.supplementz.ConectionDB;

import java.sql.*;
import javax.swing.JOptionPane;


/**
 *
 * @author thinkpad
 */
public class ConnectionDB {
    Connection con;

   public static Connection establishConnection() {
        String url = "jdbc:mysql://localhost:3306/gym";
        String user = "root";
        String password = "elgod";

        try {
            Connection con = DriverManager.getConnection(url, user, password);
            JOptionPane.showMessageDialog(null, "Conexión exitosa");
            return con;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            JOptionPane.showMessageDialog(null, "Conexión fallida");
            return null;
        }
    }
 
}
