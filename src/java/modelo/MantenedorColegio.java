/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import static javassist.CtMethod.ConstParameter.string;
import javax.swing.DefaultListModel;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author jonat
 */
public class MantenedorColegio {
    public ArrayList<TColegio> getColegio()
    {
        SessionFactory sesion=NewHibernateUtil.getSessionFactory();
        Session session =sesion.openSession();
        Transaction ts=session.beginTransaction();
        
                ArrayList<TColegio> cool=new ArrayList<TColegio>();
                Query q=session.createQuery("from TColegio");
                List<TColegio> lista=q.list();
                Iterator<TColegio> iter=lista.iterator();
   
        ts.commit();
        session.close();
       
        while(iter.hasNext())
        {
            TColegio col = (TColegio) iter.next();
            cool.add(col);
        }
        
        return cool;
    }
    
    public void agregarColegio(TColegio colegio)
    {
        SessionFactory sesion=NewHibernateUtil.getSessionFactory();
        Session session =sesion.openSession();
        Transaction ts=session.beginTransaction();
        
        session.save(colegio);
        ts.commit();
        session.close();

    }
    public void eliminarColegio(int id)
    {
        SessionFactory sesion=NewHibernateUtil.getSessionFactory();
        Session session =sesion.openSession();
        Transaction ts=session.beginTransaction();
        TColegio colegio=(TColegio)session.get(TColegio.class,id);
        session.delete(colegio);
        ts.commit();
        session.close();

    }
    
       public void editarColegio(TColegio colegio)
    {
        SessionFactory sesion=NewHibernateUtil.getSessionFactory();
        Session session =sesion.openSession();
        Transaction ts=session.beginTransaction();
        
        session.saveOrUpdate(colegio);
        ts.commit();
        session.close();

    }
    
}
