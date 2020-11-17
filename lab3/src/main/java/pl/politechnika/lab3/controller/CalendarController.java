package pl.politechnika.lab3.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalendarController {

    @GetMapping("/weeiaCalendar")
    public ResponseEntity<Integer> getICSCalendar(@RequestParam int month) {
        return new ResponseEntity<>(month, HttpStatus.OK);
    }
}
