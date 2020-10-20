package com.example.lab1.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ReverseController {

    @GetMapping("/reverseString")
    public ResponseEntity<String> reverseString(@RequestParam String toReverse) {
        String reversed = new StringBuilder(toReverse).reverse().toString();
        return new ResponseEntity<>(reversed, HttpStatus.OK);
    }

}
