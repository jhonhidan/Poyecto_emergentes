
package com.emergentes.DAO;

import com.emergentes.modelo.Rol;
import java.util.List;

/**
 *
 * @author Jhonny
 */
public interface RolDAO {
      public void insert(Rol rol) throws Exception;

    public void update(Rol rol) throws Exception;

    public void delete(int id_rol) throws Exception;

    public Rol getById(int id_rol) throws Exception;

    public List<Rol> getAll() throws Exception;
}
