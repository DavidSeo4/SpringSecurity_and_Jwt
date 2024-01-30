# Spring Security and JSON Web Token Authentication.

This project utilizes Spring Security and JSON Web Token (JWT) to establish security within the application. It provides authentication and authorization mechanisms to control access to endpoints based on user roles and permissions.
JSON Web Tokens are used for authentication purposes, allowing users to access endpoints securely. Access to resources within the application is governed by user roles and authorities.

The necessary data to populate the database is provided in the import.sql file located in the resources directory.
Upon running the application, the data will be automatically imported into the database.

To access the application's endpoints, you need to generate a JWT token.
Use the /auth/authenticate endpoint to generate a JWT token by providing the required credentials from the import.sql file.

Once you have obtained a JWT token, you can access the application's resources based on the authorities associated with the user.
Include the generated JWT token in the Authorization header of your HTTP requests.

### Endpoints
- /auth/authenticate (POST):

Endpoint to authenticate users and generate a JWT token. Requires user credentials provided in the import.sql file.


- /students/{id}/marks (GET):

Access point to the marks of a specific student that must be defined by id in the URL. Only accessible to Users with the STUDENT role.

- /students/allmarks (GET):

Access point to all the info of the students (basically marks and name). Only accessible to Users with the TEACHER role.

### Technologies Used
- Spring Boot
- Spring Security
- JSON Web Token (JWT)
- MySQL

### Contributors:
- David Seoane - Developer