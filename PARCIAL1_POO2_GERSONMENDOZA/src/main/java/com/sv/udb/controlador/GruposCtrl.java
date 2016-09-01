/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controlador;

import com.sv.udb.modelo.Alumnos;
import com.sv.udb.modelo.Grupos;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author gersonfrancisco
 */
public class GruposCtrl {
    
     public List<Grupos> consTodo()
    {
        List<Grupos> resp = new ArrayList<>();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("POOPU1");
        EntityManager em = emf.createEntityManager();
        try
        {
          TypedQuery<Grupos> query =em.createNamedQuery("Grupos.findAll", Grupos.class);
           resp = query.getResultList();
        }
        catch(Exception ex)
        {
            
        }
        em.close();
        emf.close();
        return resp;
       
    }
     
    public Grupos get(int empId)
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("POOPU1");
        EntityManager em = emf.createEntityManager();
        Grupos resp = null;
        
        try{
            resp = em.find(Grupos.class, empId);
            
        }catch(Exception e){
            e.printStackTrace();
        }
        em.close();
        emf.close();
        return resp;
    }
}
