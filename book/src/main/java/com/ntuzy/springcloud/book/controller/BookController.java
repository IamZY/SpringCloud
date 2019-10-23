package com.ntuzy.springcloud.book.controller;

import com.ntuzy.springcloud.book.entity.Book;
import com.ntuzy.springcloud.book.service.BookService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class BookController {

    @Resource
    private BookService bookService = null;


    @GetMapping("/list")
    public Map list() {
        Map result = new HashMap();
        try {
            List list = bookService.findAll();
            result.put("code", "0");
            result.put("message", "success");
            result.put("data", list);
        } catch (Exception e) {
            result.put("code", e.getClass().getSimpleName());
            result.put("message", e.getMessage());
        }
        return result;
    }


    @GetMapping("/info")
    public Map info(Long bid) {
        Map result = new HashMap();
        try {
            Book book = bookService.getInfo(bid);
            result.put("code", "0");
            result.put("message", "success");
            result.put("data", book);
        } catch (Exception e) {
            result.put("code", e.getClass().getSimpleName());
            result.put("message", e.getMessage());
        }
        return result;
    }


    @RequestMapping("/borrow")
    public Map borrow(String mobile, Long bid, String takeDate, String returnDate) {

        Date tDate = null;
        Date rDate = null;


        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        try {
            tDate = format.parse(takeDate);
            rDate = format.parse(returnDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Map result = new HashMap();
        try {
            bookService.borrow(bid, Long.parseLong(mobile), tDate, rDate);
            result.put("code", "0");
            result.put("message", "success");
        } catch (Exception e) {
            e.printStackTrace();
            result.put("code", e.getClass().getName());
            result.put("message", e.getMessage());
        }
        return result;


    }


}
