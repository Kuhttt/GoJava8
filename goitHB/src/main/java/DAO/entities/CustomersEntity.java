package DAO.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "customers", schema = "initdb")
public class CustomersEntity {
    private int idCustomers;
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCustomers", nullable = false)
    public int getIdCustomers() {
        return idCustomers;
    }

    public void setIdCustomers(int idCustomers) {
        this.idCustomers = idCustomers;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return name;
    }

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "customers_projects",
            joinColumns = {@JoinColumn(name = "idCustomers")},
            inverseJoinColumns = {@JoinColumn(name = "idProjects")}
    )
    Set<ProjectsEntity> projects_cust = new HashSet<ProjectsEntity>();

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomersEntity that = (CustomersEntity) o;

        if (idCustomers != that.idCustomers) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCustomers;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
