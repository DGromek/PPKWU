package pl.politechnika.lab3.controller;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Controller
public class CalendarController {

    @GetMapping("/weeiaCalendar")
    public ResponseEntity<String> getICSCalendar(@RequestParam int month) throws IOException {
        if (!isCorrectMonth(month)) {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
        String formatted = String.format("%02d", month);
        getListOfEvents(formatted);
        return new ResponseEntity<>(formatted, HttpStatus.OK);
    }

    private boolean isCorrectMonth(int month) {
        return month > 0 && month <= 12;
    }

    private List<String> getListOfEvents(String monthInCorrectFormat) throws IOException {
        int currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
        Document doc = Jsoup.connect("http://www.weeia.p.lodz.pl/pliki_strony_kontroler/kalendarz.php?rok=" + currentYear + "&miesiac=" + monthInCorrectFormat).get();
        Elements events = doc.getElementsByClass("active");
        List<String> result = new ArrayList<>();
        for (int i = 0; i < events.size(); i++) {
            if (i % 2 == 0) {
                result.add(events.get(i).text());
            }
        }
        return result;
    }
}
