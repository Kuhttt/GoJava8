package DAO.entities;

import javax.persistence.*;

@Entity
@Table(name = "companys_projects", schema = "initdb")
public class CompanysProjectsEntity {
    private int idcompanysProjects;
    private CompaniesEntity companiesByIdCompanys;

    @Id
    @Column(name = "idcompanys_projects", nullable = false)
    public int getIdcompanysProjects() {
        return idcompanysProjects;
    }

    public void setIdcompanysProjects(int idcompanysProjects) {
        this.idcompanysProjects = idcompanysProjects;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CompanysProjectsEntity that = (CompanysProjectsEntity) o;

        if (idcompanysProjects != that.idcompanysProjects) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return idcompanysProjects;
    }

    @ManyToOne
    @JoinColumn(name = "idCompanys", referencedColumnName = "idCompanies", nullable = false)
    public CompaniesEntity getCompaniesByIdCompanys() {
        return companiesByIdCompanys;
    }

    public void setCompaniesByIdCompanys(CompaniesEntity companiesByIdCompanys) {
        this.companiesByIdCompanys = companiesByIdCompanys;
    }
}
