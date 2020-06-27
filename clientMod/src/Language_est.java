import java.util.ListResourceBundle;

public class Language_est extends ListResourceBundle {
    @Override
    public Object[][] getContents ( ) {
        return contents;
    }

    private Object[][] contents = {
            {"add", "Lisage marsruut"},
            {"sum_of_distance", "Marsruudi vahemaade summa"},
            {"history", "Ajalugu"},
            {"info", "Teave"},
            {"execute_script", "Käivita skript"},
            {"clear", "Tühjenda kogu"},
            {"filter_less_than_distance", "Näita lühemaid marsruute"},
            {"print_ascending", "Kuva kogu kasvavas järjekorras"},
            {"remove_lower", "Eemaldage täpsustatud marsruudid"},
            {"remove_greater", "Eemaldage täpsustatud marsruudid"},
            {"blup", "Võite näpistada ja stressi leevendada"},
            {"add1", "Add route"},
            {"sum_of_distance1", "Marsruutide vahemaade summa"},
            {"history1", "Ajalugu"},
            {"info1", "Teave"},
            {"execute_script1", "Käivita skript"},
            {"clear1", "Tühjenda kogu"},
            {"filter_less_than_distance1", "Kuva lühemate vahemaadega marsruute"},
            {"print_ascending1", "Kuva kogu kasvavas järjekorras"},
            {"remove_lower1", "Eemaldage täpsustatud marsruudid"},
            {"remove_greater1", "Eemaldage täpsustatud marsruudid"},
            {"blup1", "saate näpistada ja stressi leevendada"},
            {"user", "Kasutaja:"},
            {"user1", "Kasutaja:"},
            {"language", "Valige keel"},
            {"language", "valige keel"},
            {"graphics", "Graafika"},
            {"collection", "Kollektsioon"},
            {"owner", "Omanik"},
            {"id", "id"},
            {"name", "Marsruudi nimi"},
            {"coordinateX", "Praegune X"},
            {"coordinateY", "Praegune Y"},
            {"creationDate", "Loomise kuupäev"},
            {"fromName", "Saadetise nimi"},
            {"fromX", "Departure X"},
            {"fromY", "Departure Y"},
            {"toName", "Saabumise nimi"},
            {"toX", "Saabumine X"},
            {"toY", "Saabumine Y"},
            {"distance", "Distance"},
            {"connect", "looge ühendus..."},
            {"enterAddress", "Enter Address"},
            {"enterPort", "Enter Port"},
            {"Ууууу, в адресе не должно быть пробелов", "Uuuuu, aadressis ei tohi olla tühikuid"},
            {"Порт с пробелами, серьезно? Зачем?", "Tühikutega sadam, tõsiselt? Miks?"},
            {"Такого адреса, к сожалению, не существует", "Kahjuks pole seda aadressi olemas"},
            {"Порт должен быть циферкой", "Port peab olema number"},
            {"Соединение установлено", "Ühendus loodud"},
            {"buttonConnect", "Ühendage"}
    };
}
