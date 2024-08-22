public class Main {

    public static double allWeight;

    public static void main(String[] args) {
        Processor processor = new Processor(
                1,
                2,
                "I9",
                4);

        RAM ram = new RAM(
                "Типок",
                1,
                1);

        InformationStorage informationStorage = new InformationStorage(
                TypeInformationStorage.SSD,
                1,
                1);

        Screen screen = new Screen(
                1,
                TypeScreen.VA,
                1);

        Keyboard keyboard = new Keyboard(
                1,
                false,
                1);

        Computer computer = new Computer("Меладзе","коп", processor, ram, informationStorage, screen, keyboard);
        System.out.println(computer);
        System.out.println(computer.allWeight());
        System.out.println();

        Processor processor1 = new Processor(
                1,
                2,
                "I9",
                4);

        RAM ram1 = new RAM(
                "Типок",
                1,
                1);

        InformationStorage informationStorage1 = new InformationStorage(
                TypeInformationStorage.SSD,
                1,
                1);

        Screen screen1 = new Screen(
                1,
                TypeScreen.VA,
                1);

        Keyboard keyboard1 = new Keyboard(
                1,
                false,
                2);

        Computer computer1 = new Computer("Меладзе","коп", processor1, ram1, informationStorage1, screen1, keyboard1);


        System.out.println(computer1);
        System.out.println(computer1.allWeight());
        System.out.println();

    }
}
