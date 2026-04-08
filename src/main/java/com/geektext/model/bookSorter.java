package com.geektext.model;

import jakarta.persistence.*;

@Entity
@Table(name = "bookSorter")
public class bookSorter{
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long bookId;

  @Column(name = "title", nullable = false)
  private String title;
  
  @Column(name = "author", nullable = false)
  private String author;
  
  @Column(name = "genre", nullable = false)
  private String genre;

  @Column(name = "price", nullable = false)
  private double price;
  
  @Column(name = "rating", nullable = false)
  private double rating;

  @Column(name = "sales", nullable = false)
  private int sales;
  
  @Column(name = "publisher", nullable = false)
  private String publisher;

  public bookSort(){}
  
  public bookSort(Long bookId, String title, String author, String genre, double price, double rating, int sales, String publisher){
    this.bookId = bookId;
    this.title = title;
    this.author = author;
    this.genre = genre;
    this.price = price;
    this.rating = rating;
    this.sales = sales;
    this.publisher = publisher;
  }


    public Long getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public double getPrice() {
        return price;
    }

    public double getRating() {
        return rating;
    }

    public int getSales() {
        return sales;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
