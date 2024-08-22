
import java.util.Scanner;

import org.apache.logging.log4j.*;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);
    private static final String ADD_COMMAND = "add Василий Петров " +
            "vasily.petrov@gmail.com +79215637722";
    private static final String COMMAND_EXAMPLES = "\t" + ADD_COMMAND + "\n" +
            "\tlist\n\tcount\n\tremove Василий Петров";
    private static final String COMMAND_ERROR = "Wrong command! Available command examples: \n" +
            COMMAND_EXAMPLES;
    private static final String helpText = "Command examples:\n" + COMMAND_EXAMPLES;

    public static void main(String[] args) {
        String text = "словили исключение - ArrayIndexOutOfBoundsException";
        Scanner scanner = new Scanner(System.in);
        CustomerStorage executor = new CustomerStorage();


        while (true) {
            String command = scanner.nextLine();
            String[] tokens = command.split("\\s+", 2);

            if (tokens[0].equals("add")) {
                logger.info("Пользователь ввел команду * add *");
                try {

                    executor.addCustomer(tokens[1]);
                } catch (ArrayIndexOutOfBoundsException e) {
                    logger.error("{}",text);
                    System.out.println("Введены не все данные");
                }


            } else if (tokens[0].equals("list")) {
                logger.info("Пользователь ввел команду * list *");
                executor.listCustomers();
            } else if (tokens[0].equals("remove")) {
                logger.info("Пользователь ввел команду * remove *");
                executor.removeCustomer(tokens[1]);
            } else if (tokens[0].equals("count")) {
                logger.info("Пользователь ввел команду * count *");
                System.out.println("There are " + executor.getCount() + " customers");
            } else if (tokens[0].equals("help")) {
                logger.info("Пользователь ввел команду * count *");
                System.out.println(helpText);
            } else {
                logger.info("Пользователь ввел команду * empty *");
                System.out.println(COMMAND_ERROR);
            }
        }
    }
}
