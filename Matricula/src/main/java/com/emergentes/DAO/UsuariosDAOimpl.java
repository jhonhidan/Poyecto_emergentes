package com.emergentes.DAO;

import com.emergentes.modelo.Usuarios;
import com.emergentes.utilitarios.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jhonny
 */
public class UsuariosDAOimpl extends ConexionDB implements UsuarioDAO {

    @Override
    public void insert(Usuarios usuario) throws Exception {

        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO usuarios(id_rol_usu,usuario,password,estado_usu,id_estudiante_usu)value(?,?,sha1(?),?,?)");
            ps.setInt(1, usuario.getId_rol_usu());
            ps.setString(2, usuario.getUsuario());
            ps.setString(3, usuario.getPassword());
            ps.setString(4, usuario.getEstado_usu());
            ps.setInt(5, usuario.getId_estudiante_usu());
            

            ps.executeUpdate();
        } catch (Exception e) {
            throw e;

        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Usuarios usuario) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE usuarios SET id_rol_usu=?,usuario=?,password=?,estado_usu=?,id_estudiante_usu=? where id_usuario=?");
         
            ps.setInt(1, usuario.getId_rol_usu());
            ps.setString(2, usuario.getUsuario());
            ps.setString(3, usuario.getPassword());
            ps.setString(4, usuario.getEstado_usu());
            ps.setInt(5, usuario.getId_estudiante_usu());
            ps.setInt(6, usuario.getId_usuario());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;

        } finally {
            this.desconectar();
        }

    }

    @Override
    public void delete(int id_usuario) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM usuarios WHERE id_usuario=?");
            ps.setInt(1, id_usuario);

            ps.executeUpdate();
        } catch (Exception e) {
            throw e;

        } finally {
            this.desconectar();
        }
    }

    @Override
    public Usuarios getById(int id_usuario) throws Exception {
        try {
            Usuarios usu = new Usuarios();
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM usuarios WHERE id_usuario=?");
            ps.setInt(1, id_usuario);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                usu.setId_usuario(rs.getInt("id_usuario"));
                usu.setId_rol_usu(rs.getInt("id_rol_usu"));
                usu.setUsuario(rs.getString("usuario"));
                usu.setPassword(rs.getString("password"));
                usu.setEstado_usu(rs.getString("estado_usu"));
                usu.setId_estudiante_usu(rs.getInt("id_estudiante_usu"));
                

            }
            return usu;
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public List<Usuarios> getAll() throws Exception {
        List<Usuarios> lista = null;

        try {

            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM rol R,usuarios U,estudiante E where U.id_rol_usu=R.id_rol and U.id_estudiante_usu=E.id_estudiante");
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<Usuarios>();
            while (rs.next()) {
                Usuarios usu = new Usuarios();

                usu.setId_usuario(rs.getInt("id_usuario"));
                usu.setId_rol_usu(rs.getInt("id_rol_usu"));
                usu.setUsuario(rs.getString("usuario"));
                usu.setPassword(rs.getString("password"));
                usu.setEstado_usu(rs.getString("estado_usu"));
                usu.setId_estudiante_usu(rs.getInt("id_estudiante_usu"));
                usu.setDescripcion_rol(rs.getString("descripcion_rol"));
                usu.setNombre_es_usu(rs.getString("Nombre_es"));
                usu.setApellido_es_usu(rs.getString("apellidos"));
                lista.add(usu);
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
