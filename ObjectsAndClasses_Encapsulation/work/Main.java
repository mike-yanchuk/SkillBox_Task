import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Elevator elevator = new Elevator(-3, 26);
        while (true) {
            System.out.print("Введите номер этажа: ");
            int floor = new Scanner(System.in).nextInt();
            elevator.move(floor);

            break;
        }


        Dimensions dimensions = new Dimensions(104.45,116.56,456.1111);
        Home home = new Home(
                dimensions,
                "Улица пушкина, дом калатушкина",
                104.45,
                116.56,
                456.1111,
                50,
                false,
                "5496584gh18238",
                true);


        Home copy = new Home(
                home.getDimensions(),
                home.getAdres(),
                home.getHeight(),
                home.getLength(),
                home.getWidth(),
                home.getWeight(),
                home.getCoup(),
                home.getRegistrationNumber(),
                home.getFragile()
        );

        Home variant =  home.setDimensions(dimensions).setAdres("другой").setWeight(59.3); // меняем


        System.out.println(home);
        System.out.println(dimensions);

        System.out.println(copy);
        System.out.println(dimensions);

        System.out.println(variant);
        System.out.println(dimensions);
    }


}
