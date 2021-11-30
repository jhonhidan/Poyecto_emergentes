
package com.emergentes.DAO;

import com.emergentes.modelo.Rol;
import com.emergentes.utilitarios.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jhonny
 */
public class RolDAOimpl extends ConexionDB implements RolDAO{

    @Override
    public void insert(Rol rol) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO rol(descripcion_rol)value(?)");
            
            ps.setString(1, rol.getDescripcion_rol());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;

        } finally {
            this.desconectar();
        }
    
    }

    @Override
    public void update(Rol rol) throws Exception {
     
          try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE rol SET descripcion_rol=? where id_rol=?");
           
            ps.setString(1, rol.getDescripcion_rol());
             ps.setInt(2,rol.getId_rol() );
           

            ps.executeUpdate();
        } catch (Exception e) {
            throw e;

        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int id_rol) throws Exception {
     try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM rol WHERE id_rol=?");
            ps.setInt(1, id_rol);

            ps.executeUpdate();
        } catch (Exception e) {
            throw e;

        } finally {
            this.desconectar();
        }
        
    }

    @Override
    public Rol getById(int id_rol) throws Exception {
    try {
            Rol ro = new Rol();
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM rol WHERE id_rol=?");
            ps.setInt(1, id_rol);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ro.setId_rol(rs.getInt("id_rol"));
                ro.setDescripcion_rol(rs.getString("descripcion_rol"));
            }
            return ro;
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        
        
    }

    @Override
    public List<Rol> getAll() throws Exception {
    
             List<Rol> lista = null;

        try {

            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM rol");
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<Rol>();
            while (rs.next()) {
                Rol ro = new Rol();
                 ro.setId_rol(rs.getInt("id_rol"));
                ro.setDescripcion_rol(rs.getString("descripcion_rol"));

                lista.add(ro);
            }

            rs.close();
            ps.close();

        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return lista;
    }

    
    
}
