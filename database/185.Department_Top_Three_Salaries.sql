
SELECT d.Name as Department, t.Name as employee,t.Salary
from (
		SELECT e.*,(select count(DISTINCT ee.Salary) from Employee ee where ee.DepartmentId = e.DepartmentId and ee.Salary> e.Salary) as srt
		from Employee e ) t,Department d
where t.DepartmentId = d.Id and t.srt<=2
ORDER by d.id , t.srt;
