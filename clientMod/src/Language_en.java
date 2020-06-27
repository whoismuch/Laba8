import java.util.ListResourceBundle;

public class Language_en extends ListResourceBundle {
    @Override
    public Object[][] getContents ( ) {
        return contents;
    }

    private Object[][] contents = {
            {"add", "Add a route"},
            {"sum_of_distance", "Sum of route distances"},
            {"history", "History"},
            {"info", "Information"},
            {"execute_script", "Run script"},
            {"clear", "Clear Collection"},
            {"filter_less_than_distance", "Show shorter routes"},
            {"print_ascending", "Show collection in ascending order"},
            {"remove_lower", "Remove routes that are greater than the specified"},
            {"remove_greater", "Remove routes that are less than the specified"},
            {"blup", "You can poke and relieve stress"},
            {"add1", "Add route"},
            {"sum_of_distance1", "Sum of distance of routes"},
            {"history1", "History"},
            {"info1", "Information"},
            {"execute_script1", "Run the script"},
            {"clear1", "Clear Collection"},
            {"filter_less_than_distance1", "Show routes with shorter distances"},
            {"print_ascending1", "Show collection in ascending order"},
            {"remove_lower1", "Remove routes that are greater than the specified"},
            {"remove_greater1", "Remove routes that are less than the specified"},
            {"blup1", "You can poke and relieve stress"},
            {"user", "User:"},
            {"user1", "User:"},
            {"language", "Select a language"},
            {"language1", "Select a language"},
            {"graphics", "Graphics"},
            {"collection", "Collection"},
            {"owner", "Owner"},
            {"id", "id"},
            {"name", "Route Name"},
            {"coordinateX", "Current X"},
            {"coordinateY", "Current Y"},
            {"creationDate", "Creation Date"},
            {"fromName", "Shipment Name"},
            {"fromX", "Departure X"},
            {"fromY", "Departure Y"},
            {"toName", "Arrival Name"},
            {"toX", "Arrival X"},
            {"toY", "Arrival Y"},
            {"distance", "Distance"},
            {"connect", "Establish a connection..."},
            {"enterAddress", "Enter Address"},
            {"enterPort", "Enter Port"},
            {"Ууууу, в адресе не должно быть пробелов", "Uuuuu, there must be no spaces in the address"},
            {"Порт с пробелами, серьезно? Зачем?", "Port with spaces, seriously? Why?"},
            {"Такого адреса, к сожалению, не существует", "Unfortunately, this address does not exist"},
            {"Порт должен быть циферкой", "Port must be a number"},
            {"Соединение установлено", "Connection established"},
            {"buttonConnect", "Connect"},
            {"inLK", "Account Login"},
            {"user", "Login"},
            {"pass", "Password"},
            {"signUp", "Sign up"},
            {"signIn", "Sign in"},
            {"Пользователь с таким логином уже зарегистрирован. Может, вам стоит авторизоваться?", "A user with such a login is already registered. Maybe you should log in?"},
            {"Вы успешно зарегистрировались", "You have successfully registered"},
            {"Пользователь с таким логином не зарегистрирован", "A user with such a login is not registered"},
            {"Вы успешно авторизовались", "You have successfully logged in"},
            {"Вы ввели неправильный пароль", "You entered the wrong password"},
            {"Вам следует использовать только латиницу( Вините helios, не меня", "You should only use the Latin alphabet (Blame helios, not me"}

    };

}
