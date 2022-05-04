/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package registro.de.estudiantes;

import java.sql.SQLException;


public class Read {
     public Read () throws SQLException {
        System.out.println("<< CONSULTA DE REGISTROS >>");
        Resultado();
    }
    private void Resultado () throws SQLException {
        try {
            Cls_conexion mostrar = new Cls_conexion ();
            
                String tabla = "tb_estudiante";
                String camposTabla = "*";
                String condicionBusqueda = "";
                
                mostrar.desplegarRegistros(tabla, camposTabla, condicionBusqueda);
        }catch (SQLException ex){
            System.out.println("Ha ocurrido el siguiente error: " + ex.getMessage());
        }finally{
            CLASE_PRINCIPAL.MenuDesplegable();
        }
    }
}