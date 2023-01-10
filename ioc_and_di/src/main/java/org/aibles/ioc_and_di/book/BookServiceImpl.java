package org.aibles.ioc_and_di.book;

import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService{

  @Override
  public void getBook() {
    System.out.printf("Hello");
  }
}
