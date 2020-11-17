package pl.politechnika.lab3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalendarController {

    @GetMapping("/weeiaCalendar")
    public int getICSCalendar(@RequestParam int month) {
        return month;
    }
}
