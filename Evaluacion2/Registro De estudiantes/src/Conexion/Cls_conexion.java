/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Conexion;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Armando
 */
public class Cls_conexion{ 
    
    Connection conect = null;
    public Connection conexion(){
        try{
            Class.forName("org.gjt.mm.mysql.Driver");
            conect = DriverManager.getConnection("jdbc:mysql://localhost/bd","root ", "");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error" + e);
        }
     return conect;
    }
}
