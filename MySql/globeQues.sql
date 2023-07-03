USE GLOBE;

SELECT *FROM REGIONS;
SELECT *FROM COUNTRIES;


#1. Show all locations of a country having country id as "IT"

SELECT * FROM LOCATIONS
WHERE COUNTRY_ID = 'IT';

#2. Show all location names country wise in a region "Asia"

SELECT REGION_NAME ,COUNTRY_NAME, CITY
FROM REGIONS R,COUNTRIES C, LOCATIONS L
WHERE (R.REGION_ID = C.REGION_ID AND R.REGION_NAME = 'Asia')
AND (C.COUNTRY_ID = L.COUNTRY_ID);

SELECT REGION_NAME ,COUNTRY_NAME, CITY
FROM REGIONS R
LEFT JOIN COUNTRIES AS C ON R.REGION_ID = C.REGION_ID 
LEFT JOIN LOCATIONS AS L ON C.COUNTRY_ID = L.COUNTRY_ID
WHERE (R.REGION_NAME = 'Asia' AND L.CITY IS NOT NULL);


#3. Show all postal codes of United States



#4. Show number of countries in each region

SELECT REGION_NAME,COUNT(*) AS NoOfCountries
FROM REGIONS R, COUNTRIES C
WHERE R.REGION_ID = C.REGION_ID
GROUP BY C.REGION_ID;

#5. Show postal codes of locations country wise ignoring locations not having state province 

SELECT COUNTRY_NAME, POSTAL_CODE, CITY, STATE_PROVINCE
FROM COUNTRIES C,LOCATIONS L
WHERE C.COUNTRY_ID = L.COUNTRY_ID
AND L.STATE_PROVINCE IS NOT NULL;

#6. Show names of countries in each region in descending order of number of locations in that country

SELECT REGION_NAME , COUNTRY_NAME , COUNT(*) AS LocationsInCountry
FROM REGIONS R , COUNTRIES C ,LOCATIONS L
WHERE (R.REGION_ID = C.REGION_ID) AND (C.COUNTRY_ID = L.COUNTRY_ID)
GROUP BY C.COUNTRY_ID;

SELECT R.REGION_NAME, C.COUNTRY_NAME, COUNT(L.COUNTRY_ID) AS LocationsInCountry
FROM REGIONS R
LEFT JOIN COUNTRIES C ON R.REGION_ID = C.REGION_ID
LEFT JOIN LOCATIONS L ON C.COUNTRY_ID = L.COUNTRY_ID
GROUP BY R.REGION_NAME, C.COUNTRY_NAME
ORDER BY R.REGION_NAME ,LocationsInCountry DESC;

#7. Show countries having maximum locations with number of locations in it

SELECT COUNTRY_NAME , COUNT(*) AS NoOfLocations
FROM COUNTRIES C, LOCATIONS L
WHERE C.COUNTRY_ID = L.COUNTRY_ID
GROUP BY L.COUNTRY_ID
ORDER BY NoOfLocations DESC;

SELECT COUNTRY_NAME, COUNT(L.COUNTRY_ID) AS NoOfLocations
FROM COUNTRIES C
LEFT JOIN LOCATIONS L ON C.COUNTRY_ID = L.COUNTRY_ID
GROUP BY COUNTRY_NAME
ORDER BY NoOfLocations DESC;

#8. Count number of locations in each region

SELECT REGION_NAME,COUNT(*) AS NOOFLOCATIONS
FROM REGIONS R, COUNTRIES C, LOCATIONS L
WHERE( R.REGION_ID = C.REGION_ID)
AND (C.COUNTRY_ID = L.COUNTRY_ID)
GROUP BY C.COUNTRY_ID;
