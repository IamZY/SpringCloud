package com.ntuzy.springcloud.book.service;

import com.ntuzy.springcloud.book.entity.Book;
import com.ntuzy.springcloud.book.repository.BookRepository;
import com.ntuzy.springcloud.book.service.exception.BookNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Resource
    private BookRepository bookRepository = null;

    public List<Book> findAll() {
        return bookRepository.findAll();
    }


    public Book getInfo(Long bid) {
        Optional<Book> optional = bookRepository.findById(bid);

        Book book = null;

        if (optional.isPresent()) {
            book = optional.get();
        } else {
            throw new BookNotFoundException("BOOKID " + bid + " not found");
        }


        return book;

    }


}
