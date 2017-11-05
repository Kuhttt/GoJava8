
INSERT INTO `companies` (`idCompanies`,`name`) VALUES (1,'Samsung');

INSERT INTO `companies` (`idCompanies`,`name`) VALUES (2,'Sony');

INSERT INTO `companies` (`idCompanies`,`name`) VALUES (3,'Microsoft');

INSERT INTO `companys_projects` (`idcompanys_projects`,`idCompanys`,`idProjects`) VALUES (1,1,1);

INSERT INTO `companys_projects` (`idcompanys_projects`,`idCompanys`,`idProjects`) VALUES (2,1,2);

INSERT INTO `companys_projects` (`idcompanys_projects`,`idCompanys`,`idProjects`) VALUES (3,2,3);

INSERT INTO `companys_projects` (`idcompanys_projects`,`idCompanys`,`idProjects`) VALUES (4,3,1);


INSERT INTO `customers` (`idCustomers`,`name`) VALUES (1,'Customer1');

INSERT INTO `customers` (`idCustomers`,`name`) VALUES (2,'Customer2');

INSERT INTO `customers` (`idCustomers`,`name`) VALUES (3,'Customer3');

INSERT INTO `customers` (`idCustomers`,`name`) VALUES (4,'Customer4');



INSERT INTO `customers_projects` (`idcustomers_projects`,`idCustomers`,`idProjects`) VALUES (1,1,1);

INSERT INTO `customers_projects` (`idcustomers_projects`,`idCustomers`,`idProjects`) VALUES (2,2,2);

INSERT INTO `customers_projects` (`idcustomers_projects`,`idCustomers`,`idProjects`) VALUES (3,2,3);

INSERT INTO `customers_projects` (`idcustomers_projects`,`idCustomers`,`idProjects`) VALUES (4,3,1);

INSERT INTO `customers_projects` (`idcustomers_projects`,`idCustomers`,`idProjects`) VALUES (5,4,2);



INSERT INTO `developers` (`idDevelopers`,`name`) VALUES (1,'Vasya');

INSERT INTO `developers` (`idDevelopers`,`name`) VALUES (2,'Petya');

INSERT INTO `developers` (`idDevelopers`,`name`) VALUES (3,'Vova');

INSERT INTO `developers` (`idDevelopers`,`name`) VALUES (4,'Nikita');



INSERT INTO `developers_projects` (`idDevelopers_projects`,`idDevelopers`,`idProjects`) VALUES (1,1,1);

INSERT INTO `developers_projects` (`idDevelopers_projects`,`idDevelopers`,`idProjects`) VALUES (2,2,1);

INSERT INTO `developers_projects` (`idDevelopers_projects`,`idDevelopers`,`idProjects`) VALUES (3,1,2);

INSERT INTO `developers_projects` (`idDevelopers_projects`,`idDevelopers`,`idProjects`) VALUES (4,3,2);

INSERT INTO `developers_projects` (`idDevelopers_projects`,`idDevelopers`,`idProjects`) VALUES (5,4,3);



INSERT INTO `projects` (`idProjects`,`name`) VALUES (1,'Project1');

INSERT INTO `projects` (`idProjects`,`name`) VALUES (2,'Project2');

INSERT INTO `projects` (`idProjects`,`name`) VALUES (3,'Project3');




INSERT INTO `skills` (`idSkills`,`name`) VALUES (1,'Java');

INSERT INTO `skills` (`idSkills`,`name`) VALUES (2,'C++');

INSERT INTO `skills` (`idSkills`,`name`) VALUES (3,'JS');

INSERT INTO `skills` (`idSkills`,`name`) VALUES (4,'C#');
