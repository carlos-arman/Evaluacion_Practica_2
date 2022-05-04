/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package registro.de.estudiantes;

import java.util.Scanner;
import java.sql.SQLException;
/**
 *
 * @author Armando
 */
public class Actualizar {
    Actualizar() throws SQLException{
        Scanner leer = new Scanner(System.in);
        Datos_Estudiantes Es = new Datos_Estudiantes();
        Cls_conexion cone = new Cls_conexion();
    
        System.out.println("ACTUALIZAR LOS DATOS");
        
        System.out.println("Ingrese el id del estudiante a modificar: ");
        Es.setId_estudiante(leer.nextInt());
        
        String tablaBuscar = "estudiantes";
        String camposBuscar = "id_estudiate, carnet_estudiante,nom_estudiante,ape_estudiante,edad_estudiante";
        String Buscar = "id_estudiante" +Es.getId_estudiante();
        
        cone.desplegarRegistros(tablaBuscar, camposBuscar, camposBuscar);
        
        System.out.println("Carnet esdiante: ");
        Es.setCarnet_estudiante(leer.nextInt());
        
        System.out.println("Nombre estudiante: ");
        Es.setNom_estudiante(leer.nextLine());
        
        System.out.println("Apellidos del estudiante: ");
        Es.setApe_estudiante(leer.nextLine());
        
        System.out.println("Edad: ");
        Es.setEdad_estudiante(leer.nextInt());
        
        
        String tabla ="estudiantes";
        String nuevosCampos = "'carnet_estudiante = '" + Es.getCarnet_estudiante() + "',nom_estudiante = '" + Es.getNom_estudiante()  + "',ape_estudiante = '" + Es.getApe_estudiante() + "'edad_estudiante=' "+ Es.getEdad_estudiante();
        
        cone.actualizarEliminarRegistro(tabla, nuevosCampos, Buscar);
        System.out.println("Modificado");
        
        CLASE_PRINCIPAL.MenuDesplegable();
    }
    
    
}
