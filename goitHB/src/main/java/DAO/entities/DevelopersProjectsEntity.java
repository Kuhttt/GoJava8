package DAO.entities;

import javax.persistence.*;

@Entity
@Table(name = "developers_projects", schema = "initdb")
public class DevelopersProjectsEntity {
    private int idDevelopersProjects;
    private DevelopersEntity developersByIdDevelopers;

    @Id
    @Column(name = "idDevelopers-projects", nullable = false)
    public int getIdDevelopersProjects() {
        return idDevelopersProjects;
    }

    public void setIdDevelopersProjects(int idDevelopersProjects) {
        this.idDevelopersProjects = idDevelopersProjects;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DevelopersProjectsEntity that = (DevelopersProjectsEntity) o;

        if (idDevelopersProjects != that.idDevelopersProjects) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return idDevelopersProjects;
    }

    @ManyToOne
    @JoinColumn(name = "idDevelopers", referencedColumnName = "idDevelopers", nullable = false)
    public DevelopersEntity getDevelopersByIdDevelopers() {
        return developersByIdDevelopers;
    }

    public void setDevelopersByIdDevelopers(DevelopersEntity developersByIdDevelopers) {
        this.developersByIdDevelopers = developersByIdDevelopers;
    }
}
