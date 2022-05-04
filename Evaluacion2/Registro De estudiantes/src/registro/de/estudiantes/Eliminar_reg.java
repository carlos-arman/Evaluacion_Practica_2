/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registro.de.estudiantes;

import java.sql.SQLException;
import java.util.Scanner;

public class Eliminar_reg {
    Eliminar_reg() throws SQLException{
        Scanner leer = new Scanner(System.in);
        Cls_conexion eliminar = new Cls_conexion ();
        System.out.println("<< ELIMINAR REGISTRO >>");
        
        System.out.println("Ingresar el id del registro");
        String  idEstudianteEliminar = leer.next();
        String tabla = "estudiantes";
        String campos = "*";
        String condicion = "id_estudiante = " + idEstudianteEliminar ;
        eliminar.desplegarRegistros(tabla, campos, condicion);
        
        System.out.println("Precione << A >> para comfirmar");
        String confimarBorrar = leer.next();
        
        if("A".equals(confimarBorrar)){
            String valoresCamposNuevos = "";
            
            eliminar.actualizarEliminarRegistro(tabla, valoresCamposNuevos, condicion);
            System.out.println("Registro borrado satisfactoriamente!");
        }
        CLASE_PRINCIPAL.MenuDesplegable();
    }
    
}
