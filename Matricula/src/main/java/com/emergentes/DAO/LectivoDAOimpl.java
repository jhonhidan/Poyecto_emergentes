package com.emergentes.DAO;

import com.emergentes.modelo.Lectivo;
import com.emergentes.utilitarios.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Jhonny
 */
public class LectivoDAOimpl extends ConexionDB implements LectivoDAO {

    @Override
    public void insert(Lectivo lectivo) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO año_lectivo(año_inicio,año_fin,estado_año,año)value(?,?,?,?)");
            ps.setString(1,lectivo.getAño_inicio());
            ps.setString(2, lectivo.getAño_fin());
            ps.setString(3, lectivo.getEstado_año());
            ps.setString(4, lectivo.getAño());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;

        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Lectivo lectivo) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE año_lectivo SET año_inicio=?,año_fin=?,estado_año=?,año=? where id_añolectivo=?");

            ps.setString(1, lectivo.getAño_inicio());
            ps.setString(2,  lectivo.getAño_fin());
            ps.setString(3, lectivo.getEstado_año());
            ps.setString(4, lectivo.getAño());
            ps.setInt(5, lectivo.getId_añolectivo());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;

        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int id_añolectivo) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM año_lectivo WHERE id_añolectivo=?");
            ps.setInt(1, id_añolectivo);

            ps.executeUpdate();
        } catch (Exception e) {
            throw e;

        } finally {
            this.desconectar();
        }
    }

    @Override
    public Lectivo getById(int id_añolectivo) throws Exception {
        try {
            Lectivo lec = new Lectivo();
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM año_lectivo WHERE id_añolectivo=?");
            ps.setInt(1, id_añolectivo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                lec.setId_añolectivo(rs.getInt("id_añolectivo"));
                lec.setAño_inicio(rs.getString("año_inicio"));
                lec.setAño_fin(rs.getString("año_fin"));
                lec.setEstado_año(rs.getString("estado_año"));
                lec.setAño(rs.getString("año"));
            }
            return lec;
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public List<Lectivo> getAll() throws Exception {
        List<Lectivo> lista = null;

        try {

            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM año_lectivo");
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<Lectivo>();
            while (rs.next()) {
                Lectivo lec = new Lectivo();
                lec.setId_añolectivo(rs.getInt("id_añolectivo"));
                lec.setAño_inicio(rs.getString("año_inicio"));
                lec.setAño_fin(rs.getString("año_fin"));
                lec.setEstado_año(rs.getString("estado_año"));
                lec.setAño(rs.getString("año"));
                System.out.println(rs.getString("año"));
                System.out.println(rs.getString("año_inicio"));
                System.out.println(rs.getString("estado_año"));
                System.out.println(rs.getString("año_fin"));
                System.out.println(rs.getString("año"));
                System.out.println(rs.getString("id_añolectivo"));
                lista.add(lec);
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
