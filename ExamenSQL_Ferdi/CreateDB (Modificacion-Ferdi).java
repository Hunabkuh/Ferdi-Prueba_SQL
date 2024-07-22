// CREATE DB //

package com.example.demo_jdbc2;

import java.sql.*;
import javax.sql.*;
import java.util.Scanner;

public class CreateDB {

    public static void main(String[] args) {

        try {
            // Aqui intentamos hacer la conexion / consultas

            // 1- decirle el driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2- Conectar con BD específica. Crear objeto Conection
            // decirle la direccion de la BD, tu usuario y contraseña
            String url = "jdbc:mysql://localhost:3306/serverTimezone=UTC";
            String user = "root";
            String password = "";

            Connection conexion1 = DriverManager.getConnection(url, user, password);

            System.out.println("*** conexión realizada! ***");

            // 3- Crear objeto Statement, que es el que se encarga de hacer las consultas
            Statement stat1 = conexion1.createStatement();

            // 4- Ejecutar instrucciones SQL sobre el objeto stat1 y mediante los métodos
            // executeQuery() y executeUpdate()
            // primero lo leemos todo y lo guardamos en objeto Resultset
            ResultSet resultado1 = stat1.executeQuery("SELECT * FROM libros");

            // 5- recorrer el resultado mediante bucle : READ
            verTodo(resultado1);

            while (resultado1.next()) {
                System.out.println("titulo: " + resultado1.getString("titulo")
                        + ", autor: " + resultado1.getString("autor") + ", año de publicacion: " +
                        resultado1.getString("anyo"));
            }

            // 6- INSERTAR datos en tabla con el método executeUpdate(): CREATE

            String insertar = "INSERT INTO clientes (nombre, email) VALUES ('Robert Rodriguez', 'rorod@muchocine.com')";

            stat1.executeUpdate(insertar);

            System.out.println("*** datos insertados! ***");

            // 7- Actualizar datos: UPDATE con comillas

            Scanner sc = new Scanner(System.in);
            /*
             * System.out.println("introduce el id:");
             * int idLanza = sc.nextInt();
             *
             * System.out.println("introduce el año de lanzamiento:");
             * int lanza = sc.nextInt();
             *
             * sc.nextLine();
             *
             * //sc.close();
             *
             * String actualizar =
             * "UPDATE discos SET lanzamiento = '"+lanza+"' WHERE id = '"+idLanza+"'";
             * stat1.executeUpdate(actualizar);
             *
             * System.out.println("*** datos actualizados! ***");
             */

            // 7bis- Actualizar datos: UPDATE con PreparedStatement ***************** ///

            // Scanner sc = new Scanner(System.in);

            // System.out.println("introduce el id para cambiar el año:");
            // int idLanza2 = sc.nextInt();

            // System.out.println("introduce el año de lanzamiento:");
            // int lanza2 = sc.nextInt();

            // sc.nextLine();

            // String actualizar2 = "UPDATE discos SET lanzamiento = ? WHERE id = ?";
            // String actualizarTitulo = "UPDATE discos SET titulo = ? WHERE id = ?";

            // // cambiar lanzamiento :setInt
            // PreparedStatement prep = conexion1.prepareStatement(actualizar2);
            // prep.setInt(1, lanza2); // orden ? y año lanzamiento
            // prep.setInt(2, idLanza2); // orden ? y num id
            // prep.execute();

            // System.out.println("introduce el id para cambiar el título:");
            // idLanza2 = sc.nextInt();
            // sc.nextLine();
            // System.out.println("introduce el nuevo título:");
            // String newTitulo = sc.nextLine();

            // // cambiar titulo :setString
            // PreparedStatement prep2 = conexion1.prepareStatement(actualizarTitulo);
            // prep2.setString(1, newTitulo);
            // prep2.setInt(2, idLanza2);
            // prep2.execute();

            // sc.close();

            // System.out.println("*** datos actualizados! ***");
            // ResultSet resultado2 = stat1.executeQuery("SELECT * FROM discos");
            // verTodo(resultado2);

            // 8- Borrar registros: DELETE
            /*
             * String borrar = "DELETE from discos WHERE ID = 3 ";
             * stat1.executeUpdate(borrar);
             *
             * System.out.println("*** registro borrado! ***");
             */

            conexion1.close();

        } catch (Exception e) {
            // aqui si no funciona se da mensje de error (o realizar accion)
            System.out.println("***** no funciona   :-( ");
            e.printStackTrace();
        }
    }

    // public static void verTodo(ResultSet resultado1) throws SQLException {
    // while (resultado1.next()) {
    // System.out.println("titulo: " + resultado1.getString("titulo") + ", banda: "
    // + resultado1.getString("banda")
    // + ", lanzamiento: " + resultado1.getString("lanzamiento") + ", ventas: "
    // + resultado1.getString("ventas") + " unidades");
    // }
    // }
}
