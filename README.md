# springboot_Photo_Api
Crash Course on springboot

- Download file in target folder
- Place in folder somewhere on system
- run cdm with admin rights
- Enter following command:
java -jar photoz-clone-0.0.1-SNAPSHOT.jar

*If Errors occur.*

- Make sure JDK version 17 is installed:
https://www.oracle.com/java/technologies/downloads/#jdk17-windows - Windows (switch between tabs if MAC or Linux)

*This should ensure app to start.*

<h3>Description of pages in App</h3>

- http://localhost:8080/ - *Welcome Page*
- http://localhost:8080/photoz *Should show empty brackets - meaning no Photos uploaded*
- http://localhost:8080/upload.html - *where you upload an image*
- http://localhost:8080/download/id - *id = whatever id is stored in the DB (can be found going back to http://localhost:8080/photoz )* 

*if http://localhost:8080/photoz gives error page*
- open http://localhost:8080/h2-console 
- replace JDBC URL "jdbc:h2:~/test" with "jdbc:h2:~/springboot"
- Clear Username and Password fields and Connect

*Run following SQL ,IF PHOTOZ Table already EXISTS:*

```
DROP TABLE PHOTOZ
CREATE TABLE IF NOT EXISTS PHOTOZ (
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    file_name VARCHAR(255),
    content_type VARCHAR(255),
    data binary large object
);
```

*Otherwise just run the Create Table query*

<h3>Steps to follow</h3>

1) Refresh http://localhost:8080/photoz *should be empty brackets on screen*
2) Go to http://localhost:8080/upload.html 
3) Upload a image file *(Preferably jpg/png)*
4) Go to http://localhost:8080/photoz *see if brackets contain file data - copy id of file*
5) Go to http://localhost:8080/download/id *insert copied id inplace of id* *example URL -> http://localhost:8080/download/1
6) Image should display
