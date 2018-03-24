package DAO.hibernate;

import DAO.entities.CustomersEntity;
import DAO.EntityDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class CustomersDAO implements EntityDAO<CustomersEntity> {

    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public void create(CustomersEntity customer) {
        Transaction transaction = null;
        Session session = this.sessionFactory.openSession();
        try{
            transaction = session.beginTransaction();
            session.save(customer);
            transaction.commit();
        } catch (RuntimeException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }

    public List<CustomersEntity> read() {
        List<CustomersEntity> customers = new ArrayList<CustomersEntity>();
        Transaction transaction = null;
        Session session = this.sessionFactory.openSession();
        try{
            transaction = session.beginTransaction();
            customers = session.createQuery("FROM CustomersEntity ").list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return customers;
    }

    public void update(CustomersEntity customer) {
        Transaction transaction = null;
        Session session = this.sessionFactory.openSession();
        try{
            transaction = session.beginTransaction();
            session.update(customer);
            transaction.commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }

    public void delete(int id) {
        Transaction transaction = null;
        Session session = this.sessionFactory.openSession();
        try{
            transaction = session.beginTransaction();
            CustomersEntity customer = session.load(CustomersEntity.class, new Integer(id));
            session.delete(customer);
            transaction.commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }
}
