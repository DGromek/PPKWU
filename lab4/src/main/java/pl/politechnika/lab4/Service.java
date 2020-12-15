package pl.politechnika.lab4;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Service {
    private String name;
    private String address;
    private String phone;
    private String email;

    public String generateVCard() {
        return "BEGIN:VCARD\n" +
                "VERSION:4.0\n" +
                "N:" + name + ";Forrest;;;\n" +
                "TEL;TYPE=work,voice;VALUE=uri:tel:" + phone + "\n" +
                "EMAIL:" + email + "\n" +
                "ADR;TYPE=WORK,PREF:" + address + "\n" +
                "END:VCARD";
    }
}
