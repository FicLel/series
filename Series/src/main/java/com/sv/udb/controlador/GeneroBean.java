/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controlador;

import com.sv.udb.ejb.GeneroFacadeLocal;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import com.sv.udb.modelo.Genero;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.primefaces.context.RequestContext;


/**
 *
 * @author fic
 */
@Named(value = "GeneroBean")
@ViewScoped
public class GeneroBean implements Serializable{

    /**
     * Creates a new instance of GeneroBean
     */
    @EJB
    private GeneroFacadeLocal FCDEGenero;    
    private Genero objeGenero;
    private List<Genero> listGenero;
    private boolean guardar;

    
   
    public Genero getObjeGenero() {
        return objeGenero;
    }

    public void setObjeGenero(Genero objeGenero) {
        this.objeGenero = objeGenero;
    }

    public boolean isGuardar() {
        return guardar;
    }

    public List<Genero> getListGenero() {
        return listGenero;
    }
    
    /**
     * Creates a new instance of GeneroBean
     */
    
    public GeneroBean() {
    }
    
    @PostConstruct
    public void init()
    {
        
        this.objeGenero = new Genero();
        this.guardar = true;
        
        this.consTodo();
    }
    
    public void limpForm()
    {
         
        this.objeGenero = new Genero();
        this.guardar = true;        
    }
    
    public void guar()
    {
        
        RequestContext ctx = RequestContext.getCurrentInstance(); //Capturo el contexto de la página
        try
        {
            FCDEGenero.create(this.objeGenero);
            this.listGenero.add(this.objeGenero);
            this.limpForm();
            ctx.execute("setMessage('MESS_SUCC', 'Atención', 'Datos guardados')");
            
        }
        catch(Exception ex)
        {
            ctx.execute("setMessage('MESS_ERRO', 'Atención', 'Error al guardar ')");
             
        }
        finally
        {
            
        }
    }
    
    public void modi()
    {
        RequestContext ctx = RequestContext.getCurrentInstance(); //Capturo el contexto de la página
        try
        {
            this.listGenero.remove(this.objeGenero); //Limpia el objeto viejo
            FCDEGenero.edit(this.objeGenero);
            this.listGenero.add(this.objeGenero); //Agrega el objeto modificado
            ctx.execute("setMessage('MESS_SUCC', 'Atención', 'Datos Modificados')");
            
        }
        catch(Exception ex)
        {
            ctx.execute("setMessage('MESS_ERRO', 'Atención', 'Error al modificar ')");
             
        }
        finally
        {
            
        }
    }
    
    public void elim()
    {
        RequestContext ctx = RequestContext.getCurrentInstance(); //Capturo el contexto de la página
        try
        {
            FCDEGenero.remove(this.objeGenero);
            this.listGenero.remove(this.objeGenero);
            this.limpForm();
            
            ctx.execute("setMessage('MESS_SUCC', 'Atención', 'Datos Eliminados')");
            
            
        }
        catch(Exception ex)
        {
            ctx.execute("setMessage('MESS_ERRO', 'Atención', 'Error al eliminar')");
             
        }
        finally
        {
            
        }
    }
    
    public void consTodo()
    {
        
        try
        {
            this.listGenero = FCDEGenero.findAll();
            
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
             
        }
        finally
        {
            
        }
    }
    
    public void cons()
    {
       
        RequestContext ctx = RequestContext.getCurrentInstance(); //Capturo el contexto de la página
        int codi = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id_gene"));
        try
        {
            this.objeGenero = FCDEGenero.find(codi);
            this.guardar = false;
            
            ctx.execute("setMessage('MESS_SUCC', 'Atención', 'Consultado a " + 
                    String.format("%s %s", this.objeGenero.getNombre()) + "')");
            
        }
        catch(Exception ex)
        {
            ctx.execute("setMessage('MESS_ERRO', 'Atención', 'Error al consultar')");
             
        }
        finally
        {
            
        }
    }
    
}
