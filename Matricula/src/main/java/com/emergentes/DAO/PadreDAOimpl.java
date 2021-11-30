package com.emergentes.DAO;

import com.emergentes.modelo.Padre;
import com.emergentes.utilitarios.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jhonny
 */
public class PadreDAOimpl extends ConexionDB implements PadreDAO {

    @Override
    public void insert(Padre padre) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO padre(nombre,telefono,direccion)value(?,?,?)");
            ps.setString(1, padre.getNombre());
            ps.setString(2, padre.getTelefono());
            ps.setString(3, padre.getDirecion());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;

        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Padre padre) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE padre SET nombre=?,telefono=?,direccion=? where id_padre=?");

            ps.setString(1, padre.getNombre());
            ps.setString(2, padre.getTelefono());
            ps.setString(3, padre.getDirecion());
            ps.setInt(4, padre.getId_padre());

            ps.executeUpdate();
        } catch (Exception e) {
            throw e;

        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int id_padre) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM padre WHERE id_padre=?");
            ps.setInt(1, id_padre);

            ps.executeUpdate();
        } catch (Exception e) {
            throw e;

        } finally {
            this.desconectar();
        }
    }

    @Override
    public Padre getById(int id_padre) throws Exception {
        try {
            Padre pad = new Padre();
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM padre WHERE id_padre=?");
            ps.setInt(1, id_padre);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                pad.setId_padre(rs.getInt("id_padre"));
                pad.setNombre(rs.getString("nombre"));
                pad.setTelefono(rs.getString("telefono"));
                pad.setDirecion(rs.getString("direccion"));

            }
            return pad;
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }

    }

    @Override
    public List<Padre> getAll() throws Exception {
        List<Padre> lista = null;

        try {

            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM padre");
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<Padre>();
            while (rs.next()) {
                Padre pad = new Padre();
                pad.setId_padre(rs.getInt("id_padre"));
                pad.setNombre(rs.getString("nombre"));
                pad.setTelefono(rs.getString("telefono"));
                pad.setDirecion(rs.getString("direccion"));
                lista.add(pad);
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
