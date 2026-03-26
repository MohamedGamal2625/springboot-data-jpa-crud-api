- Create Author
Endpoint: POST /api/auther/insert
Description: Adds a new author to the database.
Request Body: JSON with name
- Get All Authors
Endpoint: GET http://localhost:8080/auther
Description: Retrieves a list of all authors.
- Get Author By ID
Endpoint: GET  http://localhost:8080/auther/{id}
Description: Retrieves a single author by their ID.
- Update Author
Endpoint: PUT  http://localhost:8080/auther/update
Description: Updates an existing author’s details.
Request Body: JSON with id and updated fields
- Delete Author
Endpoint: DELETE  http://localhost:8080/auther/delete/{id}
Description: Deletes an author by ID.
