/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package registro.de.estudiantes;
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
    public Connection getConnection() {
      return conect;
    }
    
    public void guardarRegistros(String tabla, String camposTabla, String valoresCampo){
        Cls_conexion conectar = new Cls_conexion();
        Connection cone = conectar.getConnection();
        try{
            String sqlQueryStmt = "INSERT INTO" + tabla + "(" + camposTabla + ") VALUES (" + valoresCampo +");";
            Statement stmt;
            stmt = cone.createStatement();
            stmt.executeUpdate(sqlQueryStmt);
            stmt.close();
            cone.close();
            System.out.println("Registro guardado correctamente!");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
        public void actualizarEliminarRegistro(String tabla, String valoresCamposNuevos, String condicion) {

        Cls_conexion conectar = new Cls_conexion();
        Connection cone = conectar.getConnection();
        try {
            Statement stmt;
            String sqlQueryStmt;

            if (valoresCamposNuevos.isEmpty()) {
                sqlQueryStmt = "DELETE FROM " + tabla + " WHERE " + condicion + ";";
            } else {
                sqlQueryStmt = "UPDATE " + tabla + " SET " + valoresCamposNuevos + " WHERE " + condicion + ";";

            }
            stmt = cone.createStatement();
            stmt.executeUpdate(sqlQueryStmt);
            stmt.close();
            cone.close();
        } catch (SQLException ex) {
            System.out.println("HA OCURRIDO EL SIGUIENTE ERROR: " + ex.getMessage());

        }
    }

    public void desplegarRegistros(String tablaBuscar, String campoBuscar, String condicionBuscar) throws SQLException {
        Cls_conexion conectar = new Cls_conexion();
        Connection cone = conectar.getConnection();
        try {
            Statement stmt;
            String sqlQueryStmt;
            if (condicionBuscar.equals("")) {
                sqlQueryStmt = "SELECT " + campoBuscar + " FROM " + tablaBuscar + ";";

            } else {
                sqlQueryStmt = " SELECT " + campoBuscar + " FROM " + tablaBuscar + " WHERE " + condicionBuscar;

            }

            stmt = cone.createStatement();
            stmt.executeQuery(sqlQueryStmt);

            try ( ResultSet miResultSet = stmt.executeQuery(sqlQueryStmt)) {

                if (miResultSet.next()) {
                    ResultSetMetaData metaData = miResultSet.getMetaData();
                    int numColumnas = metaData.getColumnCount();
                    System.out.println("<<REGISTROS ALMACENADOS>>");
                    System.out.println();

                    for (int i = 1; i <= numColumnas; i++) {

                        System.out.printf("%-20s\t", metaData.getColumnName(i));
                    }

                    System.out.println();
                    do {
                        for (int i = 1; i <= numColumnas; i++) {
                            System.out.printf("%-20s\t", miResultSet.getObject(i));

                        }
                        System.out.println();

                    } while (miResultSet.next());
                    System.out.println();

                } else {
                    System.out.println("NO SE HAN ENCONTRADO REGISTROS");
                }
                miResultSet.close();
            } finally {

                stmt.close();
                cone.close();
            }
        } catch (SQLException ex) {

            System.out.println("HA OCURRIDO EL SIGUIENTE ERROR: " + ex.getMessage());
  
        }
    }
}
