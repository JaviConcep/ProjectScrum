Book Details Feature

The Book Controller, Service, Model, and Repository are implemented into our GeektextApplication file. The system supports retrieving book data from the database, including title, author, genre, availability, and price. The Book Details feature allows other components, such as the shopping cart, to access book information dynamically. The API supports retrieving either all books within the database or a specific book by its ID and is used by other features to display, sort, and check out books.

To run the application, start the project in IntelliJ and ensure that the local database is configured and populated with book records.

In POSTMAN, the following requests can be used to interact with this feature:

GET /books to retrieve all books
GET /books/{bookId} to retrieve a specific book

Sample Response

Single Book:

{
  "bookId": 1,
  "title": "The Hobbit",
  "author": "J.R.R. Tolkien",
  "genre": "Fantasy",
  "available": true,
  "price": 15.99
}

Multiple Books:

[
  {
    "bookId": 1,
    "title": "The Hobbit",
    "author": "J.R.R. Tolkien",
    "genre": "Fantasy",
    "available": true,
    "price": 15.99
  },
  {
    "bookId": 2,
    "title": "Dune",
    "author": "Frank Herbert",
    "genre": "Science Fiction",
    "available": true,
    "price": 18.50
  }
]