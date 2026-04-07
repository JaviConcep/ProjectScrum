#  Book Rating and Commenting 
The Book Rating Controller, Model, and Repository have been successfully implemented into our GeektextApplication file.

Once you run the Application in IntelliJ, have your local database and POSTMAN requests ready. 
In POSTMAN, request a POST to add a comment and rating to the book. Add http://localhost:8080/api/ratings/add, and make the body raw JSON, and enter the template below: 
{
  "userId": 1,
  "bookId": 1,
  "rating": 1,
  "comment": "Insert Comment"
}

Then, click send. Now, go to your MySQL database and input: 

SELECT * FROM book_rating;

To successfully create a table and add your POST request information. Repeat these steps until you have the desired number of ratings.

To view comments, request a GET and add http://localhost:8080/api/ratings/book/[id] and change [id] to whatever id number you desire to view. Click send.

To view the rating average, request a GET and add http://localhost:8080/api/ratings/average/[bookid] to view the total average ratings of a specific book.

To update a rating, request a PUT and add http://localhost:8080/api/ratings/[id] and change [id] to whatever userid you desire, and make the body raw JSON. In the body text, type the updated rating you want to replace over the previous rating, then click send.

To Delete a rating from the table, request a DELETE and add http://localhost:8080/api/ratings/[id], replace [id] with whatever id you want to remove, then click send. 

Be sure to keep running SELECT * FROM book_rating; to view your updated table on your local database every time you send a request. 


