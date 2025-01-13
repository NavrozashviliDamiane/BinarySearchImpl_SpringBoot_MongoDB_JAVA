package com.binary_search.books.service;

import com.binary_search.books.model.Book;
import java.util.List;

public interface BookService {
    List<Book> searchBooks(String title);
}
