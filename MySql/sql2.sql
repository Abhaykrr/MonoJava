USE ORGANIZATION;
#11. Select top 3 salary earning employee

SELECT  ENAME, SAL FROM EMP
ORDER BY SAL
LIMIT 3;

#12. Select clerks and Managers in department 10
SELECT ENAME,JOB FROM EMP
WHERE JOB IN ('CLERK', 'MANAGER') AND DEPTNO = 10;

#13. Display all clerks in asscending order of the department number 

SELECT * FROM EMP
WHERE JOB = 'CLERK'
ORDER BY DEPTNO;

#16. Display All employees in the same dept of 'SCOTT' 
SELECT ENAME,DEPTNO FROM EMP
WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME = 'SCOTT');

#17. Employees having same designation of SMITH
SELECT ENAME ,JOB FROM EMP
WHERE JOB = (SELECT JOB FROM EMP WHERE ENAME = 'SMITH');

#18. Employee who are reproting under KING

SELECT ENAME,MGR FROM EMP
WHERE MGR = (SELECT EMPNO FROM EMP WHERE ENAME = 'KING');

#19. Employees who have same salary of BLAKE
SELECT ENAME,SAL FROM EMP
WHERE SAL = (SELECT SAL FROM EMP WHERE ENAME = 'BLAKE');

#20. Display departmentwise number of employees
SELECT DEPTNO, COUNT(*) AS COUNT
FROM EMP
GROUP BY DEPTNO;

#21. Display jobwise number of employees
SELECT JOB, COUNT(*) AS COUNT
FROM EMP
GROUP BY JOB;

#22. Display deptwise jobwise number of employees

SELECT DEPTNO, JOB, COUNT(*) AS eCOUNT
FROM EMP
GROUP BY DEPTNO, JOB;

#23. Display deptwise  employees greater than  3 

SELECT DEPTNO, COUNT(*) AS COUNT
FROM EMP
GROUP BY DEPTNO
HAVING COUNT(*) > 3;

#24. Display designation wise employees count greater than 3 
SELECT JOB, COUNT(*) AS JCOUNT
FROM EMP
GROUP BY JOB
HAVING COUNT(*) > 3;


#25. Display Employee name,deptname and location

SELECT EMP.ENAME, DEPT.DNAME, DEPT.LOC
FROM EMP,DEPT
WHERE EMP.DEPTNO = DEPT.DEPTNO;