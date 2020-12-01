package pl.politechnika.lab3.controller;

import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.model.Date;
import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.model.property.CalScale;
import net.fortuna.ical4j.model.property.ProdId;
import net.fortuna.ical4j.model.property.Version;
import net.fortuna.ical4j.util.RandomUidGenerator;
import net.fortuna.ical4j.util.UidGenerator;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
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
        int currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
        getWEEIACalendarForGivenMonth(currentYear, month);
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    private boolean isCorrectMonth(int month) {
        return month > 0 && month <= 12;
    }

    private List<String> getListOfEvents(int year, int month) throws IOException {
        Document doc = Jsoup.connect("http://www.weeia.p.lodz.pl/pliki_strony_kontroler/kalendarz.php?rok=" + year + "&miesiac=" + month).get();
        Elements events = doc.getElementsByClass("active");
        List<String> result = new ArrayList<>();
        for (int i = 0; i < events.size(); i++) {
            if (i % 2 == 0) {
                result.add(events.get(i).text());
            }
        }
        return result;
    }

    private Calendar getWEEIACalendarForGivenMonth(int year, int month) throws IOException {
        Calendar calendar = new Calendar();
        calendar.getProperties().add(new ProdId("WEEIACalendar"));
        calendar.getProperties().add(Version.VERSION_2_0);
        calendar.getProperties().add(CalScale.GREGORIAN);

        List<String> events = getListOfEvents(year, month);

        for (String event : events) {
            String[] separateDayAndEventName = event.split(" ", 2);
            int dayParsed = Integer.parseInt(separateDayAndEventName[0]);
            java.util.Date date = new java.util.Date(year, month, dayParsed);
            VEvent calendarEvent = new VEvent(new Date(date), separateDayAndEventName[1]);
            UidGenerator ug = new RandomUidGenerator();
            calendarEvent.getProperties().add(ug.generateUid());
            calendar.getComponents().add(calendarEvent);
        }
        return calendar;
    }
}
