package pl.politechnika.lab4;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class VCardController {

    @GetMapping("/services")
    public ResponseEntity<Service> getServices(@RequestParam String searchParam) {
        try {
            Document doc = Jsoup.connect("https://panoramafirm.pl/szukaj?k=" + searchParam).get();
            Elements profiles = doc.getElementsByClass("company-item");
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }
}
