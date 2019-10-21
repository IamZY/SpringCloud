package com.ntuzy.springcloud.client.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ClientController {

    @GetMapping("/msg")
    @ResponseBody
    public String msg() {
        return "I am microService";
    }


}
