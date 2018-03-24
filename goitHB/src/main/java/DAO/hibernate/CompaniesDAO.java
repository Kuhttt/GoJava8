package DAO.hibernate;

import DAO.entities.CompaniesEntity;
import DAO.EntityDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class CompaniesDAO implements EntityDAO<CompaniesEntity> {

    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public void create(CompaniesEntity company) {
        Transaction transaction = null;
        Session session = this.sessionFactory.openSession();
        try{
            transaction = session.beginTransaction();
            session.save(company);
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

    public List<CompaniesEntity> read() {
        List<CompaniesEntity> companies = new ArrayList<CompaniesEntity>();
        Transaction transaction = null;
        Session session = this.sessionFactory.openSession();
        try{
            transaction = session.beginTransaction();
            companies = (List<CompaniesEntity>) session.createQuery("FROM CompaniesEntity ").list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return companies;
    }

    public void update(CompaniesEntity company) {
        Transaction transaction = null;
        Session session = this.sessionFactory.openSession();
        try{
            transaction = session.beginTransaction();
            session.update(company);
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
            CompaniesEntity company = session.load(CompaniesEntity.class, new Integer(id));
            session.delete(company);
            transaction.commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }
}
