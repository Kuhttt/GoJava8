select avg(salary)
from developers_projects 
inner join projects
using (idProjects)
inner join developers
using (idDevelopers)
where cost = (select min(cost) from projects)