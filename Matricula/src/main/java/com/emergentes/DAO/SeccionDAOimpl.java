package com.emergentes.DAO;

import com.emergentes.modelo.Seccion;
import com.emergentes.utilitarios.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jhonny
 */
public class SeccionDAOimpl extends ConexionDB implements SeccionDAO {

    @Override
    public void insert(Seccion seccion) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO seccion(descripcion_sec,estado_sec,id_ano_lectivo)value(?,?,?)");
            ps.setString(1, seccion.getDescripcion_sec());
            ps.setString(2, seccion.getEstado_sec());
            ps.setInt(3, seccion.getId_ano_lectivo());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;

        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Seccion seccion) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE seccion SET descripcion_sec=?,estado_sec=?,id_ano_lectivo=? where id_seccion=?");
            
            ps.setString(1, seccion.getDescripcion_sec());
            ps.setString(2, seccion.getEstado_sec());
            ps.setInt(3, seccion.getId_ano_lectivo());
            ps.setInt(4, seccion.getId_seccion());

            ps.executeUpdate();
        } catch (Exception e) {
            throw e;

        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int id_seccion) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM seccion WHERE id_seccion=?");
            ps.setInt(1, id_seccion);

            ps.executeUpdate();
        } catch (Exception e) {
            throw e;

        } finally {
            this.desconectar();
        }
    }

    @Override
    public Seccion getById(int id_seccion) throws Exception {
        try {
            Seccion sec = new Seccion();
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM seccion WHERE id_seccion=?");
            ps.setInt(1, id_seccion);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                sec.setId_seccion(rs.getInt("id_seccion"));
                sec.setDescripcion_sec(rs.getString("descripcion_sec"));
                sec.setEstado_sec(rs.getString("estado_sec"));
                sec.setId_ano_lectivo(rs.getInt("id_ano_lectivo"));

            }
            return sec;
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public List<Seccion> getAll() throws Exception {
        List<Seccion> lista = null;

        try {

            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM año_lectivo A,seccion S where S.id_ano_lectivo=id_añolectivo and A.estado_año='activo'");
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<Seccion>();
            while (rs.next()) {
                Seccion sec = new Seccion();

                sec.setId_seccion(rs.getInt("id_seccion"));
                sec.setDescripcion_sec(rs.getString("descripcion_sec"));
                sec.setEstado_sec(rs.getString("estado_sec"));
                sec.setId_ano_lectivo(rs.getInt("id_ano_lectivo"));
                sec.setAno_sec(rs.getString("año"));
                
                lista.add(sec);
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
