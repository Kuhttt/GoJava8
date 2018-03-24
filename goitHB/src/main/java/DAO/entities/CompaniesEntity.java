package DAO.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "companies", schema = "initdb")
public class CompaniesEntity {
    private int idCompanies;
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCompanies", nullable = false)
    public int getIdCompanies() {
        return idCompanies;
    }

    public void setIdCompanies(int idCompanies) {
        this.idCompanies = idCompanies;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return name;
    }

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "companys_projects",
            joinColumns = {@JoinColumn(name = "idCompanys")},
            inverseJoinColumns = {@JoinColumn(name = "idProjects")}
    )

    Set<ProjectsEntity> projects_comp = new HashSet<ProjectsEntity>();

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CompaniesEntity that = (CompaniesEntity) o;

        if (idCompanies != that.idCompanies) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCompanies;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

}
