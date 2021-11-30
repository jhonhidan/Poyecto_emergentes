
package com.emergentes.DAO;

import com.emergentes.modelo.Estudiante;
import java.util.List;

/**
 *
 * @author Jhonny
 */
public interface EstudianteDAO {
     public void insert(Estudiante estudiante) throws Exception;

    public void update(Estudiante estudiante) throws Exception;

    public void delete(int id_estudiante) throws Exception;

    public Estudiante getById(int id_estudiante) throws Exception;

    public List<Estudiante> getAll() throws Exception;
}
