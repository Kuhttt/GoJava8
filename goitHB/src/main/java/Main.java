import DAO.EntityDAO;
import DAO.entities.CompaniesEntity;
import DAO.hibernate.CompaniesDAO;
import org.hibernate.HibernateException;
import org.hibernate.Metamodel;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.metamodel.EntityType;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        CompaniesDAO companiesDAO = new CompaniesDAO();

        CompaniesEntity company = new CompaniesEntity();
        company.setName("Toshiba");

        companiesDAO.create(company);
        List<CompaniesEntity> companies = companiesDAO.read();

        for (CompaniesEntity companiesEntity : companies) {
            System.out.println(companiesEntity);
        }

        System.out.println("===============");

        company.setName("Toyota");
        companiesDAO.update(company);

        List<CompaniesEntity> companiesUpdated = companiesDAO.read();

        for (CompaniesEntity companiesEntity : companiesUpdated) {
            System.out.println(companiesEntity);
        }

        System.out.println("===============");

        companiesDAO.delete(company.getIdCompanies());

        List<CompaniesEntity> companiesAfterDelete = companiesDAO.read();

        for (CompaniesEntity companiesEntity : companiesAfterDelete) {
            System.out.println(companiesEntity);
        }


    }
}