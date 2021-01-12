<h1>GET /services</h1>
Returns list of companies with name provided in parameter <a>https://panoramafirm.pl/szukaj</a>

<h2>Example request</h2>
<code>GET localhost:8080/services?searchParam=hydraulik</code>

<h2>Returns</h2>
```
    {
        "name": "Fhu Nypel Usługi Hydrauliczne Łukasz Szydliński",
        "address": "ul. Cieszkowskiego 4/27, 41-303 Dąbrowa Górnicza",
        "phone": "698 095 573",
        "email": "brak"
    },
    {
        "name": "Hydraulika Montaż Instalacji Sanitarnych i Grzewczych Robert Rosłoniec",
        "address": "ul. Wierzbowa 12, 05-503 Robercin",
        "phone": "501 083 795",
        "email": "rrrobert@vp.pl"
    },
    {
        "name": "Kamil Przęczek",
        "address": "32-020 Grabówki 12",
        "phone": "516 765 572",
        "email": "kamilprzeczek@interia.pl"
    },
    {
        "name": "Adam Kołota Udrażnianie rur",
        "address": "ul. Zaciszna 30A, 05-230 Kobyłka",
        "phone": "781 266 854",
        "email": "joanna-kolota@wp.pl"
    },
    {
        "name": "Hydro Seb FU Sebastian Jeziorowski",
        "address": "ul. Mirowska 42-202 Częstochowa",
        "phone": "502 220 475",
        "email": "hydroseb@op.pl"
    },
    {
        "name": "Kaz-Bud Bramy, ogrodzenia, usługi hydrauliczne Kazimierz Kuzioła",
        "address": "24-220 Strzeszkowice Małe",
        "phone": "669 591 968",
        "email": "kaz.bud@wp.pl"
    },
    {
        "name": "Łukasz Noga Prima Sort",
        "address": "al. Dębowa 21, 32-005 Niepołomice",
        "phone": "536 792 675",
        "email": "kontakt@primasortinstalacje.pl"
    },
    {
        "name": "HDK Hydraulika Krzysztof Danielewicz",
        "address": "ul. Borsucza 3a, 05-410 Józefów",
        "phone": "791 851 671",
        "email": "hydraulikawarszawa24@gmail.com"
    },
    {
        "name": "Hydrowat. PUH. Instalacje hydrauliczne i klimatyzacja. Kaczmarczyk W.",
        "address": "ul. Cyganerii 13/31, 43-100 Tychy",
        "phone": "501 694 091",
        "email": "hydrowat@gmail.com"
    },
    {
        "name": "Hydro Seb FU Sebastian Jeziorowski",
        "address": "ul. Śmiłowskiego 8/10, 41-100 Siemianowice Śląskie",
        "phone": "502 220 475",
        "email": "hydroseb@op.pl"
    },
    {
        "name": "Gamar Marek Garliński",
        "address": "ul. Daszyńskiego 10 F/3, 56-400 Oleśnica",
        "phone": "601 746 608",
        "email": "marekgarlinski@wp.pl"
    },
    {
        "name": "Jacoterm Instalacje wod-kan. gazowe Jacek Stępnik",
        "address": "ul. Górna 20/116, 25-415 Kielce",
        "phone": "509 073 924",
        "email": "jacek_sash@interia.pl"
    },
    {
        "name": "Instalacje Mw Wyciek Zalanie Osuszanie",
        "address": "ul. Pełczyńska 119, 51-180 Wrocław",
        "phone": "516 706 260",
        "email": "instalacjemw@o2.pl"
    },
    {
        "name": "Łukasz Radochoński Hydroanet",
        "address": "37-722 Wyszatyce 231",
        "phone": "695 155 269",
        "email": "hydroanet13@gmail.com"
    },
    {
        "name": "Michsan Zakład Instalacyjno-Budowlany",
        "address": "ul. Warmińska 7, 42-202 Częstochowa",
        "phone": "(34) 362 89 45",
        "email": "michsan@onet.pl"
    },
    {
        "name": "Instal Term Piotr Rachwalik",
        "address": "ul. Szczecińska 52, Świdwin",
        "phone": "798 574 244",
        "email": "biuro@instal-term.com.pl"
    },
    {
        "name": "Technika Grzewcza I Sanitarna Instal Paweł Szeląg",
        "address": "24-120 Zbędowice 13",
        "phone": "515 079 481",
        "email": "tgis.instal@gmail.com"
    },
    {
        "name": "Technika Grzewcza I Sanitarna Instal Paweł Szeląg",
        "address": "24-120 Zbędowice 13",
        "phone": "515 079 481",
        "email": "tgis.instal@gmail.com"
    },
    {
        "name": "M-Instalacje Michał Filipkiewicz",
        "address": "ul. Słomiana 4/44, 30-316 Kraków",
        "phone": "508 455 843",
        "email": "instalacje.filipkiewicz@gmail.com"
    },
    {
        "name": "Ilmar Technika Grzewcza Jerzy Ilków",
        "address": "pl. Stanisława Staszica 15/8, 50-238 Wrocław",
        "phone": "601 787 666",
        "email": "ilmar@wp.pl"
    },
    {
        "name": "Hydro Instal Przyłącza Wod-Kan",
        "address": "ul. Chorzowska 3, 26-603 Radom",
        "phone": "728 916 865",
        "email": "hydro-instal11@wp.pl"
    },
    {
        "name": "H&H INSTALACJE",
        "address": "84-210 Łętowo 3 lok. 4",
        "phone": "512 139 545",
        "email": "h.h.instalacje@gmail.com"
    },
    {
        "name": "Hydro Seb FU Sebastian Jeziorowski",
        "address": "42-244 Srocko 64",
        "phone": "502 220 475",
        "email": "hydroseb@op.pl"
    },
    {
        "name": "Grześpol PHU Grzegorz Polasiński",
        "address": "ul. Lipowa 82/20, 90-568 Łódź",
        "phone": "606 986 460",
        "email": "grzespol@op.pl"
    },
    {
        "name": "Hydro-Electric Usługi elektryczne i hydrauliczne Stanisław Wąsik",
        "address": "36-100 Kolbuszowa Górna 300",
        "phone": "730 530 893",
        "email": "wasik.stanislaw91@wp.pl"
    }
```

<h1>GET /vCard</h1>
Returns VCard for name, address, email and phone number provided in parameters

<h2>Example request</h2>
```GET http://localhost:8080/vCard?name=Fhu+Nypel+Us%C5%82ugi+Hydrauliczne+%C5%81ukasz+Szydli%C5%84ski&address=ul.+Cieszkowskiego+4%2F27,+41-303+D%C4%85browa+G%C3%B3rnicza&phone=698+095+573&email=brak'```

<h2>Returns</h2>
```
"BEGIN:VCARD
VERSION:4.0
N:Fhu Nypel Usługi Hydrauliczne Łukasz Szydliński;Forrest;;;
TEL;TYPE=work,voice;VALUE=uri:tel:698 095 573
EMAIL:brak
ADR;TYPE=WORK,PREF:ul. Cieszkowskiego 4/27, 41-303 Dąbrowa Górnicza
END:VCARD"
```

