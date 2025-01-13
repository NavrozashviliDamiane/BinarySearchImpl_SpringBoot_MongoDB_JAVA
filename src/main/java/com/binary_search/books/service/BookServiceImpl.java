package com.binary_search.books.service;

import com.binary_search.books.model.Book;
import com.binary_search.books.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> searchBooks(String title) {
        List<Book> books = bookRepository.findAll();
        books.sort(Comparator.comparing(Book::getTitle, String.CASE_INSENSITIVE_ORDER));

        return binarySearch(books, title);
    }

    private List<Book> binarySearch(List<Book> books, String targetTitle) {
        int left = 0;
        int right = books.size() - 1;
        List<Book> matchingBooks = new ArrayList<>();

        while (left <= right) {
            int mid = (left + right) / 2;
            String midTitle = books.get(mid).getTitle();

            if (midTitle.equalsIgnoreCase(targetTitle)) {
                matchingBooks.add(books.get(mid));
                break;
            } else if (midTitle.compareToIgnoreCase(targetTitle) < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return matchingBooks;
    }

}
