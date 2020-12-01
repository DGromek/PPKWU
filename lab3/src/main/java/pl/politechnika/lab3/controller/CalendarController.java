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
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


@Controller
public class CalendarController {

    @GetMapping("/weeiaCalendar")
    public ResponseEntity<String> getICSCalendar(@RequestParam int month) throws IOException, ParseException {
        if (!isCorrectMonth(month)) {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
        String formatted = String.format("%02d", month);
        getWEEIACalendarForGivenMonth(month);
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

    private Calendar getWEEIACalendarForGivenMonth(int month) throws IOException, ParseException {
        Calendar calendar = new Calendar();
        calendar.getProperties().add(new ProdId("WEEIACalendar"));
        calendar.getProperties().add(Version.VERSION_2_0);
        calendar.getProperties().add(CalScale.GREGORIAN);

        int currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
        String monthInCorrectFormat = String.format("%02d", month);
        String dateToFill = currentYear + monthInCorrectFormat;
        List<String> events = getListOfEvents(String.format("%02d", month));

        for (String event : events) {
            String[] separateDayAndEventName = event.split(" ", 2);
            VEvent calendarEvent = new VEvent(new Date(dateToFill + String.format("%02d", Integer.parseInt(separateDayAndEventName[0]))), separateDayAndEventName[1]);
            UidGenerator ug = new RandomUidGenerator();
            calendarEvent.getProperties().add(ug.generateUid());
            calendar.getComponents().add(calendarEvent);
        }
        return calendar;
    }
}
