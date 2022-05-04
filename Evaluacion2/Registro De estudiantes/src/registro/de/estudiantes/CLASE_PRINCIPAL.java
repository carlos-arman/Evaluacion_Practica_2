package registro.de.estudiantes;

import java.sql.SQLException;
import java.util.Scanner;

public class CLASE_PRINCIPAL {

    public static void main(String[] args) throws SQLException {
        MenuDesplegable();
    }

    static void MenuDesplegable() throws SQLException {
        Scanner opcion = new Scanner(System.in);
        String MenuOp;

        System.out.println("------------------------------");
        System.out.println("         OPCIONES:            ");
        System.out.println("------------------------------");
        System.out.println("     a. CREAR REGISTRO        ");
        System.out.println("     b. CONSULTAR REGISTRO    ");
        System.out.println("     c. ACTUALIZAR REGISTROS  ");
        System.out.println("     d. ELIMINAR REGISTRO     ");
        System.out.println("     e. SALIR                 ");
        System.out.println("------------------------------");
        System.out.println("     SELECCIONAR OPCION:      ");
        System.out.println("----------------------------- ");
        MenuOp = opcion.next();

        switch (MenuOp) {

            case "a": {
                PedirDatos pedir = new PedirDatos();
            }
            case "b": {
                //Read read = new Read();
            }
            case "c": {
                //Update update = new Update();
            }
            case "d": {
                //Delete delete = new Delete();
            }
            case "e": System.exit(0);
            default: System.out.println(" Seleccion invalida! ");
        }
    }
}