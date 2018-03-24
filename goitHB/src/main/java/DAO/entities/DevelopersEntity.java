package DAO.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "developers", schema = "initdb")
public class DevelopersEntity {
    private int idDevelopers;
    private String name;
    private BigDecimal salary;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDevelopers", nullable = false)
    public int getIdDevelopers() {
        return idDevelopers;
    }

    public void setIdDevelopers(int idDevelopers) {
        this.idDevelopers = idDevelopers;
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
    @Column(name = "salary", nullable = true, precision = 2)
    public BigDecimal getSalary() {
        return salary;
    }

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "developers_projects",
            joinColumns = {@JoinColumn(name = "idDevelopers")},
            inverseJoinColumns = {@JoinColumn(name = "idProjects")}
    )
    Set<ProjectsEntity> projects_dev = new HashSet<ProjectsEntity>();

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "developers-skills",
            joinColumns = {@JoinColumn(name = "idDevelopers")},
            inverseJoinColumns = {@JoinColumn(name = "idSkills")}
    )
    Set<SkillsEntity> skills = new HashSet<SkillsEntity>();

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DevelopersEntity that = (DevelopersEntity) o;

        if (idDevelopers != that.idDevelopers) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (salary != null ? !salary.equals(that.salary) : that.salary != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idDevelopers;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (salary != null ? salary.hashCode() : 0);
        return result;
    }
}
