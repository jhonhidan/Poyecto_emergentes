package com.emergentes.utilitarios;

import com.emergentes.modelo.Cantidad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jhonny
 */
public class Consultas extends ConexionDB {

    Connection con = this.conectar();
    PreparedStatement ps;

    public void  Cantidad_Aula() {
        int resultado = 0;
        String sql = "SELECT * FROM aula";

        try {
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            Cantidad c= new Cantidad();
            if (rs.next()) {

                resultado += resultado;
                
            }
            c.setCantid_buscar(resultado);

        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }

        

    }

}
