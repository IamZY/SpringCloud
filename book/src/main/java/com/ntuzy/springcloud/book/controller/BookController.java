package com.ntuzy.springcloud.book.controller;

import com.ntuzy.springcloud.book.entity.Book;
import com.ntuzy.springcloud.book.service.BookService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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


}
