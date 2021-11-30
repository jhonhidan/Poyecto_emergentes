package com.emergentes.utilitarios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jhonny
 */
public class ConexionDB {

    static String driver = "com.mysql.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:3306/matricula";
    static String usuario = "root";
    static String password = "";

    protected Connection conn = null;

    public ConexionDB() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, usuario, password);
            if (conn != null) {
                System.out.println("Conexion OK" + conn);
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Error de Driver");
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            System.out.println("Error de Conexion de Base de Datos");
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //conexion de base de datos 
    public Connection conectar() {
        return conn;
    }

    //desconexion de base de datos
    public void desconectar() {
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Erro al cerrar base de datos");
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
