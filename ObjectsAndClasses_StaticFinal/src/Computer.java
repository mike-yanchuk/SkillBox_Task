public class Computer {

    private final String vendor;
    private final String name;
    public Processor processor;
    public RAM ram;
    public InformationStorage informationStorage;
    public Screen screen;
    public Keyboard keyboard;
    public double allWeight;


    // констурктор c производителем
    public Computer(String vendor, String name, Processor processor, RAM ram, InformationStorage informationStorage, Screen screen, Keyboard keyboard) {
        this.vendor = vendor;
        this.name = name;
        this.processor = processor;
        this.ram = ram;
        this.informationStorage = informationStorage;
        this.screen = screen;
        this.keyboard = keyboard;
        this.allWeight = allWeight;
    }

    public Processor getProcessor() {
        return processor;
    }

    public RAM getRam() {
        return ram;
    }

    public InformationStorage getInformationStorage() {
        return informationStorage;
    }

    public Screen getScreen() {
        return screen;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public void setRam(RAM ram) {
        this.ram = ram;
    }

    public void setInformationStorage(InformationStorage informationStorage) {
        this.informationStorage = informationStorage;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public void setKeyboard(Keyboard keyboard) {
        this.keyboard = keyboard;
    }

    public double allWeight(){
        return  allWeight = processor.getWeight() + ram.getWeight() + informationStorage.getWeight() + screen.getWeight() + keyboard.getWeight();

    }


        public String toString() {
            return "Процессор: " + processor + "\n" +
                    "Рамка: " + ram + "\n" +
                    "Обьемная память: " + informationStorage + "\n" +
                    "Монитор: " + screen + "\n" +
                    "Клавиатура: " + keyboard + "\n";

        }


}
