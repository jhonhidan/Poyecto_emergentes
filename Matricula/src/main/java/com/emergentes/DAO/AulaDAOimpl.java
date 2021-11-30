package com.emergentes.DAO;

import com.emergentes.modelo.Aula;
import com.emergentes.modelo.Cantidad;
import com.emergentes.utilitarios.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jhonny
 */
public class AulaDAOimpl extends ConexionDB implements AulaDAO {

    @Override
    public void insert(Aula aula) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO aula(descripcion_aula,estado_aula)value(?,?)");

            ps.setString(1, aula.getDescripcion_aula());
            ps.setString(2, aula.getEstado_aula());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;

        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Aula aula) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE aula SET descripcion_aula=?,estado_aula=? where Id_aula=?");
           
            ps.setString(1, aula.getDescripcion_aula());
            ps.setString(2, aula.getEstado_aula());
             ps.setInt(3, aula.getId_aula());

            ps.executeUpdate();
        } catch (Exception e) {
            throw e;

        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int id_aula) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM aula WHERE Id_aula=?");
            ps.setInt(1, id_aula);

            ps.executeUpdate();
        } catch (Exception e) {
            throw e;

        } finally {
            this.desconectar();
        }
    }

    @Override
    public Aula getById(int id_aula) throws Exception {
        try {
            
            Aula au = new Aula();
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM aula WHERE Id_aula=?");
            ps.setInt(1, id_aula);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                 au.setId_aula(rs.getInt("Id_aula"));
                 
                au.setDescripcion_aula(rs.getString("descripcion_aula"));
                au.setEstado_aula(rs.getString("estado_aula"));

            }
            return au;
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public List<Aula> getAll() throws Exception {
        List<Aula> lista = null;
        int cantidad=0;
        

        try {

            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM aula");
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<Aula>();
            while (rs.next()) {
                cantidad+=1;
                Aula au = new Aula();
                au.setId_aula(rs.getInt("Id_aula"));
                au.setDescripcion_aula(rs.getString("descripcion_aula"));
                au.setEstado_aula(rs.getString("estado_aula"));
                
                System.out.println(rs.getString("estado_aula"));
                System.out.println("total"+cantidad);
                
                lista.add(au);
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

    @Override
    public List<Cantidad> getAll_cant() throws Exception {
       List<Cantidad> total = null;
        int cantidad=0;
        

        try {

            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM aula");
            ResultSet rs = ps.executeQuery();
            total = new ArrayList<Cantidad>();
            Cantidad c= new Cantidad();
            while (rs.next()) {
                cantidad+=1;
 
            }
              c.setCantid_buscar(cantidad);
              System.out.println(cantidad);
              total.add(c);
               System.out.println("total"+cantidad);
            

            rs.close();
            ps.close();

        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return total;
    }
    

}
