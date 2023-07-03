USE ORGANIZATION;

#26. display all deptnames and corresponding employees if ANY

SELECT DNAME, ENAME
FROM DEPT ,EMP 
WHERE DEPT.DEPTNO = EMP.DEPTNO;

#27. dipslay all deptnames where there are no employees


SELECT D.DNAME FROM DEPT D
LEFT JOIN EMP E ON D.DEPTNO = E.DEPTNO
WHERE E.DEPTNO IS NULL;

SELECT D.DNAME 
FROM DEPT D
WHERE D.DEPTNO NOT IN (SELECT EMP.DEPTNO FROM EMP);




#28. display deptname wise employee count greater than 3, display in descending order of deptname

SELECT DNAME ,COUNT(*) AS EMPCOUNT
FROM DEPT,EMP
WHERE DEPT.DEPTNO = EMP.DEPTNO
GROUP BY DEPT.DNAME
HAVING COUNT(EMP.ENAME)>3
ORDER BY DNAME DESC;


#29. Display all the empname and their manager names

SELECT E.ENAME AS EmployeeName, M.ENAME AS ManagerName
FROM EMP AS E,EMP AS M
WHERE E.MGR = M.EMPNO;



#30. Display empname,deptname and manager name as bossname , order by bossname



SELECT E.ENAME AS EmployeeName, D.DNAME AS DeptName, M.ENAME AS BossName
FROM EMP E
JOIN DEPT D ON E.DEPTNO = D.DEPTNO
JOIN EMP M ON E.MGR = M.EMPNO
ORDER BY BossName ASC;

SELECT E.ENAME AS EmployeeName, D.DNAME AS DeptName, M.ENAME AS BossName
FROM EMP E ,DEPT D, EMP M
WHERE E.DEPTNO = D.DEPTNO
AND E.MGR = M.EMPNO
ORDER BY BossName ASC;



#31. Display Dname, employee name and names of their managers

SELECT E.ENAME AS EmployeeName, D.DNAME AS DeptName, M.ENAME AS Manager
FROM EMP E
JOIN DEPT D ON E.DEPTNO = D.DEPTNO
JOIN EMP M ON E.MGR = M.EMPNO

