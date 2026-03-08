INSERT INTO wishlist (user_id, name, is_primary)
VALUES (1, 'Primary Wishlist', true);

INSERT INTO wishlist (user_id, name, is_primary)
VALUES (1, 'Fantasy Books', false);

INSERT INTO wishlist_books (wishlist_id, book_id)
VALUES (1, 101);

INSERT INTO wishlist_books (wishlist_id, book_id)
VALUES (1, 102);
