 SELECT * FROM DEPT;
 SELECT * FROM EMP;
 
#1. Display all employee names in ascending order

SELECT ENAME FROM EMP 
ORDER BY ENAME ASC;

#2. Display all employees(all columns) in department 20 and 30

SELECT ENAME , DEPTNO FROM EMP
WHERE DEPTNO IN (20,30);

#3. Display all the employees who are managers

SELECT ENAME ,JOB FROM EMP
WHERE JOB = 'MANAGER';

#4. Display all the employees whose salary is between 2000 and 5000

SELECT ENAME , SAL FROM EMP
WHERE  SAL> 2000 AND SAL<5000;

#5. Display all the employees whose commission is null

SELECT ENAME ,  COM FROM EMP
WHERE COM = NULL;

#6. Display emp_name,salary,comission,ctc(calculated column)
	
    SELECT ENAME , SAL , COM ,(SAL+IFNULL(COM,0)) AS CTC FROM EMP;

#7. Display hire_date, current_date, tenure(calculated col) of the empl

SELECT HIREDATE, CURDATE() AS CURRENTDATE, DATEDIFF(CURDATE(), HIREDATE) AS TENURE FROM EMP;

#8. Display all the employees whose name starts with s

SELECT ENAME FROM EMP
WHERE ENAME LIKE "S%";

#9. Display unique department numbers from the employee table
SELECT DNAME FROM DEPT
WHERE DEPTNO =(
SELECT DISTINCT DEPTNO FROM EMP
);


#10. Display emp_name and job in lower case

SELECT LOWER(ENAME) , LOWER(JOB) FROM EMP;
