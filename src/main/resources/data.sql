INSERT INTO cart (id, user_id)
VALUES (1, 1);

INSERT INTO cart_items (cart_id, book_id, quantity)
VALUES (1, 101, 2);

INSERT INTO cart_items (cart_id, book_id, quantity)
VALUES (1, 102, 1);

INSERT INTO wishlist (user_id, name, is_primary)
VALUES (1, 'Primary Wishlist', true);

INSERT INTO wishlist (user_id, name, is_primary)
VALUES (1, 'Fantasy Books', false);

INSERT INTO wishlist_books (wishlist_id, book_id)
VALUES (1, 101);

INSERT INTO wishlist_books (wishlist_id, book_id)
VALUES (1, 102);