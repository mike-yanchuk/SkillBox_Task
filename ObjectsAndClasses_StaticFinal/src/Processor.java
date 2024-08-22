public class Processor {
    private final int frequency; // частота
    private final int numberOfCores; // ядра(количество)
    private final String manufacturer; // производитель;
    private final double weight;


    public Processor(int frequency, int numberOfCores, String manufacturer, double weight) {
        this.frequency = frequency;
        this.numberOfCores = numberOfCores;
        this.manufacturer = manufacturer;
        this.weight = weight;
    }

    // гетеры

    public int getFrequency() {
        return frequency;
    }

    public int getNumberOfCores() {
        return numberOfCores;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public double getWeight() {
        return weight;
    }

    // сетеры

    public Processor setFrequency(int frequency) {
        return new Processor(frequency, numberOfCores, manufacturer, weight);
    }

    public Processor setNumberOfCores(int numberOfCores) {
        return new Processor(frequency, numberOfCores, manufacturer, weight);
    }

    public Processor setManufacturer(String manufacturer) {
        return new Processor(frequency, numberOfCores, manufacturer, weight);
    }

    public Processor setWeight(int weight) {
        return new Processor(frequency, numberOfCores, manufacturer, weight);
    }

    public String toString() {
        return "\n" + "    " + "Частота: "  + getFrequency() + "; " + "\n" +
                "    " + "Количество ядер: "  + getNumberOfCores() + "; " + "\n" +
                "    " + "Производитель: "  + getManufacturer() + "; " + "\n" +
                "    " + "Вес: "  + getWeight() + "; ";
    }
}
