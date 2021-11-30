
package com.emergentes.DAO;

import com.emergentes.modelo.Seccion;
import java.util.List;

/**
 *
 * @author Jhonny
 */
public interface SeccionDAO {

    public void insert(Seccion seccion) throws Exception;

    public void update(Seccion seccion) throws Exception;

    public void delete(int id_seccion) throws Exception;

    public Seccion getById(int id_seccion) throws Exception;

    public List<Seccion> getAll() throws Exception;
}
