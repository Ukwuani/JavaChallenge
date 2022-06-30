# Java App Challenge

## Project Setup
#### create a emrdb database and load the sql file dump.sql (not necessary)
```
mysql -u [user] -p emrdb < dump.sql
```
#### Build Maven
```
./mvnw 
```
#### Run Test
```
./mvnw test 
```

#### Post man collection
[postman collection url]("https://documenter.getpostman.com/view/5832701/UzBvH3zu")


<br/>

## The challenge
|~ | Task | Info |
|- | - | - 
|1 | An endpoint to add a new staff member to the service, a uuid is autogenerated for every staff member which will be required for subsequent API requests. | Staff profile comprise: id, name, uuid, registration_date
|2 | An endpoint to update staff member profile | (Requires validating staff uuid before access)
| 3 | An endpoint to fetch all patient profiles (up to 2 years old) <br/> Patient profile comprise: id, name, age, last_visit_date | (Requires validating staff uuid before access)
|4| An endpoint to download a specific patient’s profile into a csv file | (Requires validating staff uuid before access)
|5 | An endpoint to delete multiple patient profiles between a date range | (Requires validating staff uuid before access)

<br/> 

# Tools & Additional Requirement

| ~ | Tasks | Tools
| - | - | -
| 1 |  Database | (use H2 or MySQL)|
|2 | API service should populated with some initial patient profile data | (use SQL script or Liquibase)<br/>(Populate over hundred mock/random patient profile data)
| 3 | Two test cases provided for any endpoint of your choice | 
