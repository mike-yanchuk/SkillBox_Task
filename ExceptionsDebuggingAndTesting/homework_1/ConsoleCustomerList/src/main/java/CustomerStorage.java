
import org.apache.logging.log4j.*;
import java.util.HashMap;
import java.util.Map;

public class CustomerStorage {
    private final Map<String, Customer> storage;
    private final Logger logger = LogManager.getLogger(CustomerStorage.class);
    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) {
        String text = "Словили исключение IncorrectNumberOfComponents";
        final int INDEX_NAME = 0;
        final int INDEX_SURNAME = 1;
        final int INDEX_EMAIL = 2;
        final int INDEX_PHONE = 3;

        String[] components = data.split("\\s+"); // через if
        if(patternEmail(components[2]) || patternNumberPhone(components[3])){
            logger.error("{}",text);
            throw new IncorrectNumberOfComponents("Не правльно введена информация");
        }
        String name = components[INDEX_NAME] + " " + components[INDEX_SURNAME];
        storage.put(name, new Customer(name, components[INDEX_PHONE], components[INDEX_EMAIL]));
    }


    public boolean patternNumberPhone(String numberPhone){
        return !numberPhone.matches( "[+]" +"[7]" + "[0-9]{10}");
    }
    public boolean patternEmail(String emailUser){
        return !emailUser.matches("[a-zA-Z/]{0,10}" + "@{1}" + "[A-Za-z]{0,10}" + "[.]{1}" + "[a-z]{2}");
    }

    public void listCustomers() {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) {
        storage.remove(name);
    }

    public Customer getCustomer(String name) {
        return storage.get(name);
    }

    public int getCount() {
        return storage.size();
    }
}









