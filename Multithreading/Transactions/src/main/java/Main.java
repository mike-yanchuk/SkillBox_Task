import javax.imageio.metadata.IIOMetadataFormatImpl;
import java.util.ArrayList;

public class Main {



    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 3; i++) {
            new Thread(new MyThread()).start();
        }
    }

}
class MyThread implements Runnable {

    private static Bank belarusBank = new Bank();
    private static Account accountMisha = new Account(1_000_000, "4254 1289 8302 9102", "Миша");
    private static Account accountSanya = new Account(5_000_000, "4254 1111 4890 1995", "Саня");
    private static Account accountKola = new Account(3_000_000, "4800 4010 0348 8184", "Коля");
    private static Account accountRody = new Account(2_000_000, "2323 2390 0692 8968", "Родя");

    @Override
    public void run() {
        try {
            belarusBank.setAccounts(accountMisha);
            belarusBank.setAccounts(accountSanya);
            belarusBank.setAccounts(accountKola);
            belarusBank.setAccounts(accountRody);

            belarusBank.transfer(accountMisha.getAccNumber(), accountSanya.getAccNumber(), 50_000);
            belarusBank.transfer(accountMisha.getAccNumber(), accountSanya.getAccNumber(), 50_000);
            belarusBank.transfer(accountKola.getAccNumber(), accountSanya.getAccNumber(), 100_000);
            belarusBank.transfer(accountKola.getAccNumber(), accountRody.getAccNumber(), 200_000);
            belarusBank.transfer(accountMisha.getAccNumber(), accountSanya.getAccNumber(), 50_000);
            belarusBank.transfer(accountKola.getAccNumber(), accountSanya.getAccNumber(), 100_000);
            belarusBank.transfer(accountKola.getAccNumber(), accountRody.getAccNumber(), 200_000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
