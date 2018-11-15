/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.Transaction;

/**
 *
 * @author jonat
 */
public class MantenedorProfesores {
     public ArrayList<TProfesor> getProfesores()
    {
        SessionFactory sesion2=NewHibernateUtil.getSessionFactory();
        Session session2 =sesion2.openSession();
        Transaction ts=session2.beginTransaction();
        
                ArrayList<TProfesor> cool=new ArrayList<TProfesor>();
                Query q=session2.createQuery("from TProfesor");
                List<TProfesor> lista=q.list();
                Iterator<TProfesor> iter=lista.iterator();
   
        ts.commit();
        session2.close();
       
        while(iter.hasNext())
        {
            TProfesor col = (TProfesor) iter.next();
            cool.add(col);
        }
        
        return cool;
    }
     
     
       public void agregarProfesor(TProfesor profesor)
    {
        SessionFactory sesion=NewHibernateUtil.getSessionFactory();
        Session session =sesion.openSession();
        Transaction ts=session.beginTransaction();
        
        session.save(profesor);
        ts.commit();
        session.close();

    }
          public void eliminarProfesor(int id)
    {
        SessionFactory sesion=NewHibernateUtil.getSessionFactory();
        Session session =sesion.openSession();
        Transaction ts=session.beginTransaction();
        TProfesor profesor=(TProfesor)session.get(TProfesor.class,id);
        session.delete(profesor);
        ts.commit();
        session.close();

    }
    
}
