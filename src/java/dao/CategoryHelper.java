/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dvdrental.HibernateUtil;
import model.Category;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author NCCallegari
 */
// Criação de uma classe chamada CategoryHelper
public class CategoryHelper {

    Session session = null; //Se a sessão não estiver aberta

    public CategoryHelper() {
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

    public List getCategory() {
        openSession();
        List<Category> categoryList = null;
        org.hibernate.Transaction tx = session.beginTransaction();
        try {
            Query q = session.createQuery("from Category");
            categoryList = (List<Category>) q.list();
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            closeSession();
        }
        return categoryList;
    }

    public void inserir(Category category) {
        openSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        try {
            session.save(category);
            tx.commit();

        } catch (RuntimeException ex) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            closeSession();

        }
    }

    
    public void excluir(Category category) {
        openSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        try {
            session.delete(category);
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

    
    public void atualizar(Category category) {
        openSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        try {
            session.update(category);
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

        public Category getCategoryByID(int categoryId) {
        openSession();
        List<Category> categoryList = null;
        org.hibernate.Transaction tx = session.beginTransaction();
        try {
            Query q = session.createQuery("from Category as category where category.categoryId=" + categoryId);
            categoryList = (List<Category>) q.list();
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            closeSession();
        }

        return categoryList.get(0);
    }
    
}


    

