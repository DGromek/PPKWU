package pl.politechnika.lab4;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VCardController {

    @GetMapping("/services")
    public ResponseEntity<Service> getServices() {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
