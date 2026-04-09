Wishlist Management Feature

The wishlist Controller, Model, and Repository are implemented into the project. This  allows users to create wishlists, view  wishlists, add books to a wishlist, and retrieve books from a wishlist.

To run the application, start the project in and make sure that the local database is configured and running

In POSTMAN, the following requests can be used to interact with this feature:

POST /wishlists to create a wishlist
Example body:

{
"userId": 1,
"name": "Favorites",
"primary": true
}


GET /wishlists to retrieve all wishlists

POST /wishlists/{wishlistId}/books to add a book to a wishlist
Example body:

{
"bookId": 1
}

GET /wishlists/{id}/books to retrieve all books in a specific wishlist

Sample Response:

{
"id": 1,
"userId": 1,
"name": "Favorites",
"primary": true
}

To verify the data in MySQL, run:


SELECT * FROM wishlist;
SELECT * FROM wishlist_book;# ProjectScrum