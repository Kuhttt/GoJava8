package DAO.entities;

import javax.persistence.*;

@Entity
@Table(name = "customers_projects", schema = "initdb")
public class CustomersProjectsEntity {
    private int idcustomersProjects;
    private CustomersEntity customersByIdCustomers;

    @Id
    @Column(name = "idcustomers_projects", nullable = false)
    public int getIdcustomersProjects() {
        return idcustomersProjects;
    }

    public void setIdcustomersProjects(int idcustomersProjects) {
        this.idcustomersProjects = idcustomersProjects;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomersProjectsEntity that = (CustomersProjectsEntity) o;

        if (idcustomersProjects != that.idcustomersProjects) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return idcustomersProjects;
    }

    @ManyToOne
    @JoinColumn(name = "idCustomers", referencedColumnName = "idCustomers", nullable = false)
    public CustomersEntity getCustomersByIdCustomers() {
        return customersByIdCustomers;
    }

    public void setCustomersByIdCustomers(CustomersEntity customersByIdCustomers) {
        this.customersByIdCustomers = customersByIdCustomers;
    }
}
