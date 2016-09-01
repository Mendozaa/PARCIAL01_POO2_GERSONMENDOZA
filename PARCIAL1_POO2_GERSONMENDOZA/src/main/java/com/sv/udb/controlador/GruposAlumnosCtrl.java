/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controlador;

import com.sv.udb.modelo.Alumnos;
import com.sv.udb.modelo.GruposAlumnos;
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
public class GruposAlumnosCtrl {
    public boolean guar(GruposAlumnos obje)
    {
        boolean resp = false;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("POOPU1");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try
        {
            em.persist(obje);
            tx.commit();
            resp = true;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            tx.rollback();
        }
        return resp;
    }
    
     public List<GruposAlumnos> ConsTodo(Object Codi)
    {
        if(Codi == null){
            Codi = 1;
        }
        List<GruposAlumnos> resp = new ArrayList<>();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("POOPU1");
        EntityManager em = emf.createEntityManager();
        try
        {
            TypedQuery<GruposAlumnos> query =em.createNamedQuery("GruposAlumnos.findByCodiGrup", GruposAlumnos.class);
            query.setParameter("codiGrup",Codi);
           resp = query.getResultList();
        }
        catch(Exception ex)
        {
            
        }
        em.close();
        emf.close();
        return resp;
       
    }
     
    public GruposAlumnos get(Long empId)
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("POOPU1");
        EntityManager em = emf.createEntityManager();
       GruposAlumnos resp = null;
        
        try{
            resp = em.find(GruposAlumnos.class, empId);
            
        }catch(Exception e){
            e.printStackTrace();
        }
        em.close();
        emf.close();
        return resp;
    }
}
