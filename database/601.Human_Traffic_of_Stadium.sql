
SELECT * from (
    SELECT s1.*
    from stadium s1,stadium s2, stadium s3
    where s1.id = s2.id -1 and s2.id = s3.id-1
        and s1.people>=100 and s2.people>=100 and s3.people >=100
	UNION 
    SELECT s2.*
    from stadium s1,stadium s2, stadium s3
    where s1.id = s2.id -1 and s2.id = s3.id-1
        and s1.people>=100 and s2.people>=100 and s3.people >=100
    UNION
    SELECT s3.*
    from stadium s1,stadium s2, stadium s3
    where s1.id = s2.id -1 and s2.id = s3.id-1
        and s1.people>=100 and s2.people>=100 and s3.people >=100
) t
ORDER BY date;