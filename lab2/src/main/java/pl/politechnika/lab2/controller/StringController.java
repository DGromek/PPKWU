package pl.politechnika.lab2.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.politechnika.lab2.model.StringAnalyse;

@Controller
public class StringController {

    @GetMapping("/stringAnalyse")
    public ResponseEntity<StringAnalyse> getStringAnalyse(@RequestParam String string) {
        return new ResponseEntity<>(StringAnalyse.analyseString(string), HttpStatus.OK);
    }
}
