package pl.politechnika.lab3.controller;

import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.model.property.CalScale;
import net.fortuna.ical4j.model.property.ProdId;
import net.fortuna.ical4j.model.property.Version;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;


@Controller
public class CalendarController {

    @GetMapping("/weeiaCalendar")
    public ResponseEntity<String> getICSCalendar(@RequestParam int month) throws IOException {
        if (!isCorrectMonth(month)) {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
        String formatted = String.format("%02d", month);
        parseHTMLCalendar(formatted);
        return new ResponseEntity<>(formatted, HttpStatus.OK);
    }

    private boolean isCorrectMonth(int month) {
        return month > 0 && month <= 12;
    }

    private void parseHTMLCalendar(String monthInCorrectFormat) throws IOException {
        int currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
        Document doc = Jsoup.connect("http://www.weeia.p.lodz.pl/pliki_strony_kontroler/kalendarz.php?rok=" + currentYear + "&miesiac=" + monthInCorrectFormat).get();
        System.out.println(doc);
    }
}
