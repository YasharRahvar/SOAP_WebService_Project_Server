# SOAP_WebService_Project_Server
This is a SOAP web service server side application using Resource-local JTA, Hibernate.

## Deployment
You can simply create a war file and drop it into webserver deylopment folder and run the server.
Important Notes: 
1. You need to have SOAP_WebService_Project_Server war file in order to be able to work with SOAP_WebService_Project_Client project.
2. This web application has been set up to work on my personal MySql database. In order for you to run the application you need to 
   change the connention pooling configuration in the persistence.xml file to your database.
3. You also need to create a table 'employee'in your database which has field names as follow: [id][varchar](9),[firstName][varchar](250),
[lastName][varchar](250),[date][date]
   
## Built With
Maven

## Author
Yashar Rahvar
