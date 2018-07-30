
select d.name as Department, e.name as Employee, ms.maxSalary as salary
from Employee e,Department d,(select DepartmentId as did,max(salary) maxSalary
	from Employee 
	group by DepartmentId ) ms 
where ms.did = d.id and ms.maxSalary = e.salary and e.DepartmentId = d.id
order by ms.maxSalary;
