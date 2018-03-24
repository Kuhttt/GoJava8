package DAO.hibernate;

import DAO.EntityDAO;
import DAO.entities.SkillsEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class SkillsDAO implements EntityDAO<SkillsEntity>{

    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public void create(SkillsEntity skill) {
        Transaction transaction = null;
        Session session = this.sessionFactory.openSession();
        try{
            transaction = session.beginTransaction();
            session.save(skill);
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

    public List<SkillsEntity> read() {
        List<SkillsEntity> skills = new ArrayList<SkillsEntity>();
        Transaction transaction = null;
        Session session = this.sessionFactory.openSession();
        try{
            transaction = session.beginTransaction();
            skills = session.createQuery("FROM SkillsEntity").list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return skills;
    }

    public void update(SkillsEntity skill) {
        Transaction transaction = null;
        Session session = this.sessionFactory.openSession();
        try{
            transaction = session.beginTransaction();
            session.update(skill);
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
            SkillsEntity skill = session.load(SkillsEntity.class, new Integer(id));
            session.delete(skill);
            transaction.commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }
}
