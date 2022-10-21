package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static final String user = "root";
    private static final String password = "root";
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/inventario"; // 127.0.0.1
    private static Connection conexion = null;
//    private static Conexion instancia;

    private Conexion() {

    }

    public static void cerrarConexion() {
        try {
            conexion.close();
            System.out.println("Se ha cerrado la conexion");
        } catch (SQLException ex) {
            System.out.println("No se ha podido cerrar la conexion");
        }
    }

//    public static Conexion getInstance() {
//        if (instancia == null) {
//            instancia = new Conexion();
//            System.out.println("Creando una conexion nueva");
//        } else {
//            System.out.println("En la sesion anterior");
//        }
//        return instancia;
//    }

    public static Connection Conectar() {
        try {
            Class.forName(driver);
            conexion = (Connection) DriverManager.getConnection(url, user, password);
            System.out.println("Se ha realizado la conexion!");
        } catch (ClassNotFoundException ex) {
            System.out.println("Algo ha salido mal");
        } catch (SQLException ex) {
            System.out.println("No se ha podido conectar");
        }
        return conexion;
    }
}
