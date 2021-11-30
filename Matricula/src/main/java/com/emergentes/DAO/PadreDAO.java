/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.emergentes.DAO;

import com.emergentes.modelo.Padre;
import java.util.List;

/**
 *
 * @author Jhonny
 */
public interface PadreDAO {

    public void insert(Padre padre) throws Exception;

    public void update(Padre padre) throws Exception;

    public void delete(int id_padre) throws Exception;

    public Padre getById(int id_padre) throws Exception;

    public List<Padre> getAll() throws Exception;
}
