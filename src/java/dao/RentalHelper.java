/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dvdrental.HibernateUtil;
import java.util.List;
import model.Rental;
import org.hibernate.Query;
import org.hibernate.Session;


public class RentalHelper {

    Session session = null; //Se a sessão não estiver aberta

    public RentalHelper() {
        openSession();
    }

    private void openSession() {
        if (session == null || !session.isOpen()) {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        }
    }

    private void closeSession() {
        if (session.isOpen()) {
            session.close();
        }
    }

    public List getrental() {
        openSession();
        List<Rental> rentalList = null;
        org.hibernate.Transaction tx = session.beginTransaction();
        try {
            Query q = session.createQuery("from Rental");
            rentalList = (List<Rental>) q.list();
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            closeSession();
        }
        return rentalList;
    }

    public void inserir(Rental rental) {
        openSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        try {
            session.save(rental);
            tx.commit();

        } catch (RuntimeException ex) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            closeSession();

        }
    }

    
    public void excluir(Rental rental) {
        openSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        try {
            session.delete(rental);
            tx.commit();

        } catch (RuntimeException ex) {
            if (tx != null) {
                tx.rollback();

            }
            throw ex;
        } finally {
            closeSession();

        }
    }

    
    public void atualizar(Rental rental) {
        openSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        try {
            session.update(rental);
            tx.commit();

        } catch (RuntimeException ex) {
            if (tx != null) {
                tx.rollback();

            }
            throw ex;
        } finally {
            closeSession();

        }
    }

        public Rental getRentalByID(int rentalId) {
        openSession();
        List<Rental> rentalList = null;
        org.hibernate.Transaction tx = session.beginTransaction();
        try {
            Query q = session.createQuery("from Category as category where category.categoryId=" + rentalId);
            rentalList = (List<Rental>) q.list();
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            closeSession();
        }

        return rentalList.get(0);
    }

    public List getRental() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}


    

