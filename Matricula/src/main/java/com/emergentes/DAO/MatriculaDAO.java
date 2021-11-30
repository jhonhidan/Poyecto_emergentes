
package com.emergentes.DAO;

import com.emergentes.modelo.Matricula;
import java.util.List;

/**
 *
 * @author Jhonny
 */
public interface MatriculaDAO {
     public void insert(Matricula matricula) throws Exception;

    public void update(Matricula matricula) throws Exception;

    public void delete(int id_matricula) throws Exception;

    public Matricula getById(int id_matricula) throws Exception;

    public List<Matricula> getAll() throws Exception;
}
