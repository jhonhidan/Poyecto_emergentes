package com.emergentes.DAO;

import com.emergentes.modelo.Nivel;
import com.emergentes.utilitarios.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jhonny
 */
public class NivelDAOimpl extends ConexionDB implements NivelDAO {

    @Override
    public void insert(Nivel nivel) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO nivel(descripcion_niv,fecha,estado_niv,id_seccion,id_ula)value(?,?,?,?,?)");
           
             ps.setString(1, nivel.getDescripcion_niv());
            ps.setString(2, nivel.getFecha_nive());
            ps.setString(3, nivel.getEstado_niv());
            ps.setInt(4, nivel.getId_seccion_niv());
            ps.setInt(5, nivel.getId_aula_niv());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;

        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Nivel nivel) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE nivel SET descripcion_niv=?,fecha=?,estado_niv=?,id_seccion=?,id_ula=? where Id_nivel=?");

            ps.setString(1, nivel.getDescripcion_niv());
            ps.setString(2, nivel.getFecha_nive());
            ps.setString(3, nivel.getEstado_niv());
            ps.setInt(4, nivel.getId_seccion_niv());
            ps.setInt(5, nivel.getId_aula_niv());
            ps.setInt(6, nivel.getId_nivel());

            ps.executeUpdate();
        } catch (Exception e) {
            throw e;

        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int id_nivel) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM nivel WHERE Id_nivel=?");
            ps.setInt(1, id_nivel);

            ps.executeUpdate();
        } catch (Exception e) {
            throw e;

        } finally {
            this.desconectar();
        }
    }

    @Override
    public Nivel getById(int id_nivel) throws Exception {
        try {
            Nivel niv = new Nivel();
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM nivel WHERE Id_nivel=?");
            ps.setInt(1, id_nivel);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                niv.setDescripcion_niv(rs.getString("descripcion_niv"));
                niv.setFecha_nive(rs.getString("fecha"));
                niv.setEstado_niv(rs.getString("estado_niv"));
                niv.setId_seccion_niv(rs.getInt("id_seccion"));
                niv.setId_aula_niv(rs.getInt("id_ula"));
                niv.setId_nivel(rs.getInt("Id_nivel"));

            }
            return niv;
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public List<Nivel> getAll() throws Exception {
        List<Nivel> lista = null;

        try {

            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM nivel N,seccion S, aula A WHERE N.id_seccion=S.id_seccion and N.id_ula=A.id_aula and A.estado_aula='activo' and S.estado_sec='activo' and N.estado_niv='activo'");
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<Nivel>();
            while (rs.next()) {
                Nivel niv = new Nivel();
                niv.setDescripcion_niv(rs.getString("descripcion_niv"));
                niv.setFecha_nive(rs.getString("fecha"));
                niv.setEstado_niv(rs.getString("estado_niv"));
                niv.setId_seccion_niv(rs.getInt("id_seccion"));
                niv.setId_aula_niv(rs.getInt("id_ula"));
                niv.setId_nivel(rs.getInt("Id_nivel"));
                //mostrando datos de tabla aula y seccion
                niv.setDescripcion_aula(rs.getString("descripcion_aula"));
                niv.setDescripcion_sec(rs.getString("descripcion_sec"));
                lista.add(niv);
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
