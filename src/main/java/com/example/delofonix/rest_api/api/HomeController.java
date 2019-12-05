package com.example.delofonix.rest_api.api;

import org.springframework.web.bind.annotation.*;




@RestController
public class HomeController {


    @GetMapping("/")
    public String index() {
        return "You are in!";
    }



}
