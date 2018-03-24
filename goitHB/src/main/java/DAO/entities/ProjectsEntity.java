package DAO.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "projects", schema = "initdb")
public class ProjectsEntity {
    private int idProjects;
    private String name;
    private BigDecimal cost;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProjects", nullable = false)
    public int getIdProjects() {
        return idProjects;
    }

    public void setIdProjects(int idProjects) {
        this.idProjects = idProjects;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "cost", nullable = true, precision = 2)
    public BigDecimal getCost() {
        return cost;
    }

    @ManyToMany(mappedBy = "projects_comp")
    private Set<CompaniesEntity> companies = new HashSet<CompaniesEntity>();

    @ManyToMany(mappedBy = "projects_cust")
    private  Set<CustomersEntity> customers = new HashSet<CustomersEntity>();

    @ManyToMany(mappedBy = "projects_dev")
    private Set<DevelopersEntity> developers = new HashSet<DevelopersEntity>();

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProjectsEntity that = (ProjectsEntity) o;

        if (idProjects != that.idProjects) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (cost != null ? !cost.equals(that.cost) : that.cost != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idProjects;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (cost != null ? cost.hashCode() : 0);
        return result;
    }
}
