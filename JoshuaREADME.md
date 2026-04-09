# Profile Management

The User Controller, Model, and Repository along with the Credit Card functionality have been successfully implemented into the GeektextApplication file.

Once you run the application in your IDE, make sure your server is running and Postman is ready for testing.

---

## Create a User

To create a user, send a POST request to:

http://localhost:8080/api/users

Set the body to raw JSON and use the template below:

{
  "username": "josh",
  "password": "123",
  "name": "Joshua",
  "email": "josh@email.com",
  "homeAddress": "Miami"
}

Click send. This will create a new user in the database.

---

## Retrieve a User

To retrieve a user, send a GET request to:

http://localhost:8080/api/users/{username}

Replace {username} with the desired username.

Example:

http://localhost:8080/api/users/josh

Click send to view the user information in JSON format.

---

## Update a User

To update a user, send a PUT request to:

http://localhost:8080/api/users/{username}

Replace {username} with the username you want to update.

Set the body to raw JSON:

{
  "password": "456",
  "name": "Updated Name",
  "homeAddress": "Orlando"
}

Click send to update the user’s information.

Note: Email is not updated as per requirements.

---

## Add Credit Card to User

To add a credit card to a user, send a POST request to:

http://localhost:8080/api/users/{username}/credit-card

Replace {username} with the username.

Set the body to raw JSON:

{
  "cardNumber": "123456789",
  "expirationDate": "12/28",
  "cvv": 123
}

Click send to associate the credit card with the user.

---

## Notes

- Make sure the application is running before sending requests.
- Use Postman to test all endpoints.
- Data will be stored in the configured database (H2 or MySQL).
- Each request should return appropriate HTTP status codes (200, 201, 404).

---

## Testing

After each request, you can verify the data by:

- Sending a GET request to retrieve updated user information
- Checking the database directly if needed

Repeat the steps as necessary to test functionality.