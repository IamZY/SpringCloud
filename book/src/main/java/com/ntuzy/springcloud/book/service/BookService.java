package com.ntuzy.springcloud.book.service;

import com.ntuzy.springcloud.book.entity.Book;
import com.ntuzy.springcloud.book.repository.BookRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BookService {

    @Resource
    private BookRepository bookRepository = null;

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

}
