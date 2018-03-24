package DAO.entities;

import javax.persistence.*;

@Entity
@Table(name = "developers-skills", schema = "initdb")
public class DevelopersSkillsEntity {
    private int idDevelopersSkills;
    private DevelopersEntity developersByIdDevelopers;

    @Id
    @Column(name = "idDevelopers-skills", nullable = false)
    public int getIdDevelopersSkills() {
        return idDevelopersSkills;
    }

    public void setIdDevelopersSkills(int idDevelopersSkills) {
        this.idDevelopersSkills = idDevelopersSkills;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DevelopersSkillsEntity that = (DevelopersSkillsEntity) o;

        if (idDevelopersSkills != that.idDevelopersSkills) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return idDevelopersSkills;
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
