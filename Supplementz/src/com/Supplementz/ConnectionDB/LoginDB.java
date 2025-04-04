package com.Supplementz.ConnectionDB;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

/**
 *
 * @author compu
 */
public class LoginDB {
public void ValidarUsuario(JTextField usuario, JPasswordField contrasena) {

        try {
            ResultSet rs = null;
            PreparedStatement ps = null;

            
            com.Supplementz.ConnectionDB.ConnectionDB conexion = new com.Supplementz.ConnectionDB.ConnectionDB();
            Connection con = conexion.establishConnection();

            String consulta = "SELECT * FROM usuario WHERE nombre = ? AND contrasena = ?";
            ps = con.prepareStatement(consulta);

            ps.setString(1, usuario.getText());
            ps.setString(2, String.valueOf(contrasena.getPassword()));

            rs = ps.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso");
                
            } else {
                JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al validar el usuario: " + e.getMessage());
        }
    }
}
