package org.aibles.ioc_and_di.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public abstract class BookController {

  // sử dụng interface
  @Autowired
  public BookService bookService;

  // sử dụng Constructor
  @Autowired
  public BookController(BookService bookService) {
    this.bookService = bookService;
  }

  // sử dụng setter
  @Autowired
  public void setBook(BookService bookService) {
    this.bookService = bookService;
  }



}
