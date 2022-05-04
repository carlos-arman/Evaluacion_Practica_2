/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package registro.de.estudiantes;
import java.sql.SQLException;
import java.util.Scanner;
/**
 *
 * @author Armando
 */
public class PedirDatos {
    PedirDatos() throws SQLException{
        Scanner le = new Scanner(System.in);
        Datos_Estudiantes Es = new Datos_Estudiantes();
        System.out.println("Datos del estudiante");
        
        System.out.println("Carnet del estudiante: ");
        Es.setCarnet_estudiante(le.nextInt());
        
        System.out.println("Nombre del estudiante: ");
        Es.setNom_estudiante(le.nextLine());
        
        System.out.println("Apellidos del estudiante: ");
        Es.setApe_estudiante(le.nextLine());
        
        System.out.println("Edad del estudiante: ");
        Es.setEdad_estudiante(le.nextInt());
    }
}
