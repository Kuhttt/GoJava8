select idCompanys, idCustomers from
(select idCompanys, idCustomers, sum(cost) SumCost
from companys_projects inner join
customers_projects using (idProjects)
inner join projects using (idProjects)
group by idCompanys, idCustomers) s
where s.SumCost = (select max(cost) from companys_projects cp
inner join projects using (idProjects)
where cp.idCompanys = s.idCompanys)





