package org.aibles.ioc_and_di.book;

import org.springframework.stereotype.Component;

@Component
public class Book {

  private ReadBook readBook = new ReadBook();

  String name;
  String author;

  public Book() {
  }

  public Book(String name, String author) {
    this.name = name;
    this.author = author;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }
}
