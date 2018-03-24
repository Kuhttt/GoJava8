package DAO.hibernate;

import DAO.entities.DevelopersEntity;
import DAO.EntityDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class DeveloperDAO implements EntityDAO<DevelopersEntity> {

    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public void create(DevelopersEntity developer) {
        Transaction transaction = null;
        Session session = this.sessionFactory.openSession();
        try{
            transaction = session.beginTransaction();
            session.save(developer);
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

    public List<DevelopersEntity> read() {
        List<DevelopersEntity> developers = new ArrayList<DevelopersEntity>();
        Transaction transaction = null;
        Session session = this.sessionFactory.openSession();
        try{
            transaction = session.beginTransaction();
            developers = session.createQuery("FROM DevelopersEntity").list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return developers;
    }

    public void update(DevelopersEntity developer) {
        Transaction transaction = null;
        Session session = this.sessionFactory.openSession();
        try{
            transaction = session.beginTransaction();
            session.update(developer);
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
            DevelopersEntity developer = session.load(DevelopersEntity.class, new Integer(id));
            session.delete(developer);
            transaction.commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }
}
