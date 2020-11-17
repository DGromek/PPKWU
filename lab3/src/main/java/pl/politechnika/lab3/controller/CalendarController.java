package pl.politechnika.lab3.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class CalendarController {

    @GetMapping("/weeiaCalendar")
    public ResponseEntity<String> getICSCalendar(@RequestParam int month) {
        if (!isCorrectMonth(month)) {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
        String formatted = String.format("%02d", month);
        return new ResponseEntity<>(formatted, HttpStatus.OK);
    }

    private boolean isCorrectMonth(int month) {
        return month > 0 && month <= 12;
    }
}
