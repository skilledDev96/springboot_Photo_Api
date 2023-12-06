# springboot_Photo_Api
Crash Course on springboot

Download file in target folder
Place in folder somewhere on system
run cdm with admin rights
Enter following command:
java -jar photoz-clone-0.0.1-SNAPSHOT.jar

If Errors occur.
Make sure JDK version 17 is installed:
https://www.oracle.com/java/technologies/downloads/#jdk17-windows - Windows (switch between tabs if MAC or Linux)

This should ensure app to start.

http://localhost:8080/ - Welcome Page
http://localhost:8080/photoz Should show empty brackets - meaning no Photos uploaded
http://localhost:8080/upload.html - where you upload an image
http://localhost:8080/download/id - id = whatever id is stored in the DB (can be found going back to http://localhost:8080/photoz ) 

if http://localhost:8080/photoz gives error page
open http://localhost:8080/h2-console 
replace JDBC URL "jdbc:h2:~/test" with "jdbc:h2:~/springboot"
Clear Username and Password fields and Connect

Run following SQL
IF PHOTOZ Table already EXISTS:
DROP TABLE PHOTOZ
CREATE TABLE IF NOT EXISTS PHOTOZ (
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    file_name VARCHAR(255),
    content_type VARCHAR(255),
    data binary large object
);

Otherwise just run the Create Table query

Refresh http://localhost:8080/photoz and should be empty brackets on screen
go to http://localhost:8080/upload.html 
Upload a image file
go to http://localhost:8080/photoz see if brackets contain file data - copy id of file
go to http://localhost:8080/download/id -= insert copied id inplace of id
Image should display
