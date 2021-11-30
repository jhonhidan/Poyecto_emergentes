
package com.emergentes.DAO;

import com.emergentes.modelo.Aula;
import com.emergentes.modelo.Cantidad;
import java.util.List;

/**
 *
 * @author Jhonny
 */
public interface AulaDAO {
    public void insert(Aula aula) throws Exception;

    public void update(Aula Aula) throws Exception;

    public void delete(int id_aula) throws Exception;

    public Aula getById(int id_aula) throws Exception;

    public List<Aula> getAll() throws Exception;
     public List<Cantidad> getAll_cant() throws Exception;
}
