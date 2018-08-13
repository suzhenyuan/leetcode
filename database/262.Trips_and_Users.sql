
SELECT Request_at as Day,round(count(if(t.`Status`='cancelled_by_client' or t.`Status`='cancelled_by_driver',t.id,NULL))/count(*),2) as "Cancellation Rate"
FROM trips t, users d,users c
where t.Client_Id = c.Users_Id and t.Driver_Id = d.Users_Id
and d.Banned='NO' and c.Banned='NO' and Request_at >='2013-10-01' and Request_at<='2013-10-03'
GROUP BY Request_at