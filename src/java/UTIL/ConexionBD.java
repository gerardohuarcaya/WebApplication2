package UTIL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    // Configuracion local de MySQL.
    // Cambia estos valores si tu instalacion utiliza otros datos.
    private static final String URL = "jdbc:mysql://localhost:3306/mydb6?useSSL=false&serverTimezone=UTC";
    private static final String USUARIO = "root";
    private static final String CLAVE = "";

    public static Connection getConexionBD() {
        try {
            // Nombre del controlador de MySQL Connector/J actual.
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection cn = DriverManager.getConnection(URL, USUARIO, CLAVE);
            System.out.println("Conexion a MySQL establecida correctamente.");
            return cn;

        } catch (ClassNotFoundException e) {
            System.err.println("No se encontro el controlador MySQL Connector/J.");
            System.err.println("Verifica que mysql-connector-j este agregado a las bibliotecas del proyecto.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("No se pudo conectar con MySQL.");
            System.err.println("Verifica que MySQL este iniciado y que la base de datos, usuario y clave sean correctos.");
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {
        try (Connection cn = getConexionBD()) {
            if (cn != null) {
                System.out.println("Prueba de conexion finalizada correctamente.");
            } else {
                System.err.println("La prueba de conexion fallo.");
            }
        } catch (SQLException e) {
            System.err.println("Error al cerrar la conexion.");
            e.printStackTrace();
        }
    }
}
