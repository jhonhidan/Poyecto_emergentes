package com.emergentes.DAO;

import com.emergentes.modelo.Usuarios;
import java.util.List;

/**
 *
 * @author Jhonny
 */
public interface UsuarioDAO {

    public void insert(Usuarios usuario) throws Exception;

    public void update(Usuarios usuario) throws Exception;

    public void delete(int id_usuario) throws Exception;

    public Usuarios getById(int id_usuario) throws Exception;

    public List<Usuarios> getAll() throws Exception;
}
