/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.ejb;

import com.sv.udb.modelo.Genero;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author fic
 */
@Local
public interface GeneroFacadeLocal {

    void create(Genero genero);

    void edit(Genero genero);

    void remove(Genero genero);

    Genero find(Object id);

    List<Genero> findAll();

    List<Genero> findRange(int[] range);

    int count();
    
}
