package pl.politechnika.lab4;

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
public class VCardController {

    @GetMapping("/services")
    public ResponseEntity<List<Service>> getServices(@RequestParam String searchParam) {
        try {
            Document doc = Jsoup.connect("https://panoramafirm.pl/szukaj?k=" + searchParam).get();
            Elements profiles = doc.getElementsByClass("company-item");
            List<Service> services = new ArrayList<>();

            for (Element profile : profiles) {
                Service service = new Service();
                service.setName(profile.getElementsByClass("company-name").text());
                service.setAddress(profile.getElementsByClass("address").text());
                service.setPhone(profile.getElementsByClass("icon-telephone").attr("title"));
                service.setEmail(profile.getElementsByClass("icon-envelope").attr("data-company-email"));
                services.add(service);
            }
            return new ResponseEntity<>(services, HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }
}
