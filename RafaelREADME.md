#Shopping Cart

The Shopping Cart controller, model, and repository have been implemented in the GeektextApplication file.

To retrieve the list of book(s) in the user's shopping cart, use a GET request and http://localhost:8080/cart/user/{userId}/items replacing {userId} with to the userId you want to view.

To add a book to the shopping cart, use a POST request and http://localhost:8080/cart/add?userId={userId}&bookId={bookId} replacing {userId} with the userId you want to edit and {bookId} with the bookId of the book you want to add to the shopping cart.

To delete a book from the shopping cart instance for that user, use a DELETE request and http://localhost:8080/cart/remove?userId={userId}&bookId={bookId} replacing {userId} with the userId you want to edit and {bookId} with the bookId of the book you want to remove from the shopping cart.

To retrieve the subtotal price of all items in the user's shopping cart, use a GET request and http://localhost:8080/cart/user/{userId}/subtotal replacing {userId} with the userId you want to find the subtotal of.
