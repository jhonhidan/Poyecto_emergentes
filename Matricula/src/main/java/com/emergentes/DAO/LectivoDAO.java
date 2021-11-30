
package com.emergentes.DAO;

import com.emergentes.modelo.Lectivo;
import java.util.List;

/**
 *
 * @author Jhonny
 */
public interface LectivoDAO {
     public void insert(Lectivo lectivo) throws Exception;

    public void update(Lectivo lectivo) throws Exception;

    public void delete(int id_añoelectivo) throws Exception;

    public Lectivo getById(int id_añoelectivo) throws Exception;

    public List<Lectivo> getAll() throws Exception;
    
}
