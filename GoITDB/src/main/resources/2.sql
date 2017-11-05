select idProjects, sum(salary) SumSalary 
from developers_projects dp 
inner join developers d
using (idDevelopers) 
group by (idProjects)
order by SumSalary desc
limit 1

