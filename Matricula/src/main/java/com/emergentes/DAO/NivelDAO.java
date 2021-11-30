
package com.emergentes.DAO;

import com.emergentes.modelo.Nivel;
import java.util.List;

/**
 *
 * @author Jhonny
 */
public interface NivelDAO {
     public void insert(Nivel nivel) throws Exception;

    public void update(Nivel nivel) throws Exception;

    public void delete(int id_nivel) throws Exception;

    public Nivel getById(int id_nivel) throws Exception;

    public List<Nivel> getAll() throws Exception;
}
