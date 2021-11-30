
package com.emergentes.utilitarios;

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
public class Vaidate extends ConexionDB{
    Connection con=this.conectar();
    PreparedStatement ps;
    
    
    
    public boolean checkUser(String email,String password)
    {
        boolean resultado = false;
        String sql="SELECT * FROM usuarios where usuario=? and password =sha1(?)";
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1,email);
            ps.setString(2,password);
            ResultSet rs=ps.executeQuery();
            resultado=rs.next();
            
        } catch (SQLException ex) {
            System.out.println("Erro al ingresar");
            Logger.getLogger(Vaidate.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        return resultado;
    }

   

}
