package com.ntuzy.springcloud.book.service;

import com.ntuzy.springcloud.book.client.MemberClient;
import com.ntuzy.springcloud.book.client.MemberDTO;
import com.ntuzy.springcloud.book.client.MemberResult;
import com.ntuzy.springcloud.book.entity.Book;
import com.ntuzy.springcloud.book.entity.Borrow;
import com.ntuzy.springcloud.book.repository.BookRepository;
import com.ntuzy.springcloud.book.repository.BorrowRepository;
import com.ntuzy.springcloud.book.service.exception.BookNotFoundException;
import com.ntuzy.springcloud.book.service.exception.MemberNotFoundException;
import com.ntuzy.springcloud.book.service.exception.NotEnoughStockException;
import javafx.beans.binding.BooleanExpression;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Resource
    private BookRepository bookRepository = null;

    @Resource
    private BorrowRepository borrowRepository;

    @Resource
    private MemberClient memberClient;

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


    public void borrow(Long bid, Long mobile, Date takeDate, Date returnDate) {
        Optional<Book> optional = bookRepository.findById(bid);
        Book book = null;
        if (!optional.isPresent()) {
            throw new BookNotFoundException("BOOKID " + bid + " not found");
        } else {
            book = optional.get();
        }

        if (book.getStock() == 0) {
            throw new NotEnoughStockException("Stock is not enough");
        }

        MemberResult memberResult = memberClient.checkMobile(mobile);

        MemberDTO memberDTO = null;

        if (memberResult.getCode().equals("0")) {
            memberDTO = memberResult.getData();
        } else {
            throw new MemberNotFoundException("Member not found");
        }


        Borrow borrow = new Borrow();
        borrow.setBid(bid);
        borrow.setMid(memberDTO.getMid());
        borrow.setTakedate(takeDate);
        borrow.setReturndate(returnDate);
        borrow.setCreatetime(new Date());

        borrowRepository.saveAndFlush(borrow);

        book.setStock(book.getStock() - 1);

        bookRepository.saveAndFlush(book);


    }


}
