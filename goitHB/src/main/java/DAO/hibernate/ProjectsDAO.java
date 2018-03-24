package DAO.hibernate;

import DAO.EntityDAO;
import DAO.entities.ProjectsEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class ProjectsDAO implements EntityDAO<ProjectsEntity> {

    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public void create(ProjectsEntity project) {
        Transaction transaction = null;
        Session session = this.sessionFactory.openSession();
        try{
            transaction = session.beginTransaction();
            session.save(project);
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

    public List<ProjectsEntity> read() {
        List<ProjectsEntity> projects = new ArrayList<ProjectsEntity>();
        Transaction transaction = null;
        Session session = this.sessionFactory.openSession();
        try{
            transaction = session.beginTransaction();
            projects = session.createQuery("FROM ProjectsEntity").list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return projects;
    }

    public void update(ProjectsEntity project) {
        Transaction transaction = null;
        Session session = this.sessionFactory.openSession();
        try{
            transaction = session.beginTransaction();
            session.update(project);
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
            ProjectsEntity project = session.load(ProjectsEntity.class, new Integer(id));
            session.delete(project);
            transaction.commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }
}
